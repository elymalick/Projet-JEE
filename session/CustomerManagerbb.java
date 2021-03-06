/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Client;
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
public class CustomerManagerbb {
    @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;

    public List<Client> getAllCustomers() {

        Query query = em.createNamedQuery("Client.findAll");  
        return query.getResultList(); 
    
    }
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Client update(Client client ) {

     return em.merge(client); 
     
    }
    

    
       public void removeClient(Client client){
           
           client = em.find(Client.class, client.getClientid());
            em.remove(client);
         
            
   }
    
        public Client getCustomer(int clientid) {  
            return em.find(Client.class, clientid);  
            
    }  

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Client addClient(Client c){ persist(c);return c;
}
}


//http://stackoverflow.com/questions/3716718/jsf-error-target-unreachable-null-returned-null
