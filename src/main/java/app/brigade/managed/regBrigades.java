/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.managed;

import app.brigade.entity.PrWorkCentre;
import java.util.Date;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Илья
 */
@Named(value = "regBrigades")
@ViewScoped
public class regBrigades {

    private PrWorkCentre wcId;
    private Date date;
    
    
    /**
     * Creates a new instance of regBrigades
     */
    public regBrigades() {
    }

    public void lisn(){
        System.out.println(wcId);
    }
    
    public PrWorkCentre getWcId() {
        return wcId;
    }

    public void setWcId(PrWorkCentre wcId) {
        this.wcId = wcId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
