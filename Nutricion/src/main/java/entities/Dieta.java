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

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "dieta")
@NamedQueries({
    @NamedQuery(name = "Dieta.findAll", query = "SELECT d FROM Dieta d"),
    @NamedQuery(name = "Dieta.findAllCodigoDieta", query = "SELECT DISTINCT(d.dietaPK.codigoDieta) FROM Dieta d ORDER BY d.dietaPK.codigoDieta"),
    @NamedQuery(name = "Dieta.findAllByCodigoPaciente", query = "SELECT DISTINCT(d.dietaPK.codigoDieta) FROM Dieta d WHERE d.codigoPaciente.codigoPaciente = :codigoPaciente ORDER BY d.dietaPK.codigoDieta"),
    @NamedQuery(name = "Dieta.maxCodigoDieta", query = "SELECT MAX(d.dietaPK.codigoDieta) FROM Dieta d"),
    @NamedQuery(name = "Dieta.findByCodigoDieta", query = "SELECT d FROM Dieta d WHERE d.dietaPK.codigoDieta = :codigoDieta"),
    @NamedQuery(name = "Dieta.findByCodigoDietaMaxItem", query = "SELECT MAX(d.dietaPK.numeroItem) FROM Dieta d WHERE d.dietaPK.codigoDieta = :codigoDieta"),
    @NamedQuery(name = "Dieta.findByCantidadAlimento", query = "SELECT d FROM Dieta d WHERE d.cantidadAlimento = :cantidadAlimento"),
    @NamedQuery(name = "Dieta.findByNumeroItem", query = "SELECT d FROM Dieta d WHERE d.dietaPK.numeroItem = :numeroItem")})
public class Dieta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DietaPK dietaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_alimento")
    private double cantidadAlimento;
    @JoinColumn(name = "codigo_alimento", referencedColumnName = "codigo_alimento")
    @ManyToOne(optional = false)
    private Alimentos codigoAlimento;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente")
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;

    public Dieta() {
    }

    public Dieta(DietaPK dietaPK) {
        this.dietaPK = dietaPK;
    }

    public Dieta(DietaPK dietaPK, double cantidadAlimento) {
        this.dietaPK = dietaPK;
        this.cantidadAlimento = cantidadAlimento;
    }

    public Dieta(int codigoDieta, int numeroItem) {
        this.dietaPK = new DietaPK(codigoDieta, numeroItem);
    }

    public DietaPK getDietaPK() {
        return dietaPK;
    }

    public void setDietaPK(DietaPK dietaPK) {
        this.dietaPK = dietaPK;
    }

    public double getCantidadAlimento() {
        return cantidadAlimento;
    }

    public void setCantidadAlimento(double cantidadAlimento) {
        this.cantidadAlimento = cantidadAlimento;
    }

    public Alimentos getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(Alimentos codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dietaPK != null ? dietaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dieta)) {
            return false;
        }
        Dieta other = (Dieta) object;
        if ((this.dietaPK == null && other.dietaPK != null) || (this.dietaPK != null && !this.dietaPK.equals(other.dietaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dieta[ dietaPK=" + dietaPK + " ]";
    }
    
}
