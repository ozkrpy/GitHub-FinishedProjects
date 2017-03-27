/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "contexturaBean")
@RequestScoped
public class ContexturaBean {

    private int edad;
    private char sexo;
    private double talla;
    private double ciaMuneca;
    private String resultado;
    
    public ContexturaBean() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getCiaMuneca() {
        return ciaMuneca;
    }

    public void setCiaMuneca(double ciaMuneca) {
        this.ciaMuneca = ciaMuneca;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void calcularBiotipo() {
        String contextura = "no calculada (menor a 25 años).";
        System.out.println("datos entrada - edad: " + edad + " talla: " + talla + " cia. munheca: " + ciaMuneca + " sexo: " + sexo);
        if (edad >= 25) {
            System.out.println("entro al if de mayor a 25");
            double biotipo;
            biotipo = (talla / ciaMuneca);
            /*H: Hombre M: Mujer*/
            switch (sexo) {
                case 'H':
                    contextura = calculoContexturaHombre(biotipo);
                    break;
                case 'M':
                    contextura = calculoContexturaMujer(biotipo);
                    break;
                default:
                    contextura = "no calculada sexo(" + sexo + ") ingresado no es valido";
                    break;
            }
        }
        String retorno = "Contextura " + contextura;
        setResultado(retorno);
        System.out.println(retorno);
    }

    private String calculoContexturaHombre(double biotipo) {
        String contexturaCalculada = null;
        System.out.println("entro al if de Masculino");
        if (biotipo>0) {
            if (biotipo > 10.4) {
                contexturaCalculada = "Pequeña (Mayor a 10.4)";
            } else if (biotipo > 9.6 && biotipo <= 10.4) {
                contexturaCalculada = "Mediana (Entre 9.6 y 10.4)";
            } else if (biotipo < 9.6) {
                contexturaCalculada = "Grande (Menor a 9.6)";
            } 
        } else {
            contexturaCalculada = " no calculada, talla / circunferencia de muñeca son iguales a cero.-";
        }
        return contexturaCalculada;
    }

    private String calculoContexturaMujer(double biotipo) {
        String contexturaCalculada = null;
        System.out.println("entro al if de Femenino");
        if (biotipo>0) {    
            if (biotipo > 11) {
                contexturaCalculada = "Pequeña (Mayor a 11)";
            } else if (biotipo >= 10.1 && biotipo <= 11) {
                contexturaCalculada = "Mediana (Entre 10.1 y 11)";
            } else if (biotipo < 10.1) {
                contexturaCalculada = "Grande (Menor a 10.1)";
            }
        } else {
            contexturaCalculada = " no calculada, talla / circunferencia de muñeca son iguales a cero.-";
        }
        return contexturaCalculada;
    }
}
