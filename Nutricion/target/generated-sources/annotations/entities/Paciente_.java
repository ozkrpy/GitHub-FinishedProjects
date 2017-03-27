package entities;

import entities.Dieta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-27T17:40:43")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Float> pesoSaludable;
    public static volatile SingularAttribute<Paciente, Float> ciaMuneca;
    public static volatile SingularAttribute<Paciente, Boolean> antecedenteCardiopatias;
    public static volatile SingularAttribute<Paciente, String> diagnosticoNutricional;
    public static volatile SingularAttribute<Paciente, Float> laboratorioGlobulosBlancos;
    public static volatile SingularAttribute<Paciente, Integer> talla;
    public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
    public static volatile SingularAttribute<Paciente, Float> laboratorioNa;
    public static volatile SingularAttribute<Paciente, Float> laboratorioHdl;
    public static volatile SingularAttribute<Paciente, Float> laboratorioCi;
    public static volatile SingularAttribute<Paciente, Float> laboratorioLdl;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, Float> pesoActual;
    public static volatile SingularAttribute<Paciente, Float> laboratorioHematocrito;
    public static volatile SingularAttribute<Paciente, String> diagnosticoMedico;
    public static volatile SingularAttribute<Paciente, Float> laboratorioUrea;
    public static volatile SingularAttribute<Paciente, String> apellido;
    public static volatile SingularAttribute<Paciente, Float> porcentajePesoIdeal;
    public static volatile SingularAttribute<Paciente, Float> laboratorioAcidoUrico;
    public static volatile SingularAttribute<Paciente, Float> laboratorioCreatinina;
    public static volatile SingularAttribute<Paciente, String> biotipo;
    public static volatile SingularAttribute<Paciente, String> medicacion;
    public static volatile SingularAttribute<Paciente, Float> laboratorioProteinuria;
    public static volatile SingularAttribute<Paciente, Boolean> antecedenteDiabetes;
    public static volatile SingularAttribute<Paciente, Float> laboratorioGlobulosRojos;
    public static volatile SingularAttribute<Paciente, Float> laboratorioColesterolTotal;
    public static volatile SingularAttribute<Paciente, Float> laboratorioPotasio;
    public static volatile SingularAttribute<Paciente, Integer> codigoPaciente;
    public static volatile SingularAttribute<Paciente, String> estadoCivil;
    public static volatile SingularAttribute<Paciente, Float> ciaBrazo;
    public static volatile SingularAttribute<Paciente, Float> laboratorioGlicemiaBasal;
    public static volatile SingularAttribute<Paciente, Boolean> antecedenteObesidad;
    public static volatile SingularAttribute<Paciente, Boolean> antecedenteHta;
    public static volatile ListAttribute<Paciente, Dieta> dietaList;
    public static volatile SingularAttribute<Paciente, Float> pesoAjusta;
    public static volatile SingularAttribute<Paciente, Float> laboratorioAlbumina;
    public static volatile SingularAttribute<Paciente, Float> laboratorioHba;
    public static volatile SingularAttribute<Paciente, Float> laboratorioProteinasTotales;
    public static volatile SingularAttribute<Paciente, Float> laboratorioTriglicerios;
    public static volatile SingularAttribute<Paciente, Float> pesoHabitual;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, Float> laboratorioHb;
    public static volatile SingularAttribute<Paciente, Float> imc;
    public static volatile SingularAttribute<Paciente, Float> ciaCintura1;
    public static volatile SingularAttribute<Paciente, Float> laboratorioGlucosa;
    public static volatile SingularAttribute<Paciente, Float> ciaCintura2;

}