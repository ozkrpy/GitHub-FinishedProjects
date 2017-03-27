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
import javax.validation.constraints.Size;

/**
 *
 * @author ozkrp
 */
@Embeddable
public class PesoIdealPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "talla_cm")
    private int tallaCm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;

    public PesoIdealPK() {
    }

    public PesoIdealPK(int tallaCm, String sexo) {
        this.tallaCm = tallaCm;
        this.sexo = sexo;
    }

    public int getTallaCm() {
        return tallaCm;
    }

    public void setTallaCm(int tallaCm) {
        this.tallaCm = tallaCm;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tallaCm;
        hash += (sexo != null ? sexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PesoIdealPK)) {
            return false;
        }
        PesoIdealPK other = (PesoIdealPK) object;
        if (this.tallaCm != other.tallaCm) {
            return false;
        }
        if ((this.sexo == null && other.sexo != null) || (this.sexo != null && !this.sexo.equals(other.sexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PesoIdealPK[ tallaCm=" + tallaCm + ", sexo=" + sexo + " ]";
    }
    
}
