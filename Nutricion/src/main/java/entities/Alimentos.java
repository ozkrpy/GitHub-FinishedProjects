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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "alimentos")
@NamedQueries({
    @NamedQuery(name = "Alimentos.findAll", query = "SELECT a FROM Alimentos a"),
    @NamedQuery(name = "Alimentos.findByCodigoAlimento", query = "SELECT a FROM Alimentos a WHERE a.codigoAlimento = :codigoAlimento"),
    @NamedQuery(name = "Alimentos.findByDescripcionAlimento", query = "SELECT a FROM Alimentos a WHERE a.descripcionAlimento = :descripcionAlimento"),
    @NamedQuery(name = "Alimentos.findByMedidaCasera", query = "SELECT a FROM Alimentos a WHERE a.medidaCasera = :medidaCasera"),
    @NamedQuery(name = "Alimentos.findByMedidaCaseraUnidad", query = "SELECT a FROM Alimentos a WHERE a.medidaCaseraUnidad = :medidaCaseraUnidad"),
    @NamedQuery(name = "Alimentos.findByMedidaReal", query = "SELECT a FROM Alimentos a WHERE a.medidaReal = :medidaReal"),
    @NamedQuery(name = "Alimentos.findByMedidaRealUnidad", query = "SELECT a FROM Alimentos a WHERE a.medidaRealUnidad = :medidaRealUnidad"),
    @NamedQuery(name = "Alimentos.findByHidratosCarbono", query = "SELECT a FROM Alimentos a WHERE a.hidratosCarbono = :hidratosCarbono"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaHidratosCarbono", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaHidratosCarbono = :unidadMedidaHidratosCarbono"),
    @NamedQuery(name = "Alimentos.findByProteina", query = "SELECT a FROM Alimentos a WHERE a.proteina = :proteina"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaProteina", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaProteina = :unidadMedidaProteina"),
    @NamedQuery(name = "Alimentos.findByGrasa", query = "SELECT a FROM Alimentos a WHERE a.grasa = :grasa"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaGrasa", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaGrasa = :unidadMedidaGrasa"),
    @NamedQuery(name = "Alimentos.findBySodio", query = "SELECT a FROM Alimentos a WHERE a.sodio = :sodio"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaSodio", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaSodio = :unidadMedidaSodio"),
    @NamedQuery(name = "Alimentos.findByPotasio", query = "SELECT a FROM Alimentos a WHERE a.potasio = :potasio"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaPotasio", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaPotasio = :unidadMedidaPotasio"),
    @NamedQuery(name = "Alimentos.findByFosforo", query = "SELECT a FROM Alimentos a WHERE a.fosforo = :fosforo"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaFosforo", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaFosforo = :unidadMedidaFosforo"),
    @NamedQuery(name = "Alimentos.findByCalcio", query = "SELECT a FROM Alimentos a WHERE a.calcio = :calcio"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaCalcio", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaCalcio = :unidadMedidaCalcio"),
    @NamedQuery(name = "Alimentos.findByHierro", query = "SELECT a FROM Alimentos a WHERE a.hierro = :hierro"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaHierro", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaHierro = :unidadMedidaHierro"),
    @NamedQuery(name = "Alimentos.findByColesterol", query = "SELECT a FROM Alimentos a WHERE a.colesterol = :colesterol"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaColesterol", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaColesterol = :unidadMedidaColesterol"),
    @NamedQuery(name = "Alimentos.findByPurinas", query = "SELECT a FROM Alimentos a WHERE a.purinas = :purinas"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaPurinas", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaPurinas = :unidadMedidaPurinas"),
    @NamedQuery(name = "Alimentos.findByFibra", query = "SELECT a FROM Alimentos a WHERE a.fibra = :fibra"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaFibra", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaFibra = :unidadMedidaFibra"),
    @NamedQuery(name = "Alimentos.findByAgua", query = "SELECT a FROM Alimentos a WHERE a.agua = :agua"),
    @NamedQuery(name = "Alimentos.findByUnidadMedidaAgua", query = "SELECT a FROM Alimentos a WHERE a.unidadMedidaAgua = :unidadMedidaAgua"),
    @NamedQuery(name = "Alimentos.findByCalorias", query = "SELECT a FROM Alimentos a WHERE a.calorias = :calorias")})
