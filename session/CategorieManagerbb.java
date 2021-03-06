





package session;

import entities.Categorie;
import entities.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class CategorieManagerbb {
    
      @PersistenceContext(unitName = "TERBDTEST-ejbPU")
        private EntityManager em;
      
      private Categorie categorie=new Categorie();
      
      private Produit produit=new Produit();
      
        
      
      
      public List<Categorie> getAllCategories() {
        Query query = em.createNamedQuery("Categorie.findAll");  
        return query.getResultList(); }
      
      
         
     public Collection<Produit> getAllProducts() {
           Query query = em.createNamedQuery("Produit.findAll");  
        return query.getResultList(); 
    
              }

             
             public Categorie getCategorie(int catid) { 
                 return categorie= em.find(Categorie.class, catid); 
             }
             
             
             public Collection<Produit> getProductByCategorie(int catid) {  
                     
             Collection<Produit> produit = em.createNamedQuery("Produit.findAll").getResultList(); 
            
             Collection<Produit> maliste=new ArrayList<>(); 
             Iterator<Produit> it=produit.iterator();
             while(it.hasNext()){
                 
                 Produit p=it.next();
                 if(p.getCategorieid().getCategorieid()==catid)
                         {maliste.add(p);}
             }
        return maliste; 
            
    }                
         

      
       public Categorie updateCat(Categorie cat ) {return em.merge(cat); }
    

    
       public void removeCat(Categorie cat){
           
           cat = em.find(Categorie.class, cat.getCategorieid());
            em.remove(cat);
         
               }
       
       

          public Categorie addCat( Categorie c){ 
             
              
              persist(c);return c;
                                            }
             
             
             
             
             
          public void persist(Object object) {
        em.persist(object);
    }
}
