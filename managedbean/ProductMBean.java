/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Produit;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import session.ProductManagerbb;

/**
 *
 * @author ely
 */
@ManagedBean
@ViewScoped 
public class ProductMBean {
    @EJB
    private ProductManagerbb productManager;

    private Produit produit=new Produit();
    
    
          
    public List<Produit>getProducts() {  
        return productManager.getAllProducts();  
    }  
    
    /**
     * Creates a new instance of ProductMBean
     */
//    
        public String showDetails(int productId) {  
        return "ProductDetails?idProduct=" + productId;    } 
        
    public ProductMBean() {
    }
    
}
