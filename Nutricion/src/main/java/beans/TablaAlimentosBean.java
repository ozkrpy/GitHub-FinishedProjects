/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ManagerBeans.ManagerBeanLocal;
import entities.ElementoListaBasico;
import entities.Alimentos;
import entities.DatosDieta;
import entities.Dieta;
import entities.DietaPK;
import entities.Paciente;
import entities.ReferenciaXDieta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ozkrp
 */
@Named(value = "tablaAlimentosBean")
@SessionScoped
public class TablaAlimentosBean implements Serializable {

    /**
     * FIELDS FOR INPUT
     */
    private int codigoDieta;
    private int numeroItemDieta;
    private int cantidadNuevoAlimentoPAVB;
    private List<ElementoListaBasico> listaDesplegableAlimentosPAVB;
    private List<ElementoListaBasico> listaDesplegablePacientes;
    private List listaDesplegableDietas;
    private int codigoAlimentoSeleccionado;
    private int codigoPaciente;
    private List<DatosDieta> tablaAlimentos = new ArrayList<DatosDieta>();
    private List<DatosDieta> tablaAlimentosNoPAVB = new ArrayList<DatosDieta>();
    private Paciente paciente;
    private DatosDieta modificarDieta;

    /**
     * FIELDS FOR OUTPUT
     */
    private double cantidadAlimentoModificado = 1;
    private double sumatoriaHidratosCarbono;
    private double sumatoriaHidratosCarbonoPAVB;
    private double sumatoriaProteina;
    private double sumatoriaProteinaPAVB;
    private double sumatoriaGrasa;
    private double sumatoriaGrasaPAVB;
    private double sumatoriaFibra;
    private double sumatoriaFibraPAVB;
    private double sumatoriaCalorias;
    private double sumatoriaCaloriasPAVB;
    private boolean mostrarFormularioPaciente;
    private boolean mostrarFormularioCalculo;
    private boolean mostrarFormularioAlimentos;
    private int edad;
    private String tipoImc;
    private String tipoPorcentajePI;

    /**
     * CAMPOS PARA CALCULOS
     */
    private double HC;
    private double minHC;
    private double maxHC;
    private double kcalHC;

    private double proteina;
    private double minProteina;
    private double maxProteina;
    private double kcalProteina;

    private double grasa;
    private double minGrasa;
    private double maxGrasa;
    private double kcalGrasa;

    private double fibra;
    private double minFibra;
    private double maxFibra;
    private double kcalFibra;

    @EJB
    private ManagerBeanLocal managerBeanLocal;

    /**
     * CONSTRUCTORS
     */
    public TablaAlimentosBean() {
    }

    /**
     * PAGE VARIABLES PRE-LOAD
     */
    @PostConstruct
    public void init() {
        listaDesplegableAlimentosPAVB = managerBeanLocal.nombreAlimentosPAVB();
        listaDesplegablePacientes = managerBeanLocal.nombrePacientes();
        listaDesplegableDietas = managerBeanLocal.listadoDietas();
    }

    public List<ElementoListaBasico> getListaDesplegablePacientes() {
        return listaDesplegablePacientes;
    }

    /**
     * GETTERs & SETTERs
     */
    public void setListaDesplegablePacientes(List<ElementoListaBasico> listaDesplegablePacientes) {
        this.listaDesplegablePacientes = listaDesplegablePacientes;
    }

    public int getCodigoAlimentoSeleccionado() {
        return codigoAlimentoSeleccionado;
    }

    public void setCodigoAlimentoSeleccionado(int codigoAlimentoSeleccionado) {
        this.codigoAlimentoSeleccionado = codigoAlimentoSeleccionado;
    }

    public int getCantidadNuevoAlimentoPAVB() {
        return cantidadNuevoAlimentoPAVB;
    }

    public void setCantidadNuevoAlimentoPAVB(int cantidadNuevoAlimentoPAVB) {
        this.cantidadNuevoAlimentoPAVB = cantidadNuevoAlimentoPAVB;
    }

    public List<ElementoListaBasico> getListaDesplegableAlimentosPAVB() {
        return listaDesplegableAlimentosPAVB;
    }

