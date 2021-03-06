/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Categorie;
import entities.Produit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import session.CategorieManagerbb;
import session.ProductManagerbb;

/**
 * @author ely
 */
@Named(value = "categorieMBeanbb")
@ViewScoped 
public class CategorieMBeanbb implements Serializable{
    @EJB
    private ProductManagerbb productManager;
    
    
        @EJB
    private CategorieManagerbb categoriemanager;
        private int idproduit;
        private Produit produit =new Produit();
        private Categorie categorie= new Categorie();
        private int categorieid ;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

        
        
    Collection<Produit> macollection=new  Collection<Produit>() {

            @Override
            public int size() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Iterator<Produit> iterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean add(Produit e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean containsAll(Collection<?> clctn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(Collection<? extends Produit> clctn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean removeAll(Collection<?> clctn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean retainAll(Collection<?> clctn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    
    
    public int getIdcategorie() {
        return categorieid;
    }

    public void setIdcategorie(int idcategorie) {
        this.categorieid = idcategorie;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    

        

        
        
        public List<Categorie> getAllCategories() {  
    return categoriemanager.getAllCategories();
}  
        
  
        
   public void loadCategorie() {  
    this.macollection = categoriemanager.getProductByCategorie(categorieid);  
   
  }  
   public void loadUneCat(){
   this.categorie=categoriemanager.getCategorie(categorieid);
   }

     public void loadUnProduit(){
   this.produit=productManager.getProduct(idproduit);
   }
   
   
    public Collection<Produit> getMacollection() {
        return macollection;
    }

    public void setMacollection(Collection<Produit> macollection) {
        this.macollection = macollection;
    }
    
       
       
    public String showListProduct(int categorieId)
    {
    return "ProduitListbb?categorieid=" + categorieId;
    }

     public String GestionCat(int categorieId)
    {
    return "GestionCategorie?categorieid=" + categorieId;
    }
     
     
       public String RetourCategorie()
    {
    return "CategorieList";
    }
     
     
       public String AjoutCat()
    {
    return "AjoutCategorie";
    }

    
    public CategorieMBeanbb() {
    }
    
    
    
      public String update() {  
  
    categorie = categoriemanager.updateCat(categorie);  
    return "CategorieList";  
  }  
  
    public String remove() {  
  
     categoriemanager.removeCat(categorie);  
    return "CategorieList";  
  }  
    
      
    public String addProduct(){
       productManager.addProduct(produit);  
    return "ProductList";
    }
  
   
    
}
