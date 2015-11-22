/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entities.Client;
import entities.Produit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.omg.CORBA.UserException;
import session.PanierService;
//import session.PanierServiceLocal;
import session.UserServiceManager;

/**
 *
 * @author ely
 */

@SessionScoped
@Named(value = "currentUserMBean") 
public class CurrentUserMBean implements Serializable{
    @EJB
    private UserServiceManager userServiceManager;
    @EJB
    private PanierService panierService;
    private boolean logged=false;
    
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
    private Client clientlogged;
    /**
     * Creates a new instance of CurrentUserMBean
     * @return 
     */
    public Client getClient()
    {
    return this.clientlogged;
    }
    
    public CurrentUserMBean() {
        setUserLogged(new  Client());
    }
    public void setUserLogged(Client userLogged)
    {
    this.clientlogged=userLogged;
    }  
    
    public Client getUserLogged()
    {
    return this.clientlogged;
     }
    public boolean isLogged()
    {
    return logged;
    }
//    public Collection getListPanier()
//    {
//    return panierService.
//    }
    
    public  String login()
    {
        if(clientlogged.getNom().equals("admin")&&clientlogged.getEmail().equals("admin@admin"))
        {
        return "admin";
        }
        else
        {
       
        
        clientlogged=userServiceManager.login(clientlogged.getNom() , clientlogged.getEmail());
       // System.out.println("elyyyy"+clientlogged.getClientid());
        logged=true;
        
       return "";
     }
//     catch(Exception e)
//    {
//        String msg="Impossible de vous connecter ." +"veuillez verifier vos identifiants .";
//        FacesMessage facesMsg=new FacesMessage(msg);
//        FacesContext fc= FacesContext.getCurrentInstance();
//        fc.addMessage("loginForm", facesMsg);
//    }
//    return "";
    }
    
    public String deconnection()
    {
        setUserLogged(new Client());
        logged=false;
        return "page_produit";
    }
    
    public int getRequestId()
    {
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request=(HttpServletRequest)ec.getRequest();
        String param=request.getParameter("id");
       return Integer.parseInt(param);
    
    }
    
    public String panierview()
    {
    return "mon_panier";
    }
    
    public String add()
    {
    panierService.add(getRequestId());
        System.out.println("testt id :"+getRequestId());
    return "page_produit";
    }
    public String removeFromPanier()
    {
    panierService.remove(getRequestId());
   return "";
    }
    
    public String validPanier()
            
    {
    try
    {
        panierService.validatePanier(clientlogged.getClientid());
    }
    catch(UserException e)
    {
        String msg="vous de devez vous connectez pour valider votre panier "; 
         FacesMessage facesMsg=new FacesMessage(msg);
        FacesContext fc= FacesContext.getCurrentInstance();
        fc.addMessage("validCartError", facesMsg);
        return "public_cart";
    }
//    catch(Exception e)
//    {
//         String msg="une erreur est survenue lors de la validation de votre commande"; 
//          FacesMessage facesMsg=new FacesMessage(msg);
//        FacesContext fc= FacesContext.getCurrentInstance();
//        fc.addMessage("validCartError", facesMsg);
//         return "public_cart";
//    }
    return "public_cart_validated";
    }
    public String getListCart()
    {
        this.produit =panierService.getListProd();
        for (Produit p : panierService.getListProd()) {
            System.out.println("list :"+p.getNomproduit());
        }
//        
//        if(panierService.getListProd().isEmpty())
//        {
//        return "inscription_succes";
//        }
   
    
    return "public_cart";
        
//  return panierService.getListProd();
    }
    
    public Collection<Produit>getAllPanier()
    {
    return this.produit;
    }
}
