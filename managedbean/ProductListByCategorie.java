/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Produit;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import session.CategoryManager;

/**
 *
 * @author ely
 */
@Named(value = "productListByCategorie") 
@ViewScoped
public class ProductListByCategorie implements Serializable{
//@EJB
//    private CategoryManager categoryManager;
    /**
     * Creates a new instance of ProductListByCategorie
     */

    public ProductListByCategorie() {
    }
     public String showListProdutByCat(int categorieId) {  
        
        return "CategoryListProduit?categorieId=" + categorieId;  
    
    } 
     
     
}
