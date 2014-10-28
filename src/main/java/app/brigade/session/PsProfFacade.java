/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.session;

import app.brigade.entity.PsProf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Илья
 */
@Stateless
public class PsProfFacade extends AbstractFacade<PsProf> {
    @PersistenceContext(unitName = "app_brigade_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PsProfFacade() {
        super(PsProf.class);
    }
    
}
