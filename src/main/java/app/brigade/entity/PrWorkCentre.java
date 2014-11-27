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
@Table(name = "pr_work_centre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrWorkCentre.findAll", query = "SELECT p FROM PrWorkCentre p"),
    @NamedQuery(name = "PrWorkCentre.findByWcId", query = "SELECT p FROM PrWorkCentre p WHERE p.wcId = :wcId"),
    @NamedQuery(name = "PrWorkCentre.findByTextR", query = "SELECT p FROM PrWorkCentre p WHERE p.textR = :textR"),
    @NamedQuery(name = "PrWorkCentre.findWcId", query = "SELECT p.wcId FROM PrWorkCentre p")})
public class PrWorkCentre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "wc_id")
    private Integer wcId;
    @Size(max = 40)
    @Column(name = "text_r")
    private String textR;
    @JoinColumn(name = "t_shift_id", referencedColumnName = "t_shift_id")
    @ManyToOne
    private PsTShift tShiftId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wcId")
    private Collection<PsBgraf> psBgrafCollection;
    @OneToMany(mappedBy = "wcId")
    private Collection<PsBrigade> psBrigadeCollection;
    @OneToMany(mappedBy = "wcId")
    private Collection<PsPerson> psPersonCollection;

    public PrWorkCentre() {
    }

    public PrWorkCentre(Integer wcId) {
        this.wcId = wcId;
    }

    public Integer getWcId() {
        return wcId;
    }

    public void setWcId(Integer wcId) {
        this.wcId = wcId;
    }

    public String getTextR() {
        return textR;
    }

    public void setTextR(String textR) {
        this.textR = textR;
    }

    public PsTShift getTShiftId() {
        return tShiftId;
    }

    public void setTShiftId(PsTShift tShiftId) {
        this.tShiftId = tShiftId;
    }

    @XmlTransient
    public Collection<PsBgraf> getPsBgrafCollection() {
        return psBgrafCollection;
    }

    public void setPsBgrafCollection(Collection<PsBgraf> psBgrafCollection) {
        this.psBgrafCollection = psBgrafCollection;
    }

    @XmlTransient
    public Collection<PsBrigade> getPsBrigadeCollection() {
        return psBrigadeCollection;
    }

    public void setPsBrigadeCollection(Collection<PsBrigade> psBrigadeCollection) {
        this.psBrigadeCollection = psBrigadeCollection;
    }

    @XmlTransient
    public Collection<PsPerson> getPsPersonCollection() {
        return psPersonCollection;
    }

    public void setPsPersonCollection(Collection<PsPerson> psPersonCollection) {
        this.psPersonCollection = psPersonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wcId != null ? wcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrWorkCentre)) {
            return false;
        }
        PrWorkCentre other = (PrWorkCentre) object;
        if ((this.wcId == null && other.wcId != null) || (this.wcId != null && !this.wcId.equals(other.wcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return wcId.toString();
    }

}
