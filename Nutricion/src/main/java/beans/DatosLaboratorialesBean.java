/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "datosLaboratorialesBean")
@ApplicationScoped
public class DatosLaboratorialesBean {

    /* FONT */
    private final String COLOR_FUENTE_ROJO = "#D20005";
    private final String COLOR_FUENTE_VERDE = "#009900";
    private final String COLOR_FUENTE_NARANJA = "#ffe8b9";

    /* BACKGROUND */
    private final String COLOR_FONDO_ROJO = "#ffcccc";
    private final String COLOR_FONDO_VERDE = "#ccffcc";
    private final String COLOR_FONDO_NARANJA = "#ff9900";

    private final String RETORNO_OK = "color: " + COLOR_FUENTE_VERDE + "; background: " + COLOR_FONDO_VERDE;
    private final String RETORNO_ABOVE = "color: " + COLOR_FUENTE_ROJO + "; background: " + COLOR_FONDO_ROJO;
    private final String RETORNO_BELOW = "color: " + COLOR_FUENTE_NARANJA + "; background: " + COLOR_FONDO_NARANJA;

    public DatosLaboratorialesBean() {
    }

    public String laboratorioProteinuria(float param) {
        double MIN = 0.8;
        double MAX = 1.2;
        /*DEFINIR PARAMETROS POR EL MOMENTO RETORNA NULL*/
        return null;
    }

    public String laboratorioHdl(float param) {
        double MIN = 40;
        double MAX = 200;
        /* REVISAR */
        return calcular(param, MIN, MAX);
    }

    public String laboratorioPotasio(float param) {
        double MIN = 40;
        double MAX = 80;
        /* DEFINIDO EN LOS 2 DOCUMENTOS*/
        return calcular(param, MIN, MAX);
    }

    public String laboratorioGlobulosBlancos(float param) {
        double MIN = 0.8;
        double MAX = 1.2;
        /*DEFINIR*/
        return calcular(param, MIN, MAX);
    }

    public String laboratorioHba(float param) {
        double MIN = 0.8;
        double MAX = 1.2;
        /*DEFINIR*/
        return calcular(param, MIN, MAX);
    }

    public String laboratorioGlicemiaBasal(float param) {
        double MIN = 70;
        double MAX = 110;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioCreatinina(float param) {
        double MIN = 0.8;
        double MAX = 1.2;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioProteinasTotales(float param) {
        double MIN = 6;
        double MAX = 8.30;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioUrea(float param) {
        double MIN = 10;
        double MAX = 50;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioAcidoUrico(float param, String sexo) {
        double MAX_MUJER = 6;
        double MAX_HOMBRE = 7;
        System.out.println("Parametro entrada: " + param + ", sexo: " + sexo);
        if (sexo.equals("M")) {
            if (param > 0 && param <= MAX_HOMBRE) {
                return RETORNO_OK;
            } else {
                return null;
            }
        } else if (sexo.equals("F")) {
            if (param > 0 && param <= MAX_MUJER) {
                return RETORNO_OK;
            } else {
                return null;
            }
        }

        return null;
    }

    public String laboratorioAlbumina(float param) {
        double MIN = 3.5;
        double MAX = 5.5;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioTriglicerios(float param) {
        double MIN = 1;
        double MAX = 159;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioColesterolTotal(float param) {
        double MIN = 1;
        double MAX = 199;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioLdl(float param) {
        double MIN = 1;
        double MAX = 130;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioGlucosa(float param) {
        double MIN = 125;
        double MAX = 135;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioHb(float param, String sexo) {
        double MIN_HOMBRE = 14;
        double MAX_HOMBRE = 16;
        double MIN_MUJER = 12;
        double MAX_MUJER = 14;

        if (sexo.equals("M")) {
            return calcular(param, MIN_HOMBRE, MAX_HOMBRE);
        } else if (sexo.equals("F")) {
            return calcular(param, MIN_MUJER, MAX_MUJER);
        }
        return null;
    }

    public String laboratorioHematocrito(float param, String sexo) {
        double MIN_HOMBRE = 40;
        double MAX_HOMBRE = 52;
        double MIN_MUJER = 37;
        double MAX_MUJER = 47;

        if (sexo.equals("M")) {
            return calcular(param, MIN_HOMBRE, MAX_HOMBRE);
        } else if (sexo.equals("F")) {
            return calcular(param, MIN_MUJER, MAX_MUJER);
        }
        return null;
    }

    public String laboratorioGlobulosRojos(float param, String sexo) {
        double MIN_HOMBRE = 4.6;
        double MAX_HOMBRE = 6.1;
        double MIN_MUJER = 4.1;
        double MAX_MUJER = 5.4;

        if (sexo.equals("M")) {
            return calcular(param, MIN_HOMBRE, MAX_HOMBRE);
        } else if (sexo.equals("F")) {
            return calcular(param, MIN_MUJER, MAX_MUJER);
        }
        return null;
    }

    public String laboratorioCi(float param) {
        double MIN = 97;
        double MAX = 107;

        return calcular(param, MIN, MAX);
    }

    public String laboratorioNa(float param) {
        double MIN = 135;
        double MAX = 145;

        return calcular(param, MIN, MAX);
    }

    private String calcular(float param, double min, double max) {

        if (param > 0 && param < min) {
            return RETORNO_BELOW;
        } else if (param >= min && param <= max) {
            return RETORNO_OK;
        } else if (param > max) {
            return RETORNO_ABOVE;
        }
        return null;
    }
}
