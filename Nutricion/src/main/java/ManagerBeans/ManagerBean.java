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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ManagerBean implements ManagerBeanLocal {

    @PersistenceContext(unitName = "com.mycompany_Nutricion_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<Paciente> listadoPacientes() {
        System.out.println("Ingreso al MANAGERBEAN listadoPacientes");
        List<Paciente> listado = em.createNamedQuery("Paciente.findAll", Paciente.class).getResultList();
        return listado;
    }

    @Override
    public List<Alimentos> listadoAlimentos() {
        System.out.println("Ingreso al MANAGERBEAN listadoAlimentos");
        List<Alimentos> listado = em.createNamedQuery("Alimentos.findAll", Alimentos.class).getResultList();
        return listado;
    }

    @Override
    public Alimentos detalleAlimento(int codigo) {
        System.out.println("Ingreso al MANAGERBEAN detalleAlimento");
        return em.find(Alimentos.class, codigo);
    }

    @Override
    public List<ElementoListaBasico> nombreAlimentosPAVB() {
        System.out.println("Ingreso al MANAGERBEAN nombreAlimentosPAVB");
        int codigoAlimentoRetorno;
        String descripcionAlimentoRetorno;
        List<Alimentos> alimentosNombre = em.createNamedQuery("Alimentos.findAll", Alimentos.class).getResultList();
        List<ElementoListaBasico> listadoNombreAlimento = new ArrayList<ElementoListaBasico>();
        for (int i = 0; i < alimentosNombre.size(); i++) {
            codigoAlimentoRetorno = alimentosNombre.get(i).getCodigoAlimento();
            descripcionAlimentoRetorno = alimentosNombre.get(i).getDescripcionAlimento() + " (" + alimentosNombre.get(i).getMedidaCaseraUnidad() + ")";
            listadoNombreAlimento.add(new ElementoListaBasico(codigoAlimentoRetorno, descripcionAlimentoRetorno));
        }
        return listadoNombreAlimento;
    }

    @Override
    public int agregarAlimentoDieta(int codigoDieta, int numeroItem, int codigoAlimento, int cantidad, int codigoPaciente) {
        System.out.println("Ingreso al MANAGERBEAN, agregarAlimentoDieta (Codigo Dieta: " + codigoDieta + ", Codigo Alimento: " + codigoAlimento + ", Codigo Paciente: " + codigoPaciente + ", Cantidad: " + cantidad);
        try {
            Paciente paciente = em.find(Paciente.class, codigoPaciente);
            Alimentos alimento = em.find(Alimentos.class, codigoAlimento);
            if (codigoDieta == 0) {
                //@NamedQuery(name = "Dieta.maxCodigoDieta", query = "SELECT MAX(d.dietaPK.codigoDieta) FROM Dieta d"),
                int codigoDietaTemp = Integer.valueOf(em.createNamedQuery("Dieta.maxCodigoDieta").getSingleResult().toString());
                codigoDieta = codigoDietaTemp + 1;
                numeroItem = 1;
            }
            if ((codigoDieta != 0) && (paciente != null) && (alimento != null)) {
                DietaPK dietaPK = new DietaPK();
                dietaPK.setCodigoDieta(codigoDieta);
                dietaPK.setNumeroItem(numeroItem);

                Dieta dieta = new Dieta();
                dieta.setDietaPK(dietaPK);
                dieta.setCodigoPaciente(paciente);
                dieta.setCodigoAlimento(alimento);
                dieta.setCantidadAlimento(cantidad);
                System.out.println("Ingreso al MANAGERBEAN, cargo la dieta correctamente");

                em.persist(dieta);
            } else {
                System.err.println("ERROR datos vacios");
            }

        } catch (Exception e) {
            throw new UnsupportedOperationException("No se pudo insertar Dieta.");
        }

        return codigoDieta;
    }

    @Override
    public List listadoDietas() {
        System.out.println("Ingreso al MANAGERBEAN listadoDietas");
        //@NamedQuery(name = "Dieta.findAllCodigoDieta", query = "SELECT DISTINCT(d.dietaPK.codigoDieta) FROM Dieta d ORDER BY d.dietaPK.codigoDieta"),
        List recuperaDietas = em.createNamedQuery("Dieta.findAllCodigoDieta").getResultList();
        System.out.println("manager recuepero datos: " + recuperaDietas);
        return recuperaDietas;
    }

    @Override
    public List dietasPorPaciente(int codigoPaciente) {
        System.out.println("Ingreso al MANAGERBEAN dietasPorPaciente");
        //@NamedQuery(name = "Dieta.findAllCodigoDieta", query = "SELECT DISTINCT(d.dietaPK.codigoDieta) FROM Dieta d ORDER BY d.dietaPK.codigoDieta"),
        List recuperaDietas = em.createNamedQuery("Dieta.findAllByCodigoPaciente").setParameter("codigoPaciente", codigoPaciente).getResultList();
        System.out.println("manager recupero datos: " + recuperaDietas);
        return recuperaDietas;
    }

    @Override
    public List<Dieta> detalleDieta(int codigoDieta) {
        List<Dieta> listadoDietas = em.createNamedQuery("Dieta.findByCodigoDieta", Dieta.class).setParameter("codigoDieta", codigoDieta).getResultList();
        return listadoDietas;
    }

    @Override
    public void borrarAlimentoDieta(int codigoDieta, int numeroItem) {
        System.out.println("Ingreso al MANAGERBEAN borrarAlimentoDieta(), con los datos: " + codigoDieta + ", numeroItem: " + numeroItem);
        DietaPK dietaPK = new DietaPK(codigoDieta, numeroItem);
        Dieta dieta = em.find(Dieta.class, dietaPK);
        if (dieta != null) {
            System.out.println("Ingreso al MANAGERBEAN recuperoDieta: " + dieta.getDietaPK().getCodigoDieta());
            em.remove(dieta);
        }
    }

    @Override
    public void actualizarDieta(DietaPK dietaModificar, double nuevaCantidad) {
        Dieta dieta = em.find(Dieta.class, dietaModificar);
        if (dieta != null) {
            dieta.setCantidadAlimento(nuevaCantidad);
            em.persist(dieta);

        }
    }

    @Override
    public List<ElementoListaBasico> nombrePacientes() {
        List<Paciente> pacientes = em.createNamedQuery("Paciente.findAll", Paciente.class).getResultList();
        String nombreApellido;
        int codigoPaciente;
        List<ElementoListaBasico> retornoPaciente = new ArrayList<ElementoListaBasico>();
        if (pacientes != null) {
            for (int i = 0; i < pacientes.size(); i++) {
                nombreApellido = pacientes.get(i).getNombre() + " " + pacientes.get(i).getApellido();
                codigoPaciente = pacientes.get(i).getCodigoPaciente();
                retornoPaciente.add(new ElementoListaBasico(codigoPaciente, nombreApellido));
            }
        }
        return retornoPaciente;
    }

    @Override
    public Paciente detallePaciente(int codigoPaciente) {
        return em.find(Paciente.class, codigoPaciente);
    }

    @Override
    public void registrarPaciente(Paciente nuevo) {
        if (nuevo != null) {
            try {
                //@NamedQuery(name = "Paciente.getMaxCodigoPaciente", query = "SELECT MAX(p.codigoPaciente) FROM Paciente p"),
                int codigoPaciente = Integer.valueOf(em.createNamedQuery("Paciente.getMaxCodigoPaciente").getSingleResult().toString());
                nuevo.setCodigoPaciente(codigoPaciente + 1);
                em.persist(nuevo);
            } catch (Exception e) {
                System.err.println("ERROR al registrar paciente: " + e.getMessage());
            }
        }

    }

    @Override
    public int siguienteItem(int codigoDieta) {
        int numeroItemActual = Integer.valueOf(em.createNamedQuery("Dieta.findByCodigoDietaMaxItem").setParameter("codigoDieta", codigoDieta).getSingleResult().toString());
        return numeroItemActual + 1;
    }

    @Override
    public double calcularPI(int edad, String sexo, int talla, String biotipo) {
        double peso = 0;

        if (isBetween(edad, 0, 19)) {
            System.out.println("testing case 17 to 19");
            peso = Double.valueOf(em.createNamedQuery("PesoIdeal.findByTallaInicial").setParameter("tallaCm", talla).setParameter("sexo", sexo).getSingleResult().toString());
            System.out.println("Recupero peso ideal de: " + peso);
        } else if (isBetween(edad, 20, 24)) {
            System.out.println("testing case 20 to 24");
            peso = Double.valueOf(em.createNamedQuery("PesoIdeal.findByTalla24").setParameter("tallaCm", talla).setParameter("sexo", sexo).getSingleResult().toString());
            System.out.println("Recupero peso ideal de: " + peso);
        } else if ((edad >= 25) && (biotipo.equals("Pequeña"))) {
            System.out.println("testing case Pequeña");
            peso = Double.valueOf(em.createNamedQuery("PesoIdeal.findByTallaPequena").setParameter("tallaCm", talla).setParameter("sexo", sexo).getSingleResult().toString());
            System.out.println("Recupero peso ideal de: " + peso);
        } else if ((edad >= 25) && (biotipo.equals("Mediana"))) {
            System.out.println("testing case Mediana");
            peso = Double.valueOf(em.createNamedQuery("PesoIdeal.findByTallaMediana").setParameter("tallaCm", talla).setParameter("sexo", sexo).getSingleResult().toString());
            System.out.println("Recupero peso ideal de: " + peso);
        } else if ((edad >= 25) && (biotipo.equals("Grande"))) {
            System.out.println("testing case Grande");
            peso = Double.valueOf(em.createNamedQuery("PesoIdeal.findByTallaGrande").setParameter("tallaCm", talla).setParameter("sexo", sexo).getSingleResult().toString());
            System.out.println("Recupero peso ideal de: " + peso);
        }

        return peso;
    }

    //metodo para registrar las modificaciones de hc, proteinas, fibras, grasas
    private static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    @Override
    public void actualizarReferenciaDieta(int codigoDieta, double hc, double proteina, double grasa, double fibra) {
        System.out.println("Ingreso al MANAGERBEAN, actualizarReferenciaDieta (Codigo Dieta: " + codigoDieta + ", HC: " + hc + ", proteina: " + proteina + ", grasa: " + grasa + ", fibra: " + fibra);
        ReferenciaXDieta ref;
        int codigoDietaTemp = 0;

        try { 
            ref = em.createNamedQuery("ReferenciaXDieta.findByCodigoDieta", ReferenciaXDieta.class).setParameter("codigoDieta", codigoDieta).getSingleResult();
            System.out.println("tras ejecucion del query" + ref.getClass().toString());
            
            ref.setHidratosCarbono(hc);
            ref.setProteinas(proteina);
            ref.setGrasas(grasa);
            ref.setFibras(fibra);
            em.persist(ref);
        } catch(Exception e) {
            codigoDietaTemp = Integer.valueOf(em.createNamedQuery("ReferenciaXDieta.maxRefencia").getSingleResult().toString());
            codigoDietaTemp++;
            ref = new ReferenciaXDieta();
            ref.setCodigoReferenciaXDieta(codigoDietaTemp);
            ref.setCodigoDieta(codigoDieta);
            ref.setHidratosCarbono(hc);
            ref.setProteinas(proteina);
            ref.setGrasas(grasa);
            ref.setFibras(fibra);
            em.persist(ref);
        }

    }

    @Override
    public ReferenciaXDieta recuperaReferencias(int codigoDieta) {
        ReferenciaXDieta ref;
        try { 
            ref = em.createNamedQuery("ReferenciaXDieta.findByCodigoDieta", ReferenciaXDieta.class).setParameter("codigoDieta", codigoDieta).getSingleResult();
            System.out.println("tras ejecucion del query" + ref.getClass().toString());
        } catch (Exception e) {
            return null;
        }
        return ref;
    }

}
