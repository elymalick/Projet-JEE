/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Categorie;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import session.CategorieManagerbb;

/**
 *
 * @author ely
 */
@Named(value = "categorieADDBean")
@ViewScoped 
public class CategorieADDBean implements Serializable{
    
    
          @EJB
    private CategorieManagerbb categoriemanager;
          
                  private Categorie categorie= new Categorie();
        private int idcategorie ;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }
        
        
        
        
        
        
        
           public void loadUneCat(){
   this.categorie=categoriemanager.getCategorie(idcategorie);
   }
           
           
           
 public String add(){
       categoriemanager.addCat(categorie);  
    return "CategorieList";
    }
        

    /**
     * Creates a new instance of CategorieADDBean
     */
    public CategorieADDBean() {
    }
    
}
