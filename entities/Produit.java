/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ely
 */
@Entity
@Table(name = "PRODUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByProduitid", query = "SELECT p FROM Produit p WHERE p.produitid = :produitid"),
    @NamedQuery(name = "Produit.findByNomproduit", query = "SELECT p FROM Produit p WHERE p.nomproduit = :nomproduit"),
    @NamedQuery(name = "Produit.findByPrixunitaire", query = "SELECT p FROM Produit p WHERE p.prixunitaire = :prixunitaire"),
    @NamedQuery(name = "Produit.findByQuantiteenstock", query = "SELECT p FROM Produit p WHERE p.quantiteenstock = :quantiteenstock"),
    @NamedQuery(name = "Produit.findByPhoto", query = "SELECT p FROM Produit p WHERE p.photo = :photo")})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUITID")
    private Integer produitid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMPRODUIT")
    private String nomproduit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXUNITAIRE")
    private BigDecimal prixunitaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITEENSTOCK")
    private int quantiteenstock;
    @Size(max = 255)
    @Column(name = "PHOTO")
    private String photo;
    @JoinColumn(name = "CATEGORIEID", referencedColumnName = "CATEGORIEID")
    @ManyToOne(optional = false)
    private Categorie categorieid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Lignecommandes> lignecommandesCollection;

    public Produit() {
    }

    public Produit(Integer produitid) {
        this.produitid = produitid;
    }

    public Produit(Integer produitid, String nomproduit, BigDecimal prixunitaire, int quantiteenstock) {
        this.produitid = produitid;
        this.nomproduit = nomproduit;
        this.prixunitaire = prixunitaire;
        this.quantiteenstock = quantiteenstock;
    }

    public Integer getProduitid() {
        return produitid;
    }

    public void setProduitid(Integer produitid) {
        this.produitid = produitid;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public BigDecimal getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(BigDecimal prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public int getQuantiteenstock() {
        return quantiteenstock;
    }

    public void setQuantiteenstock(int quantiteenstock) {
        this.quantiteenstock = quantiteenstock;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Categorie getCategorieid() {
        return categorieid;
    }

    public void setCategorieid(Categorie categorieid) {
        this.categorieid = categorieid;
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
        hash += (produitid != null ? produitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.produitid == null && other.produitid != null) || (this.produitid != null && !this.produitid.equals(other.produitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produit[ produitid=" + produitid + " ]";
    }
    
}
