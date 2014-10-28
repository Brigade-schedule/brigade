/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Илья
 */
@Entity
@Table(name = "ps_bgraf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsBgraf.findAll", query = "SELECT p FROM PsBgraf p"),
    @NamedQuery(name = "PsBgraf.findByBgrafId", query = "SELECT p FROM PsBgraf p WHERE p.bgrafId = :bgrafId"),
    @NamedQuery(name = "PsBgraf.findByDdBgraf", query = "SELECT p FROM PsBgraf p WHERE p.ddBgraf = :ddBgraf"),
    @NamedQuery(name = "PsBgraf.findByMasterUserId", query = "SELECT p FROM PsBgraf p WHERE p.masterUserId = :masterUserId"),
    @NamedQuery(name = "PsBgraf.findByUserId", query = "SELECT p FROM PsBgraf p WHERE p.userId = :userId"),
    @NamedQuery(name = "PsBgraf.findByDtIn", query = "SELECT p FROM PsBgraf p WHERE p.dtIn = :dtIn")})
public class PsBgraf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bgraf_id")
    private Integer bgrafId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dd_bgraf")
    @Temporal(TemporalType.DATE)
    private Date ddBgraf;
    @Size(max = 20)
    @Column(name = "master_user_id")
    private String masterUserId;
    @Size(max = 20)
    @Column(name = "user_id")
    private String userId;
    @Column(name = "dt_in")
    @Temporal(TemporalType.DATE)
    private Date dtIn;
    @JoinColumn(name = "wc_id", referencedColumnName = "wc_id")
    @ManyToOne(optional = false)
    private PrWorkCentre wcId;
    @JoinColumn(name = "pbrig_id", referencedColumnName = "brigade_id")
    @ManyToOne(optional = false)
    private PsBrigade pbrigId;
    @JoinColumn(name = "fbrig_id", referencedColumnName = "brigade_id")
    @ManyToOne
    private PsBrigade fbrigId;
    @JoinColumn(name = "shift_id", referencedColumnName = "shift_id")
    @ManyToOne(optional = false)
    private PsShift shiftId;

    public PsBgraf() {
    }

    public PsBgraf(Integer bgrafId) {
        this.bgrafId = bgrafId;
    }

    public PsBgraf(Integer bgrafId, Date ddBgraf) {
        this.bgrafId = bgrafId;
        this.ddBgraf = ddBgraf;
    }

    public Integer getBgrafId() {
        return bgrafId;
    }

    public void setBgrafId(Integer bgrafId) {
        this.bgrafId = bgrafId;
    }

    public Date getDdBgraf() {
        return ddBgraf;
    }

    public void setDdBgraf(Date ddBgraf) {
        this.ddBgraf = ddBgraf;
    }

    public String getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(String masterUserId) {
        this.masterUserId = masterUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDtIn() {
        return dtIn;
    }

    public void setDtIn(Date dtIn) {
        this.dtIn = dtIn;
    }

    public PrWorkCentre getWcId() {
        return wcId;
    }

    public void setWcId(PrWorkCentre wcId) {
        this.wcId = wcId;
    }

    public PsBrigade getPbrigId() {
        return pbrigId;
    }

    public void setPbrigId(PsBrigade pbrigId) {
        this.pbrigId = pbrigId;
    }

    public PsBrigade getFbrigId() {
        return fbrigId;
    }

    public void setFbrigId(PsBrigade fbrigId) {
        this.fbrigId = fbrigId;
    }

    public PsShift getShiftId() {
        return shiftId;
    }

    public void setShiftId(PsShift shiftId) {
        this.shiftId = shiftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bgrafId != null ? bgrafId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsBgraf)) {
            return false;
        }
        PsBgraf other = (PsBgraf) object;
        if ((this.bgrafId == null && other.bgrafId != null) || (this.bgrafId != null && !this.bgrafId.equals(other.bgrafId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.brigade.entity.PsBgraf[ bgrafId=" + bgrafId + " ]";
    }
    
}
