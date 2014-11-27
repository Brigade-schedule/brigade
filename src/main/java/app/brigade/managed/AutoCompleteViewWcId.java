package app.brigade.managed;

import app.brigade.entity.PrWorkCentre;
import app.brigade.session.PrWorkCentreFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;




@Named
@RequestScoped
public class AutoCompleteViewWcId {

    //private PrWorkCentre wcId;
    private List<PrWorkCentre> listWc;
    
    @Inject
    private PrWorkCentreFacade service;
     
    @PostConstruct
    private void init(){
        listWc = service.findAll();
    }
    
    public  List<PrWorkCentre> completeWcId(String query) {
            List<PrWorkCentre> filteredWcId = new ArrayList<PrWorkCentre>();
        for (PrWorkCentre wc : listWc){
          if(wc.getTextR().startsWith(query)) {
                filteredWcId.add(wc);
                
            }  
        } 
        System.out.println("gg");
         
        return filteredWcId;
    }

//    public List<PrWorkCentre> getSelectedWcId() {
//        return listWc;
//    }
// 
//    public void setSelectedWcId(List<PrWorkCentre> selectedWcId) {
//        this.listWc = selectedWcId;
//    }
     
//    public void setService(PrWorkCentreFacade service) {
//        this.service = service;
//    }

//    public PrWorkCentre getWcId() {
//        return wcId;
//    }
//
//    public void setWcId(PrWorkCentre wcId) {
//        this.wcId = wcId;
//    }
//    
}