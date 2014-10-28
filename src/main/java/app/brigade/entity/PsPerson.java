/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Илья
 */
@Entity
@Table(name = "ps_person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPerson.findAll", query = "SELECT p FROM PsPerson p"),
    @NamedQuery(name = "PsPerson.findByUserId", query = "SELECT p FROM PsPerson p WHERE p.userId = :userId"),
    @NamedQuery(name = "PsPerson.findByTabnName", query = "SELECT p FROM PsPerson p WHERE p.tabnName = :tabnName"),
    @NamedQuery(name = "PsPerson.findByFamilyR", query = "SELECT p FROM PsPerson p WHERE p.familyR = :familyR")})
public class PsPerson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_id")
    private String userId;
    @Size(max = 10)
    @Column(name = "tabn_name")
    private String tabnName;
    @Size(max = 50)
    @Column(name = "family_r")
    private String familyR;
    @JoinColumn(name = "wc_id", referencedColumnName = "wc_id")
    @ManyToOne
    private PrWorkCentre wcId;
    @JoinColumn(name = "brigade_id", referencedColumnName = "brigade_id")
    @ManyToOne
    private PsBrigade brigadeId;
    @JoinColumn(name = "prof_id", referencedColumnName = "prof_id")
    @ManyToOne
    private PsProf profId;

    public PsPerson() {
    }

    public PsPerson(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTabnName() {
        return tabnName;
    }

    public void setTabnName(String tabnName) {
        this.tabnName = tabnName;
    }

    public String getFamilyR() {
        return familyR;
    }

    public void setFamilyR(String familyR) {
        this.familyR = familyR;
    }

    public PrWorkCentre getWcId() {
        return wcId;
    }

    public void setWcId(PrWorkCentre wcId) {
        this.wcId = wcId;
    }

    public PsBrigade getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(PsBrigade brigadeId) {
        this.brigadeId = brigadeId;
    }

    public PsProf getProfId() {
        return profId;
    }

    public void setProfId(PsProf profId) {
        this.profId = profId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPerson)) {
            return false;
        }
        PsPerson other = (PsPerson) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.brigade.entity.PsPerson[ userId=" + userId + " ]";
    }
    
}
