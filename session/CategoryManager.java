/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CategoryManager {
    @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;

    public List<Categorie> getAllCategoy() {
         Query query = em.createNamedQuery("Categorie.findAll");  
        return query.getResultList();  
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
     public Collection<Produit> getProductListByCategoryId(int catgoryId) {
         
         Collection<Produit> prod=em.createNamedQuery("Produit.findAll").getResultList();
         Collection<Produit> maliste=new ArrayList<>();
         
      Iterator<Produit> it=prod.iterator();
   while(it.hasNext()){
   Produit p=it.next();
   if(p.getCategorieid().getCategorieid() == catgoryId)
   {
       maliste.add(p);
   }  
   

   }
         
      return maliste;      
         
         
         
//         String req2="SELECT h.produitCollection FROM CATEGORIE h WHERE h.categorieid="+catgoryId;
//         String req="select PRIXUNITAIRE from  PRODUIT c LEFT JOIN CATEGORIE p where c.PRODUITID=p.CATEGORIEID AND p.CATEGORIEID="+catgoryId; ;
//        return  em.createNamedQuery(req2).getResultList();
    }
    public Categorie getCategoryByName(String categoryName) {
        return (Categorie) em.createNamedQuery("Categorie.findByNomcategorie").setParameter("nomcategorie", categoryName).getSingleResult();
    }
}
