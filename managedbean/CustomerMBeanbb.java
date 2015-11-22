/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Client;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import session.CustomerManagerbb;

/**
 *
 * @author ely
 */
@ManagedBean
@ViewScoped 
public class CustomerMBeanbb {
    @EJB
    private CustomerManagerbb customerManager;
    
     private Client client= new Client();  

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBeanbb() {
    }

    
     /** 
     * Renvoie la liste des clients pour affichage dans une DataTable 
     * @return 
     */   
    public List<Client>getCustomers() {  
        return customerManager.getAllCustomers();  
    }  
    

  
    /** 
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans 
     * la DataTable pour voir les détails 
      */ 
    public String showDetails(int customerId) {  
        return "CustomerDetailsbb?idCustomer=" + customerId;    }  
    
    
}  
