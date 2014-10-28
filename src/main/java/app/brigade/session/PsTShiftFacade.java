/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.session;

import app.brigade.entity.PsTShift;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Илья
 */
@Stateless
public class PsTShiftFacade extends AbstractFacade<PsTShift> {
    @PersistenceContext(unitName = "app_brigade_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PsTShiftFacade() {
        super(PsTShift.class);
    }
    
}
