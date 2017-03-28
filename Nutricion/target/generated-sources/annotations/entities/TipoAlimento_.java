package entities;

import entities.Alimentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-28T17:56:48")
@StaticMetamodel(TipoAlimento.class)
public class TipoAlimento_ { 

    public static volatile SingularAttribute<TipoAlimento, Integer> codigoTipoAlimento;
    public static volatile SingularAttribute<TipoAlimento, String> descripcionTipoAlimento;
    public static volatile ListAttribute<TipoAlimento, Alimentos> alimentosList;

}