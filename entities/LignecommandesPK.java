/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ely
 */
@Embeddable
public class LignecommandesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMANDEID")
    private int commandeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUITID")
    private int produitid;

    public LignecommandesPK() {
    }

    public LignecommandesPK(int commandeid, int produitid) {
        this.commandeid = commandeid;
        this.produitid = produitid;
    }

    public int getCommandeid() {
        return commandeid;
    }

    public void setCommandeid(int commandeid) {
        this.commandeid = commandeid;
    }

    public int getProduitid() {
        return produitid;
    }

    public void setProduitid(int produitid) {
        this.produitid = produitid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) commandeid;
        hash += (int) produitid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LignecommandesPK)) {
            return false;
        }
        LignecommandesPK other = (LignecommandesPK) object;
        if (this.commandeid != other.commandeid) {
            return false;
        }
        if (this.produitid != other.produitid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LignecommandesPK[ commandeid=" + commandeid + ", produitid=" + produitid + " ]";
    }
    
}
