/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Produit;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import session.CustomerManager;

/**
 *
 * @author ely
 */
@Named(value = "customerMBean") 
@ViewScoped


public class CustomerMBean implements Serializable{
    @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
    
     public List<Produit>getCustomers() {  
        return customerManager.getAllCustomer();  
    }  
     
     
 public String showDetails(int produitId) {  
        return "CustomerDetails?idCustomer=" + produitId;  
    }   
 
//   public String showDetails(int customerId) {  
//        return "CustomerDetails?idCustomer=" + customerId;    } 
 
 public String log()
 {
     return "compte";
 }
 
 public String logsucces()
 {
  return "se_login";
 }
 
 public String retour()
 {
     return "page_produit";
 }
 
 
}