    public void setListaDesplegableAlimentosPAVB(List<ElementoListaBasico> listaDesplegableAlimentosPAVB) {
        this.listaDesplegableAlimentosPAVB = listaDesplegableAlimentosPAVB;
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public List<DatosDieta> getTablaAlimentos() {
        return tablaAlimentos;
    }

    public void setTablaAlimentos(List<DatosDieta> tablaAlimentos) {
        this.tablaAlimentos = tablaAlimentos;
    }

    public int getCodigoDieta() {
        return codigoDieta;
    }

    public void setCodigoDieta(int codigoDieta) {
        this.codigoDieta = codigoDieta;
    }

    public List getListaDesplegableDietas() {
        return listaDesplegableDietas;
    }

    public void setListaDesplegableDietas(List listaDesplegableDietas) {
        this.listaDesplegableDietas = listaDesplegableDietas;
    }

    public double getSumatoriaHidratosCarbono() {
        return sumatoriaHidratosCarbono;
    }

    public void setSumatoriaHidratosCarbono(double sumatoriaHidratosCarbono) {
        this.sumatoriaHidratosCarbono = sumatoriaHidratosCarbono;
    }

    public double getSumatoriaProteina() {
        return sumatoriaProteina;
    }

    public void setSumatoriaProteina(double sumatoriaProteina) {
        this.sumatoriaProteina = sumatoriaProteina;
    }

    public double getSumatoriaGrasa() {
        return sumatoriaGrasa;
    }

    public void setSumatoriaGrasa(double sumatoriaGrasa) {
        this.sumatoriaGrasa = sumatoriaGrasa;
    }

    public double getSumatoriaFibra() {
        return sumatoriaFibra;
    }

    public void setSumatoriaFibra(double sumatoriaFibra) {
        this.sumatoriaFibra = sumatoriaFibra;
    }

    public double getSumatoriaCalorias() {
        return sumatoriaCalorias;
    }

    public void setSumatoriaCalorias(double sumatoriaCalorias) {
        this.sumatoriaCalorias = sumatoriaCalorias;
    }

    public double getHC() {
        return HC;
    }

    public void setHC(double HC) {
        this.HC = HC;
        this.minHC = HC - 5;
        this.maxHC = HC + 5;

    }

    public double getMinHC() {
        return minHC;
    }

    public void setMinHC(double minHC) {
        this.minHC = HC - 5;
    }

    public double getMaxHC() {
        return maxHC;
    }

    public void setMaxHC(double maxHC) {
        this.maxHC = HC + 5;
    }

    public double getKcalHC() {
        return kcalHC;
    }

    public void setKcalHC(double kcalHC) {
        this.kcalHC = sumatoriaHidratosCarbono * 4;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
        this.minProteina = proteina - 5;
        this.maxProteina = proteina + 5;

    }

    public double getMinProteina() {
        return minProteina;
    }

    public void setMinProteina(double minProteina) {
        this.minProteina = proteina - 5;
    }

    public double getMaxProteina() {
        return maxProteina;
    }

    public void setMaxProteina(double maxProteina) {
        this.maxProteina = proteina + 5;
    }

    public double getKcalProteina() {
        return kcalProteina;
    }

    public void setKcalProteina(double kcalProteina) {
        this.kcalProteina = kcalProteina;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
        this.minGrasa = grasa - 5;
        this.maxGrasa = grasa + 5;

    }

    public double getMinGrasa() {
        return minGrasa;
    }

    public void setMinGrasa(double minGrasa) {
        this.minGrasa = grasa - 5;
    }

    public double getMaxGrasa() {
        return maxGrasa;
    }

    public void setMaxGrasa(double maxGrasa) {
        this.maxGrasa = grasa + 5;
    }

    public double getKcalGrasa() {
        return kcalGrasa;
    }

    public void setKcalGrasa(double kcalGrasa) {
        this.kcalGrasa = kcalGrasa;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
        this.minFibra = fibra * 0.95;
        this.maxFibra = fibra * 1.05;

    }

    public double getMinFibra() {
        return minFibra;
    }

    public void setMinFibra(double minFibra) {
        this.minFibra = fibra * 0.95;
    }

    public double getMaxFibra() {
        return maxFibra;
    }

    public void setMaxFibra(double maxFibra) {
        this.maxFibra = fibra * 1.05;
    }

    public double getKcalFibra() {
        return kcalFibra;
    }

    public void setKcalFibra(double kcalFibra) {
        this.kcalFibra = kcalFibra;
    }

    public void changeListenerCampos() {
        System.out.println("Se instancio el modulo changeListenerCampos(), codigo dieta: " + codigoDieta);
        if(codigoDieta != 0) {
            agregarReferenciasDieta();
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DatosDieta getModificarDieta() {
        return modificarDieta;
    }

    public void setModificarDieta(DatosDieta modificarDieta) {
        this.modificarDieta = modificarDieta;
    }

    public double getCantidadAlimentoModificado() {
        return cantidadAlimentoModificado;
    }

    public void setCantidadAlimentoModificado(double cantidadAlimentoModificado) {
        this.cantidadAlimentoModificado = cantidadAlimentoModificado;
    }

    public List<DatosDieta> getTablaAlimentosNoPAVB() {
        return tablaAlimentosNoPAVB;
    }

    public void setTablaAlimentosNoPAVB(List<DatosDieta> tablaAlimentosNoPAVB) {
        this.tablaAlimentosNoPAVB = tablaAlimentosNoPAVB;
    }

    public double getSumatoriaProteinaPAVB() {
        return sumatoriaProteinaPAVB;
    }

    public void setSumatoriaProteinaPAVB(double sumatoriaProteinaPAVB) {
        this.sumatoriaProteinaPAVB = sumatoriaProteinaPAVB;
    }

    public double getSumatoriaGrasaPAVB() {
        return sumatoriaGrasaPAVB;
    }

    public void setSumatoriaGrasaPAVB(double sumatoriaGrasaPAVB) {
        this.sumatoriaGrasaPAVB = sumatoriaGrasaPAVB;
    }

    public double getSumatoriaFibraPAVB() {
        return sumatoriaFibraPAVB;
    }

    public void setSumatoriaFibraPAVB(double sumatoriaFibraPAVB) {
        this.sumatoriaFibraPAVB = sumatoriaFibraPAVB;
    }

    public double getSumatoriaCaloriasPAVB() {
        return sumatoriaCaloriasPAVB;
    }

    public void setSumatoriaCaloriasPAVB(double sumatoriaCaloriasPAVB) {
        this.sumatoriaCaloriasPAVB = sumatoriaCaloriasPAVB;
    }

    public double getSumatoriaHidratosCarbonoPAVB() {
        return sumatoriaHidratosCarbonoPAVB;
    }

    public void setSumatoriaHidratosCarbonoPAVB(double sumatoriaHidratosCarbonoPAVB) {
        this.sumatoriaHidratosCarbonoPAVB = sumatoriaHidratosCarbonoPAVB;
    }

    public boolean isMostrarFormularioPaciente() {
        return mostrarFormularioPaciente;
    }

    public void setMostrarFormularioPaciente(boolean mostrarFormularioPaciente) {
        this.mostrarFormularioPaciente = mostrarFormularioPaciente;
    }

    public boolean isMostrarFormularioCalculo() {
        return mostrarFormularioCalculo;
    }

    public void setMostrarFormularioCalculo(boolean mostrarFormularioCalculo) {
        this.mostrarFormularioCalculo = mostrarFormularioCalculo;
    }

    public boolean isMostrarFormularioAlimentos() {
        return mostrarFormularioAlimentos;
    }

    public void setMostrarFormularioAlimentos(boolean mostrarFormularioAlimentos) {
        this.mostrarFormularioAlimentos = mostrarFormularioAlimentos;
    }

    public int getNumeroItemDieta() {
        return numeroItemDieta;
    }

    public void setNumeroItemDieta(int numeroItemDieta) {
        this.numeroItemDieta = numeroItemDieta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoImc() {
        return tipoImc;
    }

    public void setTipoImc(String tipoImc) {
        this.tipoImc = tipoImc;
    }

    public String getTipoPorcentajePI() {
        return tipoPorcentajePI;
    }

    public void setTipoPorcentajePI(String tipoPorcentajePI) {
        this.tipoPorcentajePI = tipoPorcentajePI;
    }

    /**
     * METHODS
     */
    public void changeListenerCodigoDieta() {
        if (codigoDieta != 0) {
            actualizaListaAlimentos(codigoDieta);
            cargarDatosPaciente();
        } else {
            resetAllValues();
            resetReferenciasMinMax();
        }
        cargarDatosReferencia();
        
    }

    public void changeListenerCodigoPaciente() {
        if (codigoPaciente != 0) {
            listaDesplegablePacientes = managerBeanLocal.nombrePacientes();
            cargarDatosPaciente();
            resetAllValues();
        }
        cargarListaDietas();
    }

    public String agregarAlimentoDieta() {
        System.out.println("invoco agregarAlimentoDieta para dieta: " + codigoDieta + " codigo Alimento seleccionado: " + codigoAlimentoSeleccionado + " cantidad: " + cantidadNuevoAlimentoPAVB + " paciente: " + codigoPaciente);
        if (codigoAlimentoSeleccionado != 0 && cantidadNuevoAlimentoPAVB != 0 && codigoPaciente != 0) {
            System.out.println("campos registrados no son nulos agregarAlimentoDieta para dieta: " + codigoDieta + " codigo Alimento seleccionado: " + codigoAlimentoSeleccionado + " cantidad: " + cantidadNuevoAlimentoPAVB + " paciente: " + codigoPaciente);
            numeroItemDieta = managerBeanLocal.siguienteItem(codigoDieta);
            int codigoDietaAfterInsert = managerBeanLocal.agregarAlimentoDieta(codigoDieta, numeroItemDieta, codigoAlimentoSeleccionado, cantidadNuevoAlimentoPAVB, codigoPaciente);
            codigoDieta = codigoDietaAfterInsert;
            //listaDesplegableDietas = managerBeanLocal.listadoDietas();
            cargarListaDietas();
            changeListenerCodigoDieta();
        }
        return null;
    }

    private void actualizaListaAlimentos(int codigoDieta) {
        //CONSULTA LA TABLA DE DIETA Y RECUPERA LOS ITEMS PARA MOSTRAR DE ACUERDO A LA CANTIDAD
        double cantidadAlimentoDieta;

        resetAllValues();
        List<Dieta> recuperaDietasPorCodigo = managerBeanLocal.detalleDieta(codigoDieta);
        for (Dieta detalle : recuperaDietasPorCodigo) {
            cantidadAlimentoDieta = detalle.getCantidadAlimento();
            Alimentos alimento = managerBeanLocal.detalleAlimento(detalle.getCodigoAlimento().getCodigoAlimento());
            double tempMedidaCasera = (Double.valueOf(alimento.getMedidaCasera())) * cantidadAlimentoDieta;
            alimento.setMedidaCasera(String.valueOf(tempMedidaCasera));
            alimento.setMedidaReal(alimento.getMedidaReal() * cantidadAlimentoDieta);
            alimento.setHidratosCarbono(alimento.getHidratosCarbono() * cantidadAlimentoDieta);
            alimento.setProteina(alimento.getProteina() * cantidadAlimentoDieta);
            alimento.setGrasa(alimento.getGrasa() * cantidadAlimentoDieta);
            alimento.setSodio(alimento.getSodio() * cantidadAlimentoDieta);
            alimento.setPotasio(alimento.getPotasio() * cantidadAlimentoDieta);
            alimento.setFosforo(alimento.getFosforo() * cantidadAlimentoDieta);
            alimento.setCalcio(alimento.getCalcio() * cantidadAlimentoDieta);
            alimento.setHierro(alimento.getHierro() * cantidadAlimentoDieta);
            alimento.setColesterol(alimento.getColesterol() * cantidadAlimentoDieta);
            alimento.setPurinas(alimento.getPurinas() * cantidadAlimentoDieta);
            alimento.setFibra(alimento.getFibra() * cantidadAlimentoDieta);
            alimento.setAgua(alimento.getAgua() * cantidadAlimentoDieta);
            alimento.setCalorias(alimento.getCalorias() * cantidadAlimentoDieta);

            DatosDieta nuevaFilaDieta = new DatosDieta();
            nuevaFilaDieta.setDatosDieta(detalle);
            nuevaFilaDieta.setDatosAlimento(alimento);

            agregaNuevaFila(nuevaFilaDieta, alimento);

            codigoPaciente = detalle.getCodigoPaciente().getCodigoPaciente();
        }
    }

    private int calcularEdad(Date fechaNacimiento) {
        Instant instant = Instant.ofEpochMilli(fechaNacimiento.getTime());

        int edadCalculada = 0;

        LocalDate birthDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        edadCalculada = Period.between(birthDate, currentDate).getYears();
        //System.out.println("edad: " + edadCalculada);

        return edadCalculada;
    }

    public boolean cambiaColorHCmin() {
        if ((minHC > sumatoriaHidratosCarbono) && (HC != 0.0 && sumatoriaHidratosCarbono != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorHCmax() {
        if ((maxHC < sumatoriaHidratosCarbono && (HC != 0.0 && sumatoriaHidratosCarbono != 0.0))) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorHCcalculado() {
        if ((sumatoriaHidratosCarbono != 0.0) && (sumatoriaHidratosCarbono >= minHC) && (sumatoriaHidratosCarbono <= maxHC)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorProteinaMin() {
        if ((minProteina > sumatoriaProteina) && (proteina != 0.0 && sumatoriaProteina != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorProteinaMax() {
        if ((maxProteina < sumatoriaProteina) && (proteina != 0.0 && sumatoriaProteina != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorProteinaCalculado() {
        if ((sumatoriaProteina != 0.0) && (sumatoriaProteina >= minProteina) && (sumatoriaProteina <= maxProteina)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorGrasaMin() {
        if ((minGrasa > sumatoriaGrasa) && (grasa != 0.0 && sumatoriaGrasa != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorGrasaMax() {
        if ((maxGrasa < sumatoriaGrasa) && (grasa != 0.0 && sumatoriaGrasa != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorGrasaCalculado() {
        if ((sumatoriaGrasa != 0.0) && (sumatoriaGrasa >= minGrasa) && (sumatoriaGrasa <= maxGrasa)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorFibraMin() {
        if ((minFibra > sumatoriaFibra) && (fibra != 0.0 && sumatoriaFibra != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorFibraMax() {
        if ((maxFibra < sumatoriaFibra) && (fibra != 0.0 && sumatoriaFibra != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorFibraCalculado() {
        if ((sumatoriaFibra != 0.0) && (sumatoriaFibra >= minFibra) && (sumatoriaFibra <= maxFibra)) {
            return true;
        }
        return false;
    }

    public void borrarAlimentoDieta(int codigoDietaBorrar, int numeroItemDietaBorrar) {
        System.out.println("TABLAALIMENTODIETA borrarAlimentoDieta con datos, codigoDieta: " + codigoDietaBorrar + ", numeroItem: " + numeroItemDietaBorrar);
        managerBeanLocal.borrarAlimentoDieta(codigoDietaBorrar, numeroItemDietaBorrar);
        actualizaListaAlimentos(codigoDieta);
        cargarListaDietas();
    }

    public String seleccionarAlimentoDieta(DatosDieta dietaSeleccionada) {
        System.out.println("TABLAALIMENTODIETA seleccionarAlimentoDieta con datos, codigoDieta: " + dietaSeleccionada.getDatosDieta().getDietaPK().getCodigoDieta());
        modificarDieta = dietaSeleccionada;
        return null;
    }

    public String editarAlimentoDieta() {
        try {
            managerBeanLocal.actualizarDieta(modificarDieta.getDatosDieta().getDietaPK(), cantidadAlimentoModificado);
            modificarDieta = null;
            cantidadAlimentoModificado = 1;
            actualizaListaAlimentos(codigoDieta);
        } catch (Exception e) {
            System.err.println("ERROR al intentar modificar :" + e.getMessage());
        }

        return null;
    }

    private void agregaNuevaFila(DatosDieta nuevaFilaDieta, Alimentos alimento) {
        if (alimento.getTipoAlimento().getCodigoTipoAlimento() <= 5) {
            tablaAlimentos.add(nuevaFilaDieta);
            sumatoriaProteinaPAVB = sumatoriaProteinaPAVB + alimento.getProteina();
            sumatoriaHidratosCarbonoPAVB = sumatoriaHidratosCarbonoPAVB + alimento.getHidratosCarbono();
            sumatoriaGrasaPAVB = sumatoriaGrasaPAVB + alimento.getGrasa();
            sumatoriaFibraPAVB = sumatoriaFibraPAVB + alimento.getFibra();
            sumatoriaCaloriasPAVB = sumatoriaCaloriasPAVB + alimento.getCalorias();
        } else {
            tablaAlimentosNoPAVB.add(nuevaFilaDieta);
        }
        sumatoriaHidratosCarbono = sumatoriaHidratosCarbono + alimento.getHidratosCarbono();
        sumatoriaProteina = sumatoriaProteina + alimento.getProteina();
        sumatoriaGrasa = sumatoriaGrasa + alimento.getGrasa();
        sumatoriaFibra = sumatoriaFibra + alimento.getFibra();
        sumatoriaCalorias = sumatoriaCalorias + alimento.getCalorias();
        kcalHC = sumatoriaHidratosCarbono * 4;
        kcalProteina = sumatoriaProteina * 4;
        kcalGrasa = sumatoriaGrasa * 9;
        kcalFibra = kcalGrasa + kcalHC + kcalProteina;
    }

    private String calcularTipoImc(float imcParam) {
        String tipo;
        if (imcParam < 18.5) {
            tipo = "Delgadez";
        } else if ((imcParam >= 18.5) && (imcParam <= 24.9)) {
            tipo = "Normal o sano";
        } else if ((imcParam >= 25) && (imcParam <= 29.9)) {
            tipo = "Sobrepeso";
        } else if ((imcParam >= 30) && (imcParam <= 34.9)) {
            tipo = "Obesidad Grado I";
        } else if ((imcParam >= 35) && (imcParam <= 39.9)) {
            tipo = "Obesidad Grado II";
        } else if (imcParam >= 40) {
            tipo = "Obesidad morbida";
        } else {
            tipo = " ";
        }
        return tipo;

    }

    private String calcularTipoPorcentajePI(float porcentajePesoIdeal) {
        String retorno = "No calculado";
        if (porcentajePesoIdeal > 180) {
            retorno = "Obesidad morbida";
        } else if (porcentajePesoIdeal >= 140 && porcentajePesoIdeal <= 179) {
            retorno = "Obesidad II";
        } else if (porcentajePesoIdeal >= 120 && porcentajePesoIdeal <= 139) {
            retorno = "Obesidad I";
        } else if (porcentajePesoIdeal >= 110 && porcentajePesoIdeal <= 119) {
            retorno = "Sobrepeso";
        } else if (porcentajePesoIdeal >= 90 && porcentajePesoIdeal <= 109) {
            retorno = "Normal";
        } else if (porcentajePesoIdeal >= 84 && porcentajePesoIdeal <= 89) {
            retorno = "Desnutricion leve";
        } else if (porcentajePesoIdeal >= 75 && porcentajePesoIdeal <= 84) {
            retorno = "Desnutricion moderada";
        } else if (porcentajePesoIdeal < 75) {
            retorno = "Desnutricion severa";
        }
        return retorno;
    }

    private void resetAllValues() {
        sumatoriaHidratosCarbono = 0;
        sumatoriaHidratosCarbonoPAVB = 0;
        sumatoriaProteina = 0;
        sumatoriaProteinaPAVB = 0;
        sumatoriaGrasa = 0;
        sumatoriaGrasaPAVB = 0;
        sumatoriaFibra = 0;
        sumatoriaFibraPAVB = 0;
        sumatoriaCalorias = 0;
        sumatoriaCaloriasPAVB = 0;
        kcalHC = 0;
        kcalProteina = 0;
        kcalGrasa = 0;
        kcalFibra = 0;
        vaciarTablaAlimentos();
    }

    private void cargarListaDietas() {
        if (codigoPaciente == 0) {
            listaDesplegableDietas = managerBeanLocal.listadoDietas();
        } else {
            listaDesplegableDietas = managerBeanLocal.dietasPorPaciente(codigoPaciente);
        }
    }

    private void cargarDatosPaciente() {
        if (codigoPaciente != 0) {
            paciente = managerBeanLocal.detallePaciente(codigoPaciente);
            edad = calcularEdad(paciente.getFechaNacimiento());
            tipoImc = calcularTipoImc(paciente.getImc());
            tipoPorcentajePI = calcularTipoPorcentajePI(paciente.getPorcentajePesoIdeal());
        }
    }

    public String crearReporte() {
        System.out.println("entro a crearReporte");
        
        
        
        return null;

    }

    private void agregarReferenciasDieta() {
        System.out.println("entro a agregarReferenciasDieta para Dieta: " + codigoDieta + " HC: " + HC + ", proteina: " + proteina + ", grasas: " + grasa + ", fibra: " + fibra);
        managerBeanLocal.actualizarReferenciaDieta(codigoDieta, HC, proteina, grasa, fibra);
        
    }

    private void cargarDatosReferencia() {
        ReferenciaXDieta referencias = managerBeanLocal.recuperaReferencias(codigoDieta);
        if (referencias != null) {
            setHC(referencias.getHidratosCarbono());
            setProteina(referencias.getProteinas());
            setGrasa(referencias.getGrasas());
            setFibra(referencias.getFibras());
        } else {
            HC = 0.0;
            proteina = 0.0;
            grasa = 0.0;
            fibra = 0.0;
            resetReferenciasMinMax();
        }
        
    }

    private void vaciarTablaAlimentos() {
        tablaAlimentos.removeAll(tablaAlimentos);
        tablaAlimentosNoPAVB.removeAll(tablaAlimentosNoPAVB);
    }

    private void resetReferenciasMinMax() {
        minHC = 0;
        minProteina = 0;
        minGrasa = 0;
        minFibra = 0;
        maxHC = 0;
        maxProteina = 0;
        maxGrasa = 0;
        maxFibra = 0;
    }
}
