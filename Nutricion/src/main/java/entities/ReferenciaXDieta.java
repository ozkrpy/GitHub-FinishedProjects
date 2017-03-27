/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "referencia_x_dieta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenciaXDieta.findAll", query = "SELECT r FROM ReferenciaXDieta r"),
    @NamedQuery(name = "ReferenciaXDieta.findByCodigoReferenciaXDieta", query = "SELECT r FROM ReferenciaXDieta r WHERE r.codigoReferenciaXDieta = :codigoReferenciaXDieta"),
    @NamedQuery(name = "ReferenciaXDieta.findByCodigoDieta", query = "SELECT r FROM ReferenciaXDieta r WHERE r.codigoDieta = :codigoDieta"),
    @NamedQuery(name = "ReferenciaXDieta.findByHidratosCarbono", query = "SELECT r FROM ReferenciaXDieta r WHERE r.hidratosCarbono = :hidratosCarbono"),
    @NamedQuery(name = "ReferenciaXDieta.findByProteinas", query = "SELECT r FROM ReferenciaXDieta r WHERE r.proteinas = :proteinas"),
    @NamedQuery(name = "ReferenciaXDieta.findByGrasas", query = "SELECT r FROM ReferenciaXDieta r WHERE r.grasas = :grasas"),
    @NamedQuery(name = "ReferenciaXDieta.findByFibras", query = "SELECT r FROM ReferenciaXDieta r WHERE r.fibras = :fibras")})
public class ReferenciaXDieta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_referencia_x_dieta")
    private Integer codigoReferenciaXDieta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_dieta")
    private int codigoDieta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hidratos_carbono")
    private double hidratosCarbono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proteinas")
    private double proteinas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grasas")
    private double grasas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fibras")
    private double fibras;

    public ReferenciaXDieta() {
    }

    public ReferenciaXDieta(Integer codigoReferenciaXDieta) {
        this.codigoReferenciaXDieta = codigoReferenciaXDieta;
    }

    public ReferenciaXDieta(Integer codigoReferenciaXDieta, int codigoDieta, double hidratosCarbono, double proteinas, double grasas, double fibras) {
        this.codigoReferenciaXDieta = codigoReferenciaXDieta;
        this.codigoDieta = codigoDieta;
        this.hidratosCarbono = hidratosCarbono;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.fibras = fibras;
    }

    public Integer getCodigoReferenciaXDieta() {
        return codigoReferenciaXDieta;
    }

    public void setCodigoReferenciaXDieta(Integer codigoReferenciaXDieta) {
        this.codigoReferenciaXDieta = codigoReferenciaXDieta;
    }

    public int getCodigoDieta() {
        return codigoDieta;
    }

    public void setCodigoDieta(int codigoDieta) {
        this.codigoDieta = codigoDieta;
    }

    public double getHidratosCarbono() {
        return hidratosCarbono;
    }

    public void setHidratosCarbono(double hidratosCarbono) {
        this.hidratosCarbono = hidratosCarbono;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public double getFibras() {
        return fibras;
    }

    public void setFibras(double fibras) {
        this.fibras = fibras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoReferenciaXDieta != null ? codigoReferenciaXDieta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferenciaXDieta)) {
            return false;
        }
        ReferenciaXDieta other = (ReferenciaXDieta) object;
        if ((this.codigoReferenciaXDieta == null && other.codigoReferenciaXDieta != null) || (this.codigoReferenciaXDieta != null && !this.codigoReferenciaXDieta.equals(other.codigoReferenciaXDieta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReferenciaXDieta[ codigoReferenciaXDieta=" + codigoReferenciaXDieta + " ]";
    }
    
}
