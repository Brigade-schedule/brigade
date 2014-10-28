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
@Table(name = "ps_prof")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProf.findAll", query = "SELECT p FROM PsProf p"),
    @NamedQuery(name = "PsProf.findByProfId", query = "SELECT p FROM PsProf p WHERE p.profId = :profId"),
    @NamedQuery(name = "PsProf.findByWcId", query = "SELECT p FROM PsProf p WHERE p.wcId = :wcId"),
    @NamedQuery(name = "PsProf.findByTextR", query = "SELECT p FROM PsProf p WHERE p.textR = :textR"),
    @NamedQuery(name = "PsProf.findByNameProf", query = "SELECT p FROM PsProf p WHERE p.nameProf = :nameProf")})
public class PsProf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prof_id")
    private Integer profId;
    @Column(name = "wc_id")
    private Integer wcId;
    @Size(max = 30)
    @Column(name = "text_r")
    private String textR;
    @Size(max = 20)
    @Column(name = "name_prof")
    private String nameProf;
    @OneToMany(mappedBy = "profId")
    private Collection<PsPerson> psPersonCollection;

    public PsProf() {
    }

    public PsProf(Integer profId) {
        this.profId = profId;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
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

    public String getNameProf() {
        return nameProf;
    }

    public void setNameProf(String nameProf) {
        this.nameProf = nameProf;
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
        hash += (profId != null ? profId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProf)) {
            return false;
        }
        PsProf other = (PsProf) object;
        if ((this.profId == null && other.profId != null) || (this.profId != null && !this.profId.equals(other.profId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.brigade.entity.PsProf[ profId=" + profId + " ]";
    }
    
}
