/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ely
 */
@Entity
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByCommandeid", query = "SELECT c FROM Commande c WHERE c.commandeid = :commandeid"),
    @NamedQuery(name = "Commande.findByStatut", query = "SELECT c FROM Commande c WHERE c.statut = :statut"),
    @NamedQuery(name = "Commande.findByDatecommande", query = "SELECT c FROM Commande c WHERE c.datecommande = :datecommande")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMMANDEID")
    private Integer commandeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATUT")
    private String statut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECOMMANDE")
    @Temporal(TemporalType.DATE)
    private Date datecommande;
    @JoinColumn(name = "CLIENTID", referencedColumnName = "CLIENTID")
    @ManyToOne(optional = false)
    private Client clientid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<Lignecommandes> lignecommandesCollection;

    public Commande() {
    }

    public Commande(Integer commandeid) {
        this.commandeid = commandeid;
    }

    public Commande(Integer commandeid, String statut, Date datecommande) {
        this.commandeid = commandeid;
        this.statut = statut;
        this.datecommande = datecommande;
    }

    public Integer getCommandeid() {
        return commandeid;
    }

    public void setCommandeid(Integer commandeid) {
        this.commandeid = commandeid;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Client getClientid() {
        return clientid;
    }

    public void setClientid(Client clientid) {
        this.clientid = clientid;
    }

    @XmlTransient
    public Collection<Lignecommandes> getLignecommandesCollection() {
        return lignecommandesCollection;
    }

    public void setLignecommandesCollection(Collection<Lignecommandes> lignecommandesCollection) {
        this.lignecommandesCollection = lignecommandesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandeid != null ? commandeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.commandeid == null && other.commandeid != null) || (this.commandeid != null && !this.commandeid.equals(other.commandeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ commandeid=" + commandeid + " ]";
    }
    
}
