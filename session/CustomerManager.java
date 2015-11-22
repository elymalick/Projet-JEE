/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ely
 */
@Stateless
@LocalBean
public class CustomerManager {
    @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;

    public List<Produit> getAllCustomer() {
        Query query = em.createNamedQuery("Produit.findAll");  
        return query.getResultList();  
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Produit update(Produit produit) {
        return em.merge(produit);  
    }

    public void persist(Object object) {
        em.persist(object);
    }
public Produit getCustomer(int idCustomer) {  
        return em.find(Produit.class, idCustomer);  
}  
      
    
}
