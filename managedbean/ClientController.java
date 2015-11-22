/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Client;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import session.ClientManager;

/**
 *
 * @author ely
 */
@ManagedBean
@SessionScoped
public class ClientController {

    /**
     * Creates a new instance of ClientController
     */
    @EJB
private ClientManager clientManager;

    
  private  String login;
private String email;
private Client customer = new Client();


    public ClientController() {
    }
 //  public String doSignIn() {
//customer = clientManager.authenticate(login, email);
//
//return "customer.signed.in";
//}
//   
//public String doCreateCustomer() {
//customer = clientManager.createCustomer(customer);
//return "customer.created";
//}
//public String doUpdateAccount() {
//customer = customerBean.updateCustomer(customer);
//return "account.updated";
//}
//
// public String doSignOff() {
//FacesContext fc = FacesContext.getCurrentInstance();
//HttpSession session = (HttpSession)
//fc.getExternalContext().getSession(false);
//session.invalidate();
//return "main";
//}
//   
    
}
