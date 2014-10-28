/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Илья
 */
@Entity
@Table(name = "ps_t_shift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTShift.findAll", query = "SELECT p FROM PsTShift p"),
    @NamedQuery(name = "PsTShift.findByTShiftId", query = "SELECT p FROM PsTShift p WHERE p.tShiftId = :tShiftId"),
    @NamedQuery(name = "PsTShift.findByTextR", query = "SELECT p FROM PsTShift p WHERE p.textR = :textR"),
    @NamedQuery(name = "PsTShift.findByWorkDay", query = "SELECT p FROM PsTShift p WHERE p.workDay = :workDay"),
    @NamedQuery(name = "PsTShift.findByWeekDay", query = "SELECT p FROM PsTShift p WHERE p.weekDay = :weekDay"),
    @NamedQuery(name = "PsTShift.findByWorkTime", query = "SELECT p FROM PsTShift p WHERE p.workTime = :workTime"),
    @NamedQuery(name = "PsTShift.findByTamplWeek", query = "SELECT p FROM PsTShift p WHERE p.tamplWeek = :tamplWeek")})
public class PsTShift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_shift_id")
    private Integer tShiftId;
    @Size(max = 50)
    @Column(name = "text_r")
    private String textR;
    @Column(name = "work_day")
    private Integer workDay;
    @Column(name = "week_day")
    private Integer weekDay;
    @Column(name = "work_time")
    private Integer workTime;
    @Size(max = 50)
    @Column(name = "tampl_week")
    private String tamplWeek;
    @OneToMany(mappedBy = "tShiftId")
    private Collection<PrWorkCentre> prWorkCentreCollection;
    @OneToMany(mappedBy = "tShiftId")
    private Collection<PsShift> psShiftCollection;
    @OneToMany(mappedBy = "tShiftId")
    private Collection<PsBrigade> psBrigadeCollection;

    public PsTShift() {
    }

    public PsTShift(Integer tShiftId) {
        this.tShiftId = tShiftId;
    }

    public Integer getTShiftId() {
        return tShiftId;
    }

    public void setTShiftId(Integer tShiftId) {
        this.tShiftId = tShiftId;
    }

    public String getTextR() {
        return textR;
    }

    public void setTextR(String textR) {
        this.textR = textR;
    }

    public Integer getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Integer workDay) {
        this.workDay = workDay;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public String getTamplWeek() {
        return tamplWeek;
    }

    public void setTamplWeek(String tamplWeek) {
        this.tamplWeek = tamplWeek;
    }

    @XmlTransient
    public Collection<PrWorkCentre> getPrWorkCentreCollection() {
        return prWorkCentreCollection;
    }

    public void setPrWorkCentreCollection(Collection<PrWorkCentre> prWorkCentreCollection) {
        this.prWorkCentreCollection = prWorkCentreCollection;
    }

    @XmlTransient
    public Collection<PsShift> getPsShiftCollection() {
        return psShiftCollection;
    }

    public void setPsShiftCollection(Collection<PsShift> psShiftCollection) {
        this.psShiftCollection = psShiftCollection;
    }

    @XmlTransient
    public Collection<PsBrigade> getPsBrigadeCollection() {
        return psBrigadeCollection;
    }

    public void setPsBrigadeCollection(Collection<PsBrigade> psBrigadeCollection) {
        this.psBrigadeCollection = psBrigadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tShiftId != null ? tShiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTShift)) {
            return false;
        }
        PsTShift other = (PsTShift) object;
        if ((this.tShiftId == null && other.tShiftId != null) || (this.tShiftId != null && !this.tShiftId.equals(other.tShiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.brigade.entity.PsTShift[ tShiftId=" + tShiftId + " ]";
    }
    
}
