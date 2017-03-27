/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.getMaxCodigoPaciente", query = "SELECT MAX(p.codigoPaciente) FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByCodigoPaciente", query = "SELECT p FROM Paciente p WHERE p.codigoPaciente = :codigoPaciente"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellido", query = "SELECT p FROM Paciente p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Paciente.findByTalla", query = "SELECT p FROM Paciente p WHERE p.talla = :talla"),
    @NamedQuery(name = "Paciente.findByEstadoCivil", query = "SELECT p FROM Paciente p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByPesoActual", query = "SELECT p FROM Paciente p WHERE p.pesoActual = :pesoActual"),
    @NamedQuery(name = "Paciente.findByPesoHabitual", query = "SELECT p FROM Paciente p WHERE p.pesoHabitual = :pesoHabitual"),
    @NamedQuery(name = "Paciente.findByPesoAjusta", query = "SELECT p FROM Paciente p WHERE p.pesoAjusta = :pesoAjusta"),
    @NamedQuery(name = "Paciente.findByPesoSaludable", query = "SELECT p FROM Paciente p WHERE p.pesoSaludable = :pesoSaludable"),
    @NamedQuery(name = "Paciente.findByPorcentajePesoIdeal", query = "SELECT p FROM Paciente p WHERE p.porcentajePesoIdeal = :porcentajePesoIdeal"),
    @NamedQuery(name = "Paciente.findByImc", query = "SELECT p FROM Paciente p WHERE p.imc = :imc"),
    @NamedQuery(name = "Paciente.findByCiaMuneca", query = "SELECT p FROM Paciente p WHERE p.ciaMuneca = :ciaMuneca"),
    @NamedQuery(name = "Paciente.findByCiaBrazo", query = "SELECT p FROM Paciente p WHERE p.ciaBrazo = :ciaBrazo"),
    @NamedQuery(name = "Paciente.findByBiotipo", query = "SELECT p FROM Paciente p WHERE p.biotipo = :biotipo"),
    @NamedQuery(name = "Paciente.findByAntecedenteObesidad", query = "SELECT p FROM Paciente p WHERE p.antecedenteObesidad = :antecedenteObesidad"),
    @NamedQuery(name = "Paciente.findByAntecedenteCardiopatias", query = "SELECT p FROM Paciente p WHERE p.antecedenteCardiopatias = :antecedenteCardiopatias"),
    @NamedQuery(name = "Paciente.findByAntecedenteHta", query = "SELECT p FROM Paciente p WHERE p.antecedenteHta = :antecedenteHta"),
    @NamedQuery(name = "Paciente.findByAntecedenteDiabetes", query = "SELECT p FROM Paciente p WHERE p.antecedenteDiabetes = :antecedenteDiabetes"),
    @NamedQuery(name = "Paciente.findByMedicacion", query = "SELECT p FROM Paciente p WHERE p.medicacion = :medicacion"),
    @NamedQuery(name = "Paciente.findByDiagnosticoMedico", query = "SELECT p FROM Paciente p WHERE p.diagnosticoMedico = :diagnosticoMedico"),
    @NamedQuery(name = "Paciente.findByDiagnosticoNutricional", query = "SELECT p FROM Paciente p WHERE p.diagnosticoNutricional = :diagnosticoNutricional"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlicemiaBasal", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlicemiaBasal = :laboratorioGlicemiaBasal"),
    @NamedQuery(name = "Paciente.findByLaboratorioCreatinina", query = "SELECT p FROM Paciente p WHERE p.laboratorioCreatinina = :laboratorioCreatinina"),
    @NamedQuery(name = "Paciente.findByLaboratorioProteinasTotales", query = "SELECT p FROM Paciente p WHERE p.laboratorioProteinasTotales = :laboratorioProteinasTotales"),
    @NamedQuery(name = "Paciente.findByLaboratorioUrea", query = "SELECT p FROM Paciente p WHERE p.laboratorioUrea = :laboratorioUrea"),
    @NamedQuery(name = "Paciente.findByLaboratorioAcidoUrico", query = "SELECT p FROM Paciente p WHERE p.laboratorioAcidoUrico = :laboratorioAcidoUrico"),
    @NamedQuery(name = "Paciente.findByLaboratorioProteinuria", query = "SELECT p FROM Paciente p WHERE p.laboratorioProteinuria = :laboratorioProteinuria"),
    @NamedQuery(name = "Paciente.findByLaboratorioAlbumina", query = "SELECT p FROM Paciente p WHERE p.laboratorioAlbumina = :laboratorioAlbumina"),
    @NamedQuery(name = "Paciente.findByLaboratorioTriglicerios", query = "SELECT p FROM Paciente p WHERE p.laboratorioTriglicerios = :laboratorioTriglicerios"),
    @NamedQuery(name = "Paciente.findByLaboratorioColesterolTotal", query = "SELECT p FROM Paciente p WHERE p.laboratorioColesterolTotal = :laboratorioColesterolTotal"),
    @NamedQuery(name = "Paciente.findByLaboratorioLdl", query = "SELECT p FROM Paciente p WHERE p.laboratorioLdl = :laboratorioLdl"),
    @NamedQuery(name = "Paciente.findByLaboratorioHdl", query = "SELECT p FROM Paciente p WHERE p.laboratorioHdl = :laboratorioHdl"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlucosa", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlucosa = :laboratorioGlucosa"),
    @NamedQuery(name = "Paciente.findByLaboratorioHb", query = "SELECT p FROM Paciente p WHERE p.laboratorioHb = :laboratorioHb"),
    @NamedQuery(name = "Paciente.findByLaboratorioHematocrito", query = "SELECT p FROM Paciente p WHERE p.laboratorioHematocrito = :laboratorioHematocrito"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlobulosRojos", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlobulosRojos = :laboratorioGlobulosRojos"),
    @NamedQuery(name = "Paciente.findByLaboratorioPotasio", query = "SELECT p FROM Paciente p WHERE p.laboratorioPotasio = :laboratorioPotasio"),
    @NamedQuery(name = "Paciente.findByLaboratorioCi", query = "SELECT p FROM Paciente p WHERE p.laboratorioCi = :laboratorioCi"),
    @NamedQuery(name = "Paciente.findByLaboratorioNa", query = "SELECT p FROM Paciente p WHERE p.laboratorioNa = :laboratorioNa"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlobulosBlancos", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlobulosBlancos = :laboratorioGlobulosBlancos"),
    @NamedQuery(name = "Paciente.findByLaboratorioHba", query = "SELECT p FROM Paciente p WHERE p.laboratorioHba = :laboratorioHba")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_paciente")
    private Integer codigoPaciente;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "talla")
    private Integer talla;
    @Size(max = 45)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Max(value=500)  @Min(value=1)
    @Column(name = "peso_actual")
    private Float pesoActual;
    @Column(name = "peso_habitual")
    private Float pesoHabitual;
    @Column(name = "peso_ajusta")
    private Float pesoAjusta;
    @Column(name = "peso_saludable")
    private Float pesoSaludable;
    @Column(name = "porcentaje_peso_ideal")
    private Float porcentajePesoIdeal;
    @Column(name = "imc")
    private Float imc;
    @Column(name = "cia_muneca")
    private Float ciaMuneca;
    @Column(name = "cia_brazo")
    private Float ciaBrazo;
    @Size(max = 45)
    @Column(name = "biotipo")
    private String biotipo;
    @Column(name = "antecedente_obesidad")
    private Boolean antecedenteObesidad;
    @Column(name = "antecedente_cardiopatias")
    private Boolean antecedenteCardiopatias;
    @Column(name = "antecedente_hta")
    private Boolean antecedenteHta;
    @Column(name = "antecedente_diabetes")
    private Boolean antecedenteDiabetes;
    @Size(max = 500)
    @Column(name = "medicacion")
    private String medicacion;
    @Size(max = 500)
    @Column(name = "diagnostico_medico")
    private String diagnosticoMedico;
    @Size(max = 500)
    @Column(name = "diagnostico_nutricional")
    private String diagnosticoNutricional;
    @Column(name = "laboratorio_glicemia_basal")
    private Float laboratorioGlicemiaBasal;
    @Column(name = "laboratorio_creatinina")
    private Float laboratorioCreatinina;
    @Column(name = "laboratorio_proteinas_totales")
    private Float laboratorioProteinasTotales;
    @Column(name = "laboratorio_urea")
    private Float laboratorioUrea;
    @Column(name = "laboratorio_acido_urico")
    private Float laboratorioAcidoUrico;
    @Column(name = "laboratorio_proteinuria")
    private Float laboratorioProteinuria;
    @Column(name = "laboratorio_albumina")
    private Float laboratorioAlbumina;
    @Column(name = "laboratorio_triglicerios")
    private Float laboratorioTriglicerios;
    @Column(name = "laboratorio_colesterol_total")
    private Float laboratorioColesterolTotal;
    @Column(name = "laboratorio_ldl")
    private Float laboratorioLdl;
    @Column(name = "laboratorio_hdl")
    private Float laboratorioHdl;
    @Column(name = "laboratorio_glucosa")
    private Float laboratorioGlucosa;
    @Column(name = "laboratorio_hb")
    private Float laboratorioHb;
    @Column(name = "laboratorio_hematocrito")
    private Float laboratorioHematocrito;
    @Column(name = "laboratorio_globulos_rojos")
    private Float laboratorioGlobulosRojos;
    @Column(name = "laboratorio_potasio")
    private Float laboratorioPotasio;
    @Column(name = "laboratorio_ci")
    private Float laboratorioCi;
    @Column(name = "laboratorio_na")
    private Float laboratorioNa;
    @Column(name = "laboratorio_globulos_blancos")
    private Float laboratorioGlobulosBlancos;
    @Column(name = "laboratorio_hba")
    private Float laboratorioHba;
    @Column(name = "cia_cintura1")
    private Float ciaCintura1;
    @Column(name = "cia_cintura2")
    private Float ciaCintura2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente")
    private List<Dieta> dietaList;

    public Paciente() {
    }

    public Paciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Float pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Float getPesoHabitual() {
        return pesoHabitual;
    }

    public void setPesoHabitual(Float pesoHabitual) {
        this.pesoHabitual = pesoHabitual;
    }

    public Float getPesoAjusta() {
        return pesoAjusta;
    }

    public void setPesoAjusta(Float pesoAjusta) {
        this.pesoAjusta = pesoAjusta;
    }

    public Float getPesoSaludable() {
        return pesoSaludable;
    }

    public void setPesoSaludable(Float pesoSaludable) {
        this.pesoSaludable = pesoSaludable;
    }

    public Float getPorcentajePesoIdeal() {
        return porcentajePesoIdeal;
    }

    public void setPorcentajePesoIdeal(Float porcentajePesoIdeal) {
        this.porcentajePesoIdeal = porcentajePesoIdeal;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public Float getCiaMuneca() {
        return ciaMuneca;
    }

    public void setCiaMuneca(Float ciaMuneca) {
        this.ciaMuneca = ciaMuneca;
    }

    public Float getCiaBrazo() {
        return ciaBrazo;
    }

    public void setCiaBrazo(Float ciaBrazo) {
        this.ciaBrazo = ciaBrazo;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.biotipo = biotipo;
    }

    public Boolean getAntecedenteObesidad() {
        return antecedenteObesidad;
    }

    public void setAntecedenteObesidad(Boolean antecedenteObesidad) {
        this.antecedenteObesidad = antecedenteObesidad;
    }

    public Boolean getAntecedenteCardiopatias() {
        return antecedenteCardiopatias;
    }

    public void setAntecedenteCardiopatias(Boolean antecedenteCardiopatias) {
        this.antecedenteCardiopatias = antecedenteCardiopatias;
    }

    public Boolean getAntecedenteHta() {
        return antecedenteHta;
    }

    public void setAntecedenteHta(Boolean antecedenteHta) {
        this.antecedenteHta = antecedenteHta;
    }

    public Boolean getAntecedenteDiabetes() {
        return antecedenteDiabetes;
    }

    public void setAntecedenteDiabetes(Boolean antecedenteDiabetes) {
        this.antecedenteDiabetes = antecedenteDiabetes;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public String getDiagnosticoMedico() {
        return diagnosticoMedico;
    }

    public void setDiagnosticoMedico(String diagnosticoMedico) {
        this.diagnosticoMedico = diagnosticoMedico;
    }

    public String getDiagnosticoNutricional() {
        return diagnosticoNutricional;
    }

    public void setDiagnosticoNutricional(String diagnosticoNutricional) {
        this.diagnosticoNutricional = diagnosticoNutricional;
    }

    public Float getLaboratorioGlicemiaBasal() {
        return laboratorioGlicemiaBasal;
    }

    public void setLaboratorioGlicemiaBasal(Float laboratorioGlicemiaBasal) {
        this.laboratorioGlicemiaBasal = laboratorioGlicemiaBasal;
    }

    public Float getLaboratorioCreatinina() {
        return laboratorioCreatinina;
    }

    public void setLaboratorioCreatinina(Float laboratorioCreatinina) {
        this.laboratorioCreatinina = laboratorioCreatinina;
    }

    public Float getLaboratorioProteinasTotales() {
        return laboratorioProteinasTotales;
    }

    public void setLaboratorioProteinasTotales(Float laboratorioProteinasTotales) {
        this.laboratorioProteinasTotales = laboratorioProteinasTotales;
    }

    public Float getLaboratorioUrea() {
        return laboratorioUrea;
    }

    public void setLaboratorioUrea(Float laboratorioUrea) {
        this.laboratorioUrea = laboratorioUrea;
    }

    public Float getLaboratorioAcidoUrico() {
        return laboratorioAcidoUrico;
    }

    public void setLaboratorioAcidoUrico(Float laboratorioAcidoUrico) {
        this.laboratorioAcidoUrico = laboratorioAcidoUrico;
    }

    public Float getLaboratorioProteinuria() {
        return laboratorioProteinuria;
    }

    public void setLaboratorioProteinuria(Float laboratorioProteinuria) {
        this.laboratorioProteinuria = laboratorioProteinuria;
    }

    public Float getLaboratorioAlbumina() {
        return laboratorioAlbumina;
    }

    public void setLaboratorioAlbumina(Float laboratorioAlbumina) {
        this.laboratorioAlbumina = laboratorioAlbumina;
    }

    public Float getLaboratorioTriglicerios() {
        return laboratorioTriglicerios;
    }

    public void setLaboratorioTriglicerios(Float laboratorioTriglicerios) {
        this.laboratorioTriglicerios = laboratorioTriglicerios;
    }

    public Float getLaboratorioColesterolTotal() {
        return laboratorioColesterolTotal;
    }

    public void setLaboratorioColesterolTotal(Float laboratorioColesterolTotal) {
        this.laboratorioColesterolTotal = laboratorioColesterolTotal;
    }

    public Float getLaboratorioLdl() {
        return laboratorioLdl;
    }

    public void setLaboratorioLdl(Float laboratorioLdl) {
        this.laboratorioLdl = laboratorioLdl;
    }

    public Float getLaboratorioHdl() {
        return laboratorioHdl;
    }

    public void setLaboratorioHdl(Float laboratorioHdl) {
        this.laboratorioHdl = laboratorioHdl;
    }

    public Float getLaboratorioGlucosa() {
        return laboratorioGlucosa;
    }

    public void setLaboratorioGlucosa(Float laboratorioGlucosa) {
        this.laboratorioGlucosa = laboratorioGlucosa;
    }

    public Float getLaboratorioHb() {
        return laboratorioHb;
    }

    public void setLaboratorioHb(Float laboratorioHb) {
        this.laboratorioHb = laboratorioHb;
    }

    public Float getLaboratorioHematocrito() {
        return laboratorioHematocrito;
    }

    public void setLaboratorioHematocrito(Float laboratorioHematocrito) {
        this.laboratorioHematocrito = laboratorioHematocrito;
    }

    public Float getLaboratorioGlobulosRojos() {
        return laboratorioGlobulosRojos;
    }

    public void setLaboratorioGlobulosRojos(Float laboratorioGlobulosRojos) {
        this.laboratorioGlobulosRojos = laboratorioGlobulosRojos;
    }

    public Float getLaboratorioPotasio() {
        return laboratorioPotasio;
    }

    public void setLaboratorioPotasio(Float laboratorioPotasio) {
        this.laboratorioPotasio = laboratorioPotasio;
    }

    public Float getLaboratorioCi() {
        return laboratorioCi;
    }

    public void setLaboratorioCi(Float laboratorioCi) {
        this.laboratorioCi = laboratorioCi;
    }

    public Float getLaboratorioNa() {
        return laboratorioNa;
    }

    public void setLaboratorioNa(Float laboratorioNa) {
        this.laboratorioNa = laboratorioNa;
    }

    public Float getLaboratorioGlobulosBlancos() {
        return laboratorioGlobulosBlancos;
    }

    public void setLaboratorioGlobulosBlancos(Float laboratorioGlobulosBlancos) {
        this.laboratorioGlobulosBlancos = laboratorioGlobulosBlancos;
    }

    public Float getLaboratorioHba() {
        return laboratorioHba;
    }

    public void setLaboratorioHba(Float laboratorioHba) {
        this.laboratorioHba = laboratorioHba;
    }

    public Float getCiaCintura1() {
        return ciaCintura1;
    }

    public void setCiaCintura1(Float ciaCintura1) {
        this.ciaCintura1 = ciaCintura1;
    }

    public Float getCiaCintura2() {
        return ciaCintura2;
    }

    public void setCiaCintura2(Float ciaCintura2) {
        this.ciaCintura2 = ciaCintura2;
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
        hash += (codigoPaciente != null ? codigoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.codigoPaciente == null && other.codigoPaciente != null) || (this.codigoPaciente != null && !this.codigoPaciente.equals(other.codigoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Paciente[ codigoPaciente=" + codigoPaciente + " ]";
    }
    
}
