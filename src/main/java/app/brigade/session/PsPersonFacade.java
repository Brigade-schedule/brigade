/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.session;

import app.brigade.entity.PsPerson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Илья
 */
@Stateless
public class PsPersonFacade extends AbstractFacade<PsPerson> {
    @PersistenceContext(unitName = "app_brigade_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PsPersonFacade() {
        super(PsPerson.class);
    }
    
}
