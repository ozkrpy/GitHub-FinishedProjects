/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "tipo_alimento")
@NamedQueries({
    @NamedQuery(name = "TipoAlimento.findAll", query = "SELECT t FROM TipoAlimento t"),
    @NamedQuery(name = "TipoAlimento.findByCodigoTipoAlimento", query = "SELECT t FROM TipoAlimento t WHERE t.codigoTipoAlimento = :codigoTipoAlimento"),
    @NamedQuery(name = "TipoAlimento.findByDescripcionTipoAlimento", query = "SELECT t FROM TipoAlimento t WHERE t.descripcionTipoAlimento = :descripcionTipoAlimento")})
public class TipoAlimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tipo_alimento")
    private Integer codigoTipoAlimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_tipo_alimento")
    private String descripcionTipoAlimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAlimento")
    private List<Alimentos> alimentosList;

    public TipoAlimento() {
    }

    public TipoAlimento(Integer codigoTipoAlimento) {
        this.codigoTipoAlimento = codigoTipoAlimento;
    }

    public TipoAlimento(Integer codigoTipoAlimento, String descripcionTipoAlimento) {
        this.codigoTipoAlimento = codigoTipoAlimento;
        this.descripcionTipoAlimento = descripcionTipoAlimento;
    }

    public Integer getCodigoTipoAlimento() {
        return codigoTipoAlimento;
    }

    public void setCodigoTipoAlimento(Integer codigoTipoAlimento) {
        this.codigoTipoAlimento = codigoTipoAlimento;
    }

    public String getDescripcionTipoAlimento() {
        return descripcionTipoAlimento;
    }

    public void setDescripcionTipoAlimento(String descripcionTipoAlimento) {
        this.descripcionTipoAlimento = descripcionTipoAlimento;
    }

    public List<Alimentos> getAlimentosList() {
        return alimentosList;
    }

    public void setAlimentosList(List<Alimentos> alimentosList) {
        this.alimentosList = alimentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoAlimento != null ? codigoTipoAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlimento)) {
            return false;
        }
        TipoAlimento other = (TipoAlimento) object;
        if ((this.codigoTipoAlimento == null && other.codigoTipoAlimento != null) || (this.codigoTipoAlimento != null && !this.codigoTipoAlimento.equals(other.codigoTipoAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoAlimento[ codigoTipoAlimento=" + codigoTipoAlimento + " ]";
    }
    
}
