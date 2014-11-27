package app.brigade.jsf;

import app.brigade.entity.PrWorkCentre;
import app.brigade.jsf.util.JsfUtil;
import app.brigade.jsf.util.JsfUtil.PersistAction;
import app.brigade.session.PrWorkCentreFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Named("prWorkCentreController")
@SessionScoped
public class PrWorkCentreController implements Serializable {

    @Inject
    private app.brigade.session.PrWorkCentreFacade ejbFacade;
    private List<PrWorkCentre> items = null;
    private List<PrWorkCentre> listWcId = null;
    private PrWorkCentre selected;
    

    public PrWorkCentreController() {
    }

    @PostConstruct
    private void init(){
        listWcId = ejbFacade.findWcId();
    }
    
    public PrWorkCentre getSelected() {
        return selected;
    }

    public void setSelected(PrWorkCentre selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PrWorkCentreFacade getFacade() {
        return ejbFacade;
    }

    public PrWorkCentre prepareCreate() {
        selected = new PrWorkCentre();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PrWorkCentreCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PrWorkCentreUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PrWorkCentreDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PrWorkCentre> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public List<PrWorkCentre> getListWcId() {
        return listWcId;
    }
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public PrWorkCentre getPrWorkCentre(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<PrWorkCentre> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PrWorkCentre> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PrWorkCentre.class)
    public static class PrWorkCentreControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PrWorkCentreController controller = (PrWorkCentreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "prWorkCentreController");
            return controller.getPrWorkCentre(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PrWorkCentre) {
                PrWorkCentre o = (PrWorkCentre) object;
                return getStringKey(o.getWcId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PrWorkCentre.class.getName()});
                return null;
            }
        }

    }

}
