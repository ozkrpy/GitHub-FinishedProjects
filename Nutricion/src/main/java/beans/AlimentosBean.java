/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ManagerBeans.ManagerBeanLocal;
import entities.Alimentos;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "alimentosBean")
@RequestScoped
public class AlimentosBean {

    private List<Alimentos> listaAlimentos;
    private Alimentos detalle;
    
    @EJB
    private ManagerBeanLocal manager;
    
    public AlimentosBean() {
    }

    @PostConstruct
    public void init() {
        listaAlimentos = manager.listadoAlimentos();
    }
    public List<Alimentos> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(List<Alimentos> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public Alimentos getDetalle() {
        return detalle;
    }

    public void setDetalle(Alimentos detalle) {
        this.detalle = detalle;
    }
    
    public String recuperaDetalles(int codigo) {
        detalle = manager.detalleAlimento(codigo);
        return "detalleAlimentos";
    }
    
    
}
