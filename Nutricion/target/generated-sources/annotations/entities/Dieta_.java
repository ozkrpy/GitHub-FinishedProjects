package entities;

import entities.Alimentos;
import entities.DietaPK;
import entities.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T19:04:24")
@StaticMetamodel(Dieta.class)
public class Dieta_ { 

    public static volatile SingularAttribute<Dieta, Alimentos> codigoAlimento;
    public static volatile SingularAttribute<Dieta, Double> cantidadAlimento;
    public static volatile SingularAttribute<Dieta, DietaPK> dietaPK;
    public static volatile SingularAttribute<Dieta, Paciente> codigoPaciente;

}