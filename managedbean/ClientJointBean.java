/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Client;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omg.CORBA.UserException;
import session.UserServiceManager;

/**
 *
 * @author ely
 */
@Named(value = "clientJointBean")
@RequestScoped
public class ClientJointBean implements Serializable{
    @EJB
    private UserServiceManager userServiceManager;
private Client client;

    /**
     * Creates a new instance of ClientJointBean
     */
    public ClientJointBean() {
        setClient(new Client());
    }
    public String join()
    {
        try{
  Client cl=  userServiceManager.inscription(getClient());
        }
        catch(UserException e){
        String msg="L'utilisateur existe deja" +e;
            FacesMessage facesMsg= new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("addError", facesMsg);
            return "bienvenue";
        }
    return "inscription_succes";
    }
    
   public Client getClient()
   {
       return this.client;
   }
   public void setClient(Client client){
           this.client=client;
                   }
}
