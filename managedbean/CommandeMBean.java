/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;


import entities.Client;
import entities.Commande;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import session.CommandeManagerbb;

/**
 *
 * @author ely
 */
@ManagedBean
@ViewScoped 
public class CommandeMBean {

    
      @EJB
    private CommandeManagerbb commandemanager;
    
     private Commande commande= new Commande();  
     
         public List<Commande>getCommandes() {  
        return commandemanager.getAllCommandes();  
    } 
    /**
     * Creates a new instance of CommandeMBean
     */
         
         
           public String showDetails(int commandeid) {  
        return "CommandeDetails?idCommande=" + commandeid;    }
           
            
           public String showDetailsClient(int commandeid) {  
        return "CommandeClient?idCommande=" + commandeid;    }
           
    public CommandeMBean() {
    }
    
}