public class Alimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_alimento")
    private Integer codigoAlimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_alimento")
    private String descripcionAlimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "medida_casera")
    private String medidaCasera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "medida_casera_unidad")
    private String medidaCaseraUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "medida_real")
    private double medidaReal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "medida_real_unidad")
    private String medidaRealUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hidratos_carbono")
    private double hidratosCarbono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_hidratos_carbono")
    private String unidadMedidaHidratosCarbono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proteina")
    private double proteina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_proteina")
    private String unidadMedidaProteina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grasa")
    private double grasa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_grasa")
    private String unidadMedidaGrasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sodio")
    private double sodio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_sodio")
    private String unidadMedidaSodio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "potasio")
    private double potasio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_potasio")
    private String unidadMedidaPotasio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fosforo")
    private double fosforo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_fosforo")
    private String unidadMedidaFosforo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calcio")
    private double calcio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_calcio")
    private String unidadMedidaCalcio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hierro")
    private double hierro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_hierro")
    private String unidadMedidaHierro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "colesterol")
    private double colesterol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_colesterol")
    private String unidadMedidaColesterol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purinas")
    private double purinas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_purinas")
    private String unidadMedidaPurinas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fibra")
    private double fibra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_fibra")
    private String unidadMedidaFibra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agua")
    private double agua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidad_medida_agua")
    private String unidadMedidaAgua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calorias")
    private double calorias;
    @JoinColumn(name = "tipo_alimento", referencedColumnName = "codigo_tipo_alimento")
    @ManyToOne(optional = false)
    private TipoAlimento tipoAlimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoAlimento")
    private List<Dieta> dietaList;

    public Alimentos() {
    }

    public Alimentos(Integer codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public Alimentos(Integer codigoAlimento, String descripcionAlimento, String medidaCasera, String medidaCaseraUnidad, double medidaReal, String medidaRealUnidad, double hidratosCarbono, String unidadMedidaHidratosCarbono, double proteina, String unidadMedidaProteina, double grasa, String unidadMedidaGrasa, double sodio, String unidadMedidaSodio, double potasio, String unidadMedidaPotasio, double fosforo, String unidadMedidaFosforo, double calcio, String unidadMedidaCalcio, double hierro, String unidadMedidaHierro, double colesterol, String unidadMedidaColesterol, double purinas, String unidadMedidaPurinas, double fibra, String unidadMedidaFibra, double agua, String unidadMedidaAgua, double calorias) {
        this.codigoAlimento = codigoAlimento;
        this.descripcionAlimento = descripcionAlimento;
        this.medidaCasera = medidaCasera;
        this.medidaCaseraUnidad = medidaCaseraUnidad;
        this.medidaReal = medidaReal;
        this.medidaRealUnidad = medidaRealUnidad;
        this.hidratosCarbono = hidratosCarbono;
        this.unidadMedidaHidratosCarbono = unidadMedidaHidratosCarbono;
        this.proteina = proteina;
        this.unidadMedidaProteina = unidadMedidaProteina;
        this.grasa = grasa;
        this.unidadMedidaGrasa = unidadMedidaGrasa;
        this.sodio = sodio;
        this.unidadMedidaSodio = unidadMedidaSodio;
        this.potasio = potasio;
        this.unidadMedidaPotasio = unidadMedidaPotasio;
        this.fosforo = fosforo;
        this.unidadMedidaFosforo = unidadMedidaFosforo;
        this.calcio = calcio;
        this.unidadMedidaCalcio = unidadMedidaCalcio;
        this.hierro = hierro;
        this.unidadMedidaHierro = unidadMedidaHierro;
        this.colesterol = colesterol;
        this.unidadMedidaColesterol = unidadMedidaColesterol;
        this.purinas = purinas;
        this.unidadMedidaPurinas = unidadMedidaPurinas;
        this.fibra = fibra;
        this.unidadMedidaFibra = unidadMedidaFibra;
        this.agua = agua;
        this.unidadMedidaAgua = unidadMedidaAgua;
        this.calorias = calorias;
    }

    public Integer getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(Integer codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public String getDescripcionAlimento() {
        return descripcionAlimento;
    }

    public void setDescripcionAlimento(String descripcionAlimento) {
        this.descripcionAlimento = descripcionAlimento;
    }

    public String getMedidaCasera() {
        return medidaCasera;
    }

    public void setMedidaCasera(String medidaCasera) {
        this.medidaCasera = medidaCasera;
    }

    public String getMedidaCaseraUnidad() {
        return medidaCaseraUnidad;
    }

    public void setMedidaCaseraUnidad(String medidaCaseraUnidad) {
        this.medidaCaseraUnidad = medidaCaseraUnidad;
    }

    public double getMedidaReal() {
        return medidaReal;
    }

    public void setMedidaReal(double medidaReal) {
        this.medidaReal = medidaReal;
    }

    public String getMedidaRealUnidad() {
        return medidaRealUnidad;
    }

    public void setMedidaRealUnidad(String medidaRealUnidad) {
        this.medidaRealUnidad = medidaRealUnidad;
    }

    public double getHidratosCarbono() {
        return hidratosCarbono;
    }

    public void setHidratosCarbono(double hidratosCarbono) {
        this.hidratosCarbono = hidratosCarbono;
    }

    public String getUnidadMedidaHidratosCarbono() {
        return unidadMedidaHidratosCarbono;
    }

    public void setUnidadMedidaHidratosCarbono(String unidadMedidaHidratosCarbono) {
        this.unidadMedidaHidratosCarbono = unidadMedidaHidratosCarbono;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public String getUnidadMedidaProteina() {
        return unidadMedidaProteina;
    }

    public void setUnidadMedidaProteina(String unidadMedidaProteina) {
        this.unidadMedidaProteina = unidadMedidaProteina;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    public String getUnidadMedidaGrasa() {
        return unidadMedidaGrasa;
    }

    public void setUnidadMedidaGrasa(String unidadMedidaGrasa) {
        this.unidadMedidaGrasa = unidadMedidaGrasa;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public String getUnidadMedidaSodio() {
        return unidadMedidaSodio;
    }

    public void setUnidadMedidaSodio(String unidadMedidaSodio) {
        this.unidadMedidaSodio = unidadMedidaSodio;
    }

    public double getPotasio() {
        return potasio;
    }

    public void setPotasio(double potasio) {
        this.potasio = potasio;
    }

    public String getUnidadMedidaPotasio() {
        return unidadMedidaPotasio;
    }

    public void setUnidadMedidaPotasio(String unidadMedidaPotasio) {
        this.unidadMedidaPotasio = unidadMedidaPotasio;
    }

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public String getUnidadMedidaFosforo() {
        return unidadMedidaFosforo;
    }

    public void setUnidadMedidaFosforo(String unidadMedidaFosforo) {
        this.unidadMedidaFosforo = unidadMedidaFosforo;
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    public String getUnidadMedidaCalcio() {
        return unidadMedidaCalcio;
    }

    public void setUnidadMedidaCalcio(String unidadMedidaCalcio) {
        this.unidadMedidaCalcio = unidadMedidaCalcio;
    }

    public double getHierro() {
        return hierro;
    }

    public void setHierro(double hierro) {
        this.hierro = hierro;
    }

    public String getUnidadMedidaHierro() {
        return unidadMedidaHierro;
    }

    public void setUnidadMedidaHierro(String unidadMedidaHierro) {
        this.unidadMedidaHierro = unidadMedidaHierro;
    }

    public double getColesterol() {
        return colesterol;
    }

    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    public String getUnidadMedidaColesterol() {
        return unidadMedidaColesterol;
    }

    public void setUnidadMedidaColesterol(String unidadMedidaColesterol) {
        this.unidadMedidaColesterol = unidadMedidaColesterol;
    }

    public double getPurinas() {
        return purinas;
    }

    public void setPurinas(double purinas) {
        this.purinas = purinas;
    }

    public String getUnidadMedidaPurinas() {
        return unidadMedidaPurinas;
    }

    public void setUnidadMedidaPurinas(String unidadMedidaPurinas) {
        this.unidadMedidaPurinas = unidadMedidaPurinas;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }

    public String getUnidadMedidaFibra() {
        return unidadMedidaFibra;
    }

    public void setUnidadMedidaFibra(String unidadMedidaFibra) {
        this.unidadMedidaFibra = unidadMedidaFibra;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public String getUnidadMedidaAgua() {
        return unidadMedidaAgua;
    }

    public void setUnidadMedidaAgua(String unidadMedidaAgua) {
        this.unidadMedidaAgua = unidadMedidaAgua;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public List<Dieta> getDietaList() {
        return dietaList;
    }

    public void setDietaList(List<Dieta> dietaList) {
        this.dietaList = dietaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAlimento != null ? codigoAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentos)) {
            return false;
        }
        Alimentos other = (Alimentos) object;
        if ((this.codigoAlimento == null && other.codigoAlimento != null) || (this.codigoAlimento != null && !this.codigoAlimento.equals(other.codigoAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alimentos[ codigoAlimento=" + codigoAlimento + " ]";
    }
    
}
