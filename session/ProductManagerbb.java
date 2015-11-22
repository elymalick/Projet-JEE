


package session;

import entities.Categorie;
import entities.Produit;
import java.math.BigDecimal;
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
public class ProductManagerbb {
    
    
        @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;

    public List<Produit> getAllProducts() {

        Query query = em.createNamedQuery("Produit.findAll");  
        return query.getResultList(); 
    
    }
    
        public Produit update(int idProduit, String np , int QS, BigDecimal prix ) {
 
            Produit  produit = em.find(Produit.class, idProduit);
            produit.setCategorieid(produit.getCategorieid());
            produit.setNomproduit(np);
            produit.setQuantiteenstock(QS);
            produit.setPrixunitaire(prix);
            
            
     return produit; 
     
    }
        

    

    
       public void removeProduct(Produit produit){
           
           produit = em.find(Produit.class, produit.getProduitid());
            em.remove(produit);
         
            
    }
    
        public Produit getProduct(int produitid) {  
            return em.find(Produit.class, produitid);  
            
    }  

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Produit addProduct(Produit c){ 
     
        persist(c);  return c;
}

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
