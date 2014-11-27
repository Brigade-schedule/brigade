/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.jsf.util;

import app.brigade.entity.PrWorkCentre;
import app.brigade.session.PrWorkCentreFacade;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


/**
 *
 * @author silver
 */
@FacesConverter(value = "prWorkCentre")
public class PrWorkCentreConverter implements Converter{

    @Inject
    private PrWorkCentreFacade wcService;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println(value);
        if(value != null && value.trim().length() > 0) {
            try {
                System.out.println(value);
            PrWorkCentre wc = wcService.find(Integer.parseInt(value));
            return wc;
            } catch (Exception ex){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка преобразования", "Неверный ID рабочего центра"));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((PrWorkCentre)value).getWcId());
        } else {
            return null;
        }
    }
    
}
