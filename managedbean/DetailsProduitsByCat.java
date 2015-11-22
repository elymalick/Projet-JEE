/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Produit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import session.CategoryManager;
import session.CustomerManager;

/**
 *
 * @author ely
 */
@Named(value = "detailsProduitsByCat") 
@ViewScoped
public class DetailsProduitsByCat implements Serializable{

    private int categorieid;  
  private Collection<Produit> produit =new Collection<Produit>() {

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
        public <T> T[] toArray(T[] a) {
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
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean addAll(Collection<? extends Produit> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };  
  
  @EJB  
  private CategoryManager categoryManager;  
  
  public int getIdCustomer() {  
    return categorieid;  
  }  
  
  public void setIdCustomer(int idCustomer) {  
    this.categorieid = idCustomer;  
  }  
  
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property)
     * @return 
   */  
  public Collection<Produit> getDetails() {  
    return produit;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
   */  
//  public String update() {  
//    System.out.println("###UPDATE###");  
//    produit = customerManager.update(produit);  
//    return "CustomerList";  
//  }  
//    
  
    
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
     * @return 
   */  
  public String list() {  
    System.out.println("###LIST###");  
    return "CustomerList";  
  }  
  
  public void loadCustomer() {  
    this.produit = categoryManager.getProductListByCategoryId(categorieid);
  }  
    
    
    
    public DetailsProduitsByCat() {
    }
}
