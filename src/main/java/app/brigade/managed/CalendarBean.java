/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.managed;

import java.util.Date;  
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Илья
 */
@ManagedBean
public class CalendarBean {
    private Date date;
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
