/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author ozkrp
 */
public class ElementoListaBasico implements Serializable {
    
    private int codigoAlimento;
    private String descripcionAlimento;

    public ElementoListaBasico() {
    }

    public ElementoListaBasico(int codigoAlimento, String descripcionAlimento) {
        this.codigoAlimento = codigoAlimento;
        this.descripcionAlimento = descripcionAlimento;
    }

    public int getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(int codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public String getDescripcionAlimento() {
        return descripcionAlimento;
    }

    public void setDescripcionAlimento(String descripcionAlimento) {
        this.descripcionAlimento = descripcionAlimento;
    }
    
}
