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
import org.omg.CORBA.UserException;

/**
 *
 * @author ely
 */
@Stateless
@LocalBean
public class UserServiceManager {
    @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;

    public Client inscription(Client user) throws UserException{
      List<Client> cli=em.createNamedQuery("Client.findByEmail").setParameter("email", user.getEmail()).getResultList();
      
      if(!cli.isEmpty())
      {
          throw  new  UserException() {};
      }
      else
      {
          em.persist(user);
          return user;
      }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    public Client login(String nom, String email)
    {
      
    Client cl=    (Client) em.createNamedQuery("Client.findByEmail").setParameter("email", email).getSingleResult();
    
 
 
        System.out.println("test email"+cl.getEmail());
        return cl;       // return em.find(Client.class, email); 
     
      

    
    //return logged;
    
    }
    
    
}
