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
@Table(name = "ps_brigade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsBrigade.findAll", query = "SELECT p FROM PsBrigade p"),
    @NamedQuery(name = "PsBrigade.findByBrigadeId", query = "SELECT p FROM PsBrigade p WHERE p.brigadeId = :brigadeId"),
    @NamedQuery(name = "PsBrigade.findByBrigadeName", query = "SELECT p FROM PsBrigade p WHERE p.brigadeName = :brigadeName"),
    @NamedQuery(name = "PsBrigade.findByProfId", query = "SELECT p FROM PsBrigade p WHERE p.profId = :profId"),
    @NamedQuery(name = "PsBrigade.findByBrigadeNumber", query = "SELECT p FROM PsBrigade p WHERE p.brigadeNumber = :brigadeNumber"),
    @NamedQuery(name = "PsBrigade.findByMasterUserId", query = "SELECT p FROM PsBrigade p WHERE p.masterUserId = :masterUserId")})
public class PsBrigade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "brigade_id")
    private Integer brigadeId;
    @Size(max = 20)
    @Column(name = "brigade_name")
    private String brigadeName;
    @Column(name = "prof_id")
    private Integer profId;
    @Column(name = "brigade_number")
    private Integer brigadeNumber;
    @Size(max = 20)
    @Column(name = "master_user_id")
    private String masterUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pbrigId")
    private Collection<PsBgraf> psBgrafCollection;
    @OneToMany(mappedBy = "fbrigId")
    private Collection<PsBgraf> psBgrafCollection1;
    @JoinColumn(name = "wc_id", referencedColumnName = "wc_id")
    @ManyToOne
    private PrWorkCentre wcId;
    @JoinColumn(name = "t_shift_id", referencedColumnName = "t_shift_id")
    @ManyToOne
    private PsTShift tShiftId;
    @OneToMany(mappedBy = "brigadeId")
    private Collection<PsPerson> psPersonCollection;

    public PsBrigade() {
    }

    public PsBrigade(Integer brigadeId) {
        this.brigadeId = brigadeId;
    }

    public Integer getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Integer brigadeId) {
        this.brigadeId = brigadeId;
    }

    public String getBrigadeName() {
        return brigadeName;
    }

    public void setBrigadeName(String brigadeName) {
        this.brigadeName = brigadeName;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public Integer getBrigadeNumber() {
        return brigadeNumber;
    }

    public void setBrigadeNumber(Integer brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }

    public String getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(String masterUserId) {
        this.masterUserId = masterUserId;
    }

    @XmlTransient
    public Collection<PsBgraf> getPsBgrafCollection() {
        return psBgrafCollection;
    }

    public void setPsBgrafCollection(Collection<PsBgraf> psBgrafCollection) {
        this.psBgrafCollection = psBgrafCollection;
    }

    @XmlTransient
    public Collection<PsBgraf> getPsBgrafCollection1() {
        return psBgrafCollection1;
    }

    public void setPsBgrafCollection1(Collection<PsBgraf> psBgrafCollection1) {
        this.psBgrafCollection1 = psBgrafCollection1;
    }

    public PrWorkCentre getWcId() {
        return wcId;
    }

    public void setWcId(PrWorkCentre wcId) {
        this.wcId = wcId;
    }

    public PsTShift getTShiftId() {
        return tShiftId;
    }

    public void setTShiftId(PsTShift tShiftId) {
        this.tShiftId = tShiftId;
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
        hash += (brigadeId != null ? brigadeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsBrigade)) {
            return false;
        }
        PsBrigade other = (PsBrigade) object;
        if ((this.brigadeId == null && other.brigadeId != null) || (this.brigadeId != null && !this.brigadeId.equals(other.brigadeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.brigade.entity.PsBrigade[ brigadeId=" + brigadeId + " ]";
    }
    
}
