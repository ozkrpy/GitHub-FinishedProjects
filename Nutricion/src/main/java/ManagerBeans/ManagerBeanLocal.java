/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBeans;

import entities.ElementoListaBasico;
import entities.Alimentos;
import entities.Dieta;
import entities.DietaPK;
import entities.Paciente;
import entities.ReferenciaXDieta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ozkrp
 */
@Local
public interface ManagerBeanLocal {
    
    List<Paciente> listadoPacientes(); 
    List<Alimentos> listadoAlimentos(); 
    Alimentos detalleAlimento(int codigo);
    List<ElementoListaBasico> nombreAlimentosPAVB();
    int agregarAlimentoDieta(int codigoDieta, int numeroItem, int codigoAlimento, int cantidad, int codigoPaciente);
    List listadoDietas();
    List<Dieta> detalleDieta(int codigoDieta);
    int siguienteItem(int codigoDieta);
    void borrarAlimentoDieta(int codigoDieta, int numeroItem);
    void actualizarDieta(DietaPK dietaModificar, double nuevaCantidad);
    List<ElementoListaBasico> nombrePacientes();
    Paciente detallePaciente(int codigoPaciente);
    void registrarPaciente(Paciente nuevo);
    double calcularPI(int edad, String sexo, int talla, String biotipo);
    List dietasPorPaciente(int codigoPaciente);
    void actualizarReferenciaDieta(int codigoDieta, double hc, double proteina, double grasa, double fibra);
    ReferenciaXDieta recuperaReferencias(int codigoDieta);
}
