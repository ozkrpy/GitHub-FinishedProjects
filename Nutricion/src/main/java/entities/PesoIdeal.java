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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "peso_ideal")
@NamedQueries({
    @NamedQuery(name = "PesoIdeal.findAll", query = "SELECT p FROM PesoIdeal p"),
    @NamedQuery(name = "PesoIdeal.findByTallaCm", query = "SELECT p FROM PesoIdeal p WHERE p.pesoIdealPK.tallaCm = :tallaCm"),
    @NamedQuery(name = "PesoIdeal.findByTallaInicial", query = "SELECT p.edad1719 FROM PesoIdeal p WHERE p.pesoIdealPK.tallaCm = :tallaCm AND p.pesoIdealPK.sexo = :sexo"),
    @NamedQuery(name = "PesoIdeal.findByTalla24", query = "SELECT p.edad2024 FROM PesoIdeal p WHERE p.pesoIdealPK.tallaCm = :tallaCm AND p.pesoIdealPK.sexo = :sexo"),
    @NamedQuery(name = "PesoIdeal.findByTallaPequena", query = "SELECT (p.contexturaPequenaIni+p.contexturaPequenaFin)/2 FROM PesoIdeal p WHERE p.pesoIdealPK.tallaCm = :tallaCm AND p.pesoIdealPK.sexo = :sexo"),
    @NamedQuery(name = "PesoIdeal.findByTallaMediana", query = "SELECT (p.contexturaMedianaIni+p.contexturaMedianaFin)/2 FROM PesoIdeal p WHERE p.pesoIdealPK.tallaCm = :tallaCm AND p.pesoIdealPK.sexo = :sexo"),
    @NamedQuery(name = "PesoIdeal.findByTallaGrande", query = "SELECT (p.contexturaGrandeIni+p.contexturaGrandeFin)/2 FROM PesoIdeal p WHERE p.pesoIdealPK.tallaCm = :tallaCm AND p.pesoIdealPK.sexo = :sexo"),
    @NamedQuery(name = "PesoIdeal.findByEdad1516", query = "SELECT p FROM PesoIdeal p WHERE p.edad1516 = :edad1516"),
    @NamedQuery(name = "PesoIdeal.findByEdad1719", query = "SELECT p FROM PesoIdeal p WHERE p.edad1719 = :edad1719"),
    @NamedQuery(name = "PesoIdeal.findByEdad2024", query = "SELECT p FROM PesoIdeal p WHERE p.edad2024 = :edad2024"),
    @NamedQuery(name = "PesoIdeal.findByEdad2529", query = "SELECT p FROM PesoIdeal p WHERE p.edad2529 = :edad2529"),
    @NamedQuery(name = "PesoIdeal.findByEdad3039", query = "SELECT p FROM PesoIdeal p WHERE p.edad3039 = :edad3039"),
    @NamedQuery(name = "PesoIdeal.findByEdad4049", query = "SELECT p FROM PesoIdeal p WHERE p.edad4049 = :edad4049"),
    @NamedQuery(name = "PesoIdeal.findByEdad5059", query = "SELECT p FROM PesoIdeal p WHERE p.edad5059 = :edad5059"),
    @NamedQuery(name = "PesoIdeal.findByEdad6069", query = "SELECT p FROM PesoIdeal p WHERE p.edad6069 = :edad6069"),
    @NamedQuery(name = "PesoIdeal.findByContexturaPequenaIni", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaPequenaIni = :contexturaPequenaIni"),
    @NamedQuery(name = "PesoIdeal.findByContexturaPequenaFin", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaPequenaFin = :contexturaPequenaFin"),
    @NamedQuery(name = "PesoIdeal.findByContexturaMedianaIni", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaMedianaIni = :contexturaMedianaIni"),
    @NamedQuery(name = "PesoIdeal.findByContexturaMedianaFin", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaMedianaFin = :contexturaMedianaFin"),
    @NamedQuery(name = "PesoIdeal.findByContexturaGrandeIni", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaGrandeIni = :contexturaGrandeIni"),
    @NamedQuery(name = "PesoIdeal.findByContexturaGrandeFin", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaGrandeFin = :contexturaGrandeFin"),
    @NamedQuery(name = "PesoIdeal.findBySexo", query = "SELECT p FROM PesoIdeal p WHERE p.pesoIdealPK.sexo = :sexo")})
public class PesoIdeal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PesoIdealPK pesoIdealPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad15_16")
    private double edad1516;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad17_19")
    private double edad1719;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad20_24")
    private double edad2024;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad25_29")
    private double edad2529;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad30_39")
    private double edad3039;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad40_49")
    private double edad4049;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad50_59")
    private double edad5059;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad60_69")
    private double edad6069;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_pequena_ini")
    private double contexturaPequenaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_pequena_fin")
    private double contexturaPequenaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_mediana_ini")
    private double contexturaMedianaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_mediana_fin")
    private double contexturaMedianaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_grande_ini")
    private double contexturaGrandeIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_grande_fin")
    private double contexturaGrandeFin;

    public PesoIdeal() {
    }

    public PesoIdeal(PesoIdealPK pesoIdealPK) {
        this.pesoIdealPK = pesoIdealPK;
    }

    public PesoIdeal(PesoIdealPK pesoIdealPK, double edad1516, double edad1719, double edad2024, double edad2529, double edad3039, double edad4049, double edad5059, double edad6069, double contexturaPequenaIni, double contexturaPequenaFin, double contexturaMedianaIni, double contexturaMedianaFin, double contexturaGrandeIni, double contexturaGrandeFin) {
        this.pesoIdealPK = pesoIdealPK;
        this.edad1516 = edad1516;
        this.edad1719 = edad1719;
        this.edad2024 = edad2024;
        this.edad2529 = edad2529;
        this.edad3039 = edad3039;
        this.edad4049 = edad4049;
        this.edad5059 = edad5059;
        this.edad6069 = edad6069;
        this.contexturaPequenaIni = contexturaPequenaIni;
        this.contexturaPequenaFin = contexturaPequenaFin;
        this.contexturaMedianaIni = contexturaMedianaIni;
        this.contexturaMedianaFin = contexturaMedianaFin;
        this.contexturaGrandeIni = contexturaGrandeIni;
        this.contexturaGrandeFin = contexturaGrandeFin;
    }

    public PesoIdeal(int tallaCm, String sexo) {
        this.pesoIdealPK = new PesoIdealPK(tallaCm, sexo);
    }

    public PesoIdealPK getPesoIdealPK() {
        return pesoIdealPK;
    }

    public void setPesoIdealPK(PesoIdealPK pesoIdealPK) {
        this.pesoIdealPK = pesoIdealPK;
    }

    public double getEdad1516() {
        return edad1516;
    }

    public void setEdad1516(double edad1516) {
        this.edad1516 = edad1516;
    }

    public double getEdad1719() {
        return edad1719;
    }

    public void setEdad1719(double edad1719) {
        this.edad1719 = edad1719;
    }

    public double getEdad2024() {
        return edad2024;
    }

    public void setEdad2024(double edad2024) {
        this.edad2024 = edad2024;
    }

    public double getEdad2529() {
        return edad2529;
    }

    public void setEdad2529(double edad2529) {
        this.edad2529 = edad2529;
    }

    public double getEdad3039() {
        return edad3039;
    }

    public void setEdad3039(double edad3039) {
        this.edad3039 = edad3039;
    }

    public double getEdad4049() {
        return edad4049;
    }

    public void setEdad4049(double edad4049) {
        this.edad4049 = edad4049;
    }

    public double getEdad5059() {
        return edad5059;
    }

    public void setEdad5059(double edad5059) {
        this.edad5059 = edad5059;
    }

    public double getEdad6069() {
        return edad6069;
    }

    public void setEdad6069(double edad6069) {
        this.edad6069 = edad6069;
    }

    public double getContexturaPequenaIni() {
        return contexturaPequenaIni;
    }

    public void setContexturaPequenaIni(double contexturaPequenaIni) {
        this.contexturaPequenaIni = contexturaPequenaIni;
    }

    public double getContexturaPequenaFin() {
        return contexturaPequenaFin;
    }

    public void setContexturaPequenaFin(double contexturaPequenaFin) {
        this.contexturaPequenaFin = contexturaPequenaFin;
    }

    public double getContexturaMedianaIni() {
        return contexturaMedianaIni;
    }

    public void setContexturaMedianaIni(double contexturaMedianaIni) {
        this.contexturaMedianaIni = contexturaMedianaIni;
    }

    public double getContexturaMedianaFin() {
        return contexturaMedianaFin;
    }

    public void setContexturaMedianaFin(double contexturaMedianaFin) {
        this.contexturaMedianaFin = contexturaMedianaFin;
    }

    public double getContexturaGrandeIni() {
        return contexturaGrandeIni;
    }

    public void setContexturaGrandeIni(double contexturaGrandeIni) {
        this.contexturaGrandeIni = contexturaGrandeIni;
    }

    public double getContexturaGrandeFin() {
        return contexturaGrandeFin;
    }

    public void setContexturaGrandeFin(double contexturaGrandeFin) {
        this.contexturaGrandeFin = contexturaGrandeFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesoIdealPK != null ? pesoIdealPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PesoIdeal)) {
            return false;
        }
        PesoIdeal other = (PesoIdeal) object;
        if ((this.pesoIdealPK == null && other.pesoIdealPK != null) || (this.pesoIdealPK != null && !this.pesoIdealPK.equals(other.pesoIdealPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PesoIdeal[ pesoIdealPK=" + pesoIdealPK + " ]";
    }
    
}
