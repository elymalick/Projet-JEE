/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ely
 */
@Entity
@Table(name = "LIGNECOMMANDES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignecommandes.findAll", query = "SELECT l FROM Lignecommandes l"),
    @NamedQuery(name = "Lignecommandes.findByCommandeid", query = "SELECT l FROM Lignecommandes l WHERE l.lignecommandesPK.commandeid = :commandeid"),
    @NamedQuery(name = "Lignecommandes.findByProduitid", query = "SELECT l FROM Lignecommandes l WHERE l.lignecommandesPK.produitid = :produitid"),
    @NamedQuery(name = "Lignecommandes.findByQuantite", query = "SELECT l FROM Lignecommandes l WHERE l.quantite = :quantite")})
public class Lignecommandes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LignecommandesPK lignecommandesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITE")
    private int quantite;
    @JoinColumn(name = "PRODUITID", referencedColumnName = "PRODUITID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "COMMANDEID", referencedColumnName = "COMMANDEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public Lignecommandes() {
    }

    public Lignecommandes(LignecommandesPK lignecommandesPK) {
        this.lignecommandesPK = lignecommandesPK;
    }

    public Lignecommandes(LignecommandesPK lignecommandesPK, int quantite) {
        this.lignecommandesPK = lignecommandesPK;
        this.quantite = quantite;
    }

    public Lignecommandes(int commandeid, int produitid) {
        this.lignecommandesPK = new LignecommandesPK(commandeid, produitid);
    }

    public LignecommandesPK getLignecommandesPK() {
        return lignecommandesPK;
    }

    public void setLignecommandesPK(LignecommandesPK lignecommandesPK) {
        this.lignecommandesPK = lignecommandesPK;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lignecommandesPK != null ? lignecommandesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecommandes)) {
            return false;
        }
        Lignecommandes other = (Lignecommandes) object;
        if ((this.lignecommandesPK == null && other.lignecommandesPK != null) || (this.lignecommandesPK != null && !this.lignecommandesPK.equals(other.lignecommandesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lignecommandes[ lignecommandesPK=" + lignecommandesPK + " ]";
    }
    
}
