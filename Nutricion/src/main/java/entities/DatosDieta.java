/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

public class DatosDieta implements Serializable{

    private Dieta datosDieta;
    private Alimentos datosAlimento;

    public DatosDieta() {
    }

    public Dieta getDatosDieta() {
        return datosDieta;
    }

    public void setDatosDieta(Dieta datosDieta) {
        this.datosDieta = datosDieta;
    }

    public Alimentos getDatosAlimento() {
        return datosAlimento;
    }

    public void setDatosAlimento(Alimentos datosAlimento) {
        this.datosAlimento = datosAlimento;
    }

}
