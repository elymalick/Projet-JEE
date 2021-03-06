/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the tempcmlate in the editor.
 */

package session;


import entities.Client;
import entities.Commande;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ely
 */
@TransactionManagement
@Stateless
@LocalBean
public class CommandeManagerbb {

   @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;
   
   
   CustomerManager cm=new CustomerManager();
      
       public List<Commande> getAllCommandes() {

        Query query = em.createNamedQuery("Commande.findAll");  
        return query.getResultList(); 
    
    }
       
           public Commande updateCommande(int idCommande,String stat) {
   
            
               Commande  commande = em.find(Commande.class, idCommande);
             commande.setClientid(commande.getClientid());
             commande.setStatut(stat);
               
              return commande;
   }
           
              public Commande addCommande(Commande c){ persist(c);return c;}
           
                 public void removeCommande(Commande commande){
           
           commande = em.find(Commande.class, commande.getCommandeid());
            em.remove(commande);
         
            
   }
                 
       public Commande getCommande(int commandeid) {  
            return em.find(Commande.class, commandeid);  
            
    }  
      
         public Client getCustomer(int clientid) {  
            return em.find(Client.class, clientid);  
            
    }  

    public void persist(Object object) {
        em.persist(object);
    }
                 
                 

}


//http://stackoverflow.com/questions/11029260/jpa-with-jta-persist-entity-and-merge-cascaded-child-entities
