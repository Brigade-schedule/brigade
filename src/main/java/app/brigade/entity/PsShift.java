/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ps_shift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsShift.findAll", query = "SELECT p FROM PsShift p"),
    @NamedQuery(name = "PsShift.findByShiftId", query = "SELECT p FROM PsShift p WHERE p.shiftId = :shiftId"),
    @NamedQuery(name = "PsShift.findByShiftName", query = "SELECT p FROM PsShift p WHERE p.shiftName = :shiftName"),
    @NamedQuery(name = "PsShift.findByTibeg", query = "SELECT p FROM PsShift p WHERE p.tibeg = :tibeg"),
    @NamedQuery(name = "PsShift.findByTiend", query = "SELECT p FROM PsShift p WHERE p.tiend = :tiend"),
    @NamedQuery(name = "PsShift.findByTextR", query = "SELECT p FROM PsShift p WHERE p.textR = :textR"),
    @NamedQuery(name = "PsShift.findByNHours", query = "SELECT p FROM PsShift p WHERE p.nHours = :nHours")})
public class PsShift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shift_id")
    private Integer shiftId;
    @Size(max = 20)
    @Column(name = "shift_name")
    private String shiftName;
    @Column(name = "tibeg")
    private Integer tibeg;
    @Column(name = "tiend")
    private Integer tiend;
    @Size(max = 50)
    @Column(name = "text_r")
    private String textR;
    @Column(name = "n_hours")
    private Integer nHours;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shiftId")
    private Collection<PsBgraf> psBgrafCollection;
    @JoinColumn(name = "t_shift_id", referencedColumnName = "t_shift_id")
    @ManyToOne
    private PsTShift tShiftId;

    public PsShift() {
    }

    public PsShift(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public Integer getTibeg() {
        return tibeg;
    }

    public void setTibeg(Integer tibeg) {
        this.tibeg = tibeg;
    }

    public Integer getTiend() {
        return tiend;
    }

    public void setTiend(Integer tiend) {
        this.tiend = tiend;
    }

    public String getTextR() {
        return textR;
    }

    public void setTextR(String textR) {
        this.textR = textR;
    }

    public Integer getNHours() {
        return nHours;
    }

    public void setNHours(Integer nHours) {
        this.nHours = nHours;
    }

    @XmlTransient
    public Collection<PsBgraf> getPsBgrafCollection() {
        return psBgrafCollection;
    }

    public void setPsBgrafCollection(Collection<PsBgraf> psBgrafCollection) {
        this.psBgrafCollection = psBgrafCollection;
    }

    public PsTShift getTShiftId() {
        return tShiftId;
    }

    public void setTShiftId(PsTShift tShiftId) {
        this.tShiftId = tShiftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftId != null ? shiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsShift)) {
            return false;
        }
        PsShift other = (PsShift) object;
        if ((this.shiftId == null && other.shiftId != null) || (this.shiftId != null && !this.shiftId.equals(other.shiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return textR + "(" + shiftName + ")";
    }
    
}
