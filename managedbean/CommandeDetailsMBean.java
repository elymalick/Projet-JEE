/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Client;
import entities.Commande;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import session.CommandeManagerbb;
import session.CustomerManagerbb;

/**
 *
 * @author ely
 */


@ManagedBean
@ViewScoped 
public class CommandeDetailsMBean {

       @EJB  
  private CustomerManagerbb customerManager;
       private int commandeid,clienid;  
  private Commande commande = new Commande();  
  private Client client=new Client();
  
  @EJB  
  private CommandeManagerbb commandeManager; 
  

  
   
  
    public int getIdCommande() {  
    return commandeid;  
  }  

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
     
    
  
  public void setIdCommande(int commandeid) {  
    this.commandeid = commandeid;  
  }  
  
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property) 
   */

    /**
     * Renvoie les détails du client courant (celui dans l'attribut customer de 
 cette classe), qu'on appelle une propriété (property)
     * @return
     */
    public Commande getDetails() {  
    
    return commande;  
  }  

    public int getClienid() {
        return clienid;
    }

    public void setClienid(int clienid) {
        this.clienid = clienid;
    }
  
  
    public String update(int idCommande,String stat) {  
    System.out.println("###UPDATE###");
     
   commande= commandeManager.updateCommande(idCommande,stat);  
    return "CommandeList";  
  }  
  
       public String remove() {  
    System.out.println("###UPDATE###");  
     commandeManager.removeCommande(commande);  
    return "CommandeList";  
  }  
       
              public String add() {  
    System.out.println("###UPDATE###");  
     commandeManager.addCommande(commande);  
    return "CommandeList";  
  }  
  
    /**
     * Creates a new instance of CommandeDetailsMBean
     */
  
    public String list() {  
    System.out.println("###LIST###");  
    return "CommandeList";  
  }  
  
   public void loadCommande() {  
    this.commande = commandeManager.getCommande(commandeid);  this.client=customerManager.getCustomer(clienid);
  
  }  
    public CommandeDetailsMBean(){
    }
    
}
