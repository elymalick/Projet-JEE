/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Categorie;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import session.CategoryManager;

/**
 *
 * @author ely
 */

@Named(value = "categorieMBean") 
@SessionScoped
public class CategorieMBean implements Serializable{
    @EJB
    private CategoryManager categoryManager;

    /**
     * Creates a new instance of CategorieMBean
     */
    public CategorieMBean() {
    }
    public List<Categorie>getCategories() {  
//        List<Categorie> t=new ArrayList<Categorie>();
//        t=categoryManager.getAllCategoy();
//        if(t.size()==0)
//        {
//            
//        }
        
       return categoryManager.getAllCategoy();  
    } 
}
