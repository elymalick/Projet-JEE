package managedbean;

import entities.Client;
import entities.Produit;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import session.CustomerManager;

/**
 *
 * @author ely
 */
@ManagedBean
@ViewScoped 
public class CustomerDetailsMBean {

   private int produitid;  
  private Produit produit=new Produit();  
  
  @EJB  
  private CustomerManager customerManager;  
  
  public int getIdCustomer() {  
    return produitid;  
  }  
  
  public void setIdCustomer(int idCustomer) {  
    this.produitid = idCustomer;  
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
  public String update() {  
    System.out.println("###UPDATE###");  
    produit = customerManager.update(produit);  
    return "CustomerList";  
  }  
    
  
    
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
     * @return 
   */  
  public String list() {  
    System.out.println("###LIST###");  
    return "CustomerList";  
  }  
  
  public void loadCustomer() {  
    this.produit = customerManager.getCustomer(produitid);  
  }  
    
    
    
    public CustomerDetailsMBean() {
    }
  }  
  

