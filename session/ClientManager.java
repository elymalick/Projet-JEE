/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author ely
 */
@Stateless
@LocalBean
public class ClientManager {
 @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
//   private Logger logger = Logger.getLogger(Constants.LOGGER_STATELESS);
//  public String  authenticate(String nom, String email)
//    {
//        
//       Query query = em.createNamedQuery("Categorie.findAll");  
//        return query.getResultList();  
//    
//    }
}
