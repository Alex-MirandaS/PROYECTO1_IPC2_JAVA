/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLASES;

/**
 * 
 * @author Alex
 */
public class EnsamblajePieza {

    private String idEnsamblajePiezas;
    private int cantidad;
    private Pieza pieza;
    private Mueble mueble;

    public EnsamblajePieza(String idEnsamblajePiezas, int cantidad, Pieza pieza, Mueble mueble) {
        this.idEnsamblajePiezas = idEnsamblajePiezas;
        this.cantidad = cantidad;
        this.pieza = pieza;
        this.mueble = mueble;
    }

    public String getIdEnsamblajePiezas() {
        return idEnsamblajePiezas;
    }

    public void setIdEnsamblajePiezas(String idEnsamblajePiezas) {
        this.idEnsamblajePiezas = idEnsamblajePiezas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }
    
    
}
