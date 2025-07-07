/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kohji
 */
@Stateless



public class UserAccountFacade extends AbstractFacade<UserAccount> {

    @PersistenceContext(unitName = "AMCAssignemnt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAccountFacade() {
        super(UserAccount.class);
    }

    public UserAccount findByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM UserAccount u WHERE u.username = :username", UserAccount.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null; 
        }
    }
}
