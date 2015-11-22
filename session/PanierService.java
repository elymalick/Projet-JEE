/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Client;
import entities.Commande;
import entities.Lignecommandes;
import entities.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.omg.CORBA.UserException;

/**
 *
 * @author ely
 */

@Stateless
public class PanierService  {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "TERBDTEST-ejbPU")
    private EntityManager em;
   private Collection<Lignecommandes> com;
    Collection<Produit> mesproduits  =new ArrayList<>(); ;
//   public PanierService(){
//
//      
//   }
   
   public void add(int idproduit)
   {
  Produit p=  em.find(Produit.class, idproduit); 
     mesproduits.add(p);
  
   }
   
   
   public void remove(int idproduit)
   {
   Iterator<Produit> it=mesproduits.iterator();
   while(it.hasNext()){
   Produit p=it.next();
   if(p.getProduitid()==idproduit)
   {
       it.remove();
       return;
   }  
   
   }
   }
   

   public void validatePanier(int idClient) throws UserException
   {
       com = new ArrayList<>();
        Commande c=new Commande();
        Lignecommandes lc=new Lignecommandes();
       Client cl=em.find(Client.class, idClient);
       System.out.println("validaaaationnn commaanndeeee"+cl.getEmail()+cl.getNom());
       if(cl==null)
       {
         throw new UserException() {} ;
       }
       
       c.setClientid(cl);
        c.setStatut("Attente");
       lc.setCommande(c);
       for(Produit prd:mesproduits)
       {
          System.out.println("mes   produitsssssss"+prd.getNomproduit()+prd.getCategorieid());
       //   Lignecommandes lc=new Lignecommandes();
    
        lc.setProduit(prd);
//        prd.s
//         lc.setProduit(prd);
        //  com.add(lc);
          
           // Integer i= new Integer(idClient);
//          Commande c=new Commande();
//          c.setClientid(cl);
//            lc.setCommande(c);
                   
          
       }
     //    c.setClientid(cl);
         
          
        // Lignecommandes lc=new Lignecommandes();
        // lc.setProduit(prd);
//          c.setClientid(cl);
//                  c.setLignecommandesCollection(com);
                  
            em.persist(c);
              
   }
   
//     public void validatePanier()
//   {
//      
//       for(Produit prd:mesproduits)
//       {
//         
//          Lignecommandes lc=new Lignecommandes();
//        
//          lc.setProduit(prd);
//          com.add(lc);
//          
//           // Integer i= new Integer(idClient);
////          Commande c=new Commande();
////          c.setClientid(cl);
////            lc.setCommande(c);
//                   
//          
//       }
//       int cli=1;
//       Integer i= new Integer(cli);
//          Commande c=new Commande();
//          c.setStatut("Attente");
//         Client cc= new Client();
//         cc.setAdresse("montp");
//         cc.setCodepostal("33");
//         cc.setEmail("elyely@ely.com");
//         cc.setNom("aigle");
//         cc.setPays("fr");
//         cc.setRegion("mont");
//                 cc.setTelephone("33");
//                 cc.setVille("sete");
//              
//         
//          c.setClientid();
//          
//                  c.setLignecommandesCollection(com);
//                  
//            em.persist(c);
//              
//   }
   
  
   public void empty() {
mesproduits.clear();
}


//public Float getTotal() { 
//if (mesproduits == null || mesproduits.isEmpty()) 
//return 0f; 
//
//    BigDecimal total = null;
//for (Produit cartItem : mesproduits) {
//total += (cartItem.getPrixunitaire());
//}
//return total;
//}
   
    public Collection<Produit> getListProd()
{
    
    return mesproduits;
}

    public void persist(Object object) {
        em.persist(object);
    }
}
