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
public class Mueble {

    private String idMueble;
    private double precioVenta;
    private String nombreMueble;

    public Mueble(String idMueble, double precioVenta, String nombreMueble) {
        this.idMueble = idMueble;
        this.precioVenta = precioVenta;
        this.nombreMueble = nombreMueble;
    }

    public String getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(String idMueble) {
        this.idMueble = idMueble;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }
    
    
    
}
