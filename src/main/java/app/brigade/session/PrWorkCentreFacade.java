/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.session;

import app.brigade.entity.PrWorkCentre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Илья
 */
@Stateless
public class PrWorkCentreFacade extends AbstractFacade<PrWorkCentre> {
    @PersistenceContext(unitName = "app_brigade_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<PrWorkCentre> findWcId() {
        return em.createNamedQuery("PrWorkCentre.findWcId", PrWorkCentre.class).getResultList();
 }
    
//    public PrWorkCentre tsForWc(PrWorkCentre wcId){
//        Query tsWc = em.createQuery("select wc.tShiftId from PsTShift ts where wc.tsId in :wcId");
//        tsWc.setParameter("wcId", wcId);
//        return (PrWorkCentre) tsWc.getSingleResult();
//    }
    
    public PrWorkCentreFacade() {
        super(PrWorkCentre.class);
    }
       
}
