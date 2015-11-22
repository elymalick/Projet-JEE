/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Categorie;
import entities.Produit;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import session.CategorieManagerbb;
import session.ProductManagerbb;

/**
 *
 * @author ely
 */
@ManagedBean
@ViewScoped
public class ProductDetailMBeanbb {
    @EJB
    private ProductManagerbb productManager;

    private int produitid, categorieid;
    
    private Produit produit=new Produit();
    
              @EJB
    private CategorieManagerbb categoriemanager;
        
        private Categorie cat;
    
    
    
    
      
  public int getIdProduct() {  
    return produitid;  
  }  
  
  public void setIdProduct(int idCustomer) {  
    this.produitid = idCustomer;  
  }  

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
  
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property)
     * @return 
   */  
  public Produit getDetails() {  
    return produit;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
  
   */  
  public String update(int idproduit, String np, int qs , BigDecimal prix) {  
    System.out.println("###UPDATE###");  
    produit = productManager.update(idproduit, np,qs,prix);  
    return "CategorieList";  
  }  
  
    public String remove() {  
    System.out.println("###UPDATE###");  
     productManager.removeProduct(produit);  
    return "CategorieList";  
  }  
  
    public String add(){
       productManager.addProduct(produit);  
    return "CategorieList";
    }
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {  
    System.out.println("###LIST###");  
    return "CategorieList";  
  }  
  
  public void loadProduct() {  
    this.produit = productManager.getProduct(produitid);  
  }  
    
  


        
              
  public int getIdCategorie() {  
    return categorieid;  
  }  
  
  public void setIdCategorie(int idCustomer) {  
    this.categorieid = idCustomer;  
  }  
  
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property)
     * @return 
   */  
  public Categorie getDetail() {  
    return cat;  
  }  
        
   
        
        public List<Categorie> getAllCategories() {  
    return categoriemanager.getAllCategories();
}  

  
    
    public ProductDetailMBeanbb() {
         
    }
    
}
