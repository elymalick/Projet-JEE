/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Client;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import session.CustomerManagerbb;

/**
 *
 * @author ely
 */
@ManagedBean
@ViewScoped 
public class CustomerDetailsMBeanbb {

   private int clientid;  
  private Client client= new Client();  
  
  @EJB  
  private CustomerManagerbb customerManager;  
  
  public int getIdCustomer() {  
    return clientid;  
  }  
  
  public void setIdCustomer(int idCustomer) {  
    this.clientid = idCustomer;  
  }  
  
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property) 
   */  
  public Client getDetails() {  
    return client;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
     * @return 
   */  
  public String update() {  
    System.out.println("###UPDATE###");  
    client = customerManager.update(client);  
    return "CustomerList";  
  }  
  
    public String remove() {  
    System.out.println("###UPDATE###");  
     customerManager.removeClient(client);  
    return "CustomerList";  
  }  
  
    public String add(){
       customerManager.addClient(client);  
    return "CustomerList";
    }
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {  
    System.out.println("###LIST###");  
    return "CustomerList";  
  }  
  
  public void loadCustomer() {  
    this.client = customerManager.getCustomer(clientid);  
  }  
    
    
    
    public CustomerDetailsMBeanbb() {
    }
    
}
