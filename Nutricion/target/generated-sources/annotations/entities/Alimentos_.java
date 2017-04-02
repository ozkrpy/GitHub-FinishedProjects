package entities;

import entities.Dieta;
import entities.TipoAlimento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-02T14:22:38")
@StaticMetamodel(Alimentos.class)
public class Alimentos_ { 

    public static volatile SingularAttribute<Alimentos, String> unidadMedidaProteina;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaHierro;
    public static volatile SingularAttribute<Alimentos, Double> calcio;
    public static volatile SingularAttribute<Alimentos, String> medidaCaseraUnidad;
    public static volatile SingularAttribute<Alimentos, Double> grasa;
    public static volatile SingularAttribute<Alimentos, Double> hierro;
    public static volatile SingularAttribute<Alimentos, TipoAlimento> tipoAlimento;
    public static volatile SingularAttribute<Alimentos, Integer> codigoAlimento;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaCalcio;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaFibra;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaSodio;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaColesterol;
    public static volatile SingularAttribute<Alimentos, String> medidaRealUnidad;
    public static volatile SingularAttribute<Alimentos, Double> medidaReal;
    public static volatile SingularAttribute<Alimentos, Double> potasio;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaPurinas;
    public static volatile SingularAttribute<Alimentos, Double> agua;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaFosforo;
    public static volatile SingularAttribute<Alimentos, Double> fibra;
    public static volatile SingularAttribute<Alimentos, Double> sodio;
    public static volatile SingularAttribute<Alimentos, Double> colesterol;
    public static volatile SingularAttribute<Alimentos, Double> calorias;
    public static volatile SingularAttribute<Alimentos, String> medidaCasera;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaAgua;
    public static volatile ListAttribute<Alimentos, Dieta> dietaList;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaPotasio;
    public static volatile SingularAttribute<Alimentos, Double> proteina;
    public static volatile SingularAttribute<Alimentos, Double> fosforo;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaGrasa;
    public static volatile SingularAttribute<Alimentos, String> unidadMedidaHidratosCarbono;
    public static volatile SingularAttribute<Alimentos, Double> purinas;
    public static volatile SingularAttribute<Alimentos, String> descripcionAlimento;
    public static volatile SingularAttribute<Alimentos, Double> hidratosCarbono;

}