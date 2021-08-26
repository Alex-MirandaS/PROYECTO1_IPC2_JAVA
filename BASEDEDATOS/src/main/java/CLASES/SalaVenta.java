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
public class SalaVenta {

    private int idSalaVenta;
    private String tipoMueble;
    private double precioMueble;
    private int existencias;

    public SalaVenta(int idSalaVenta, String tipoMueble, double precioMueble, int existencias) {
        this.idSalaVenta = idSalaVenta;
        this.tipoMueble = tipoMueble;
        this.precioMueble = precioMueble;
        this.existencias = existencias;
    }

    public int getIdSalaVenta() {
        return idSalaVenta;
    }

    public void setIdSalaVenta(int idSalaVenta) {
        this.idSalaVenta = idSalaVenta;
    }

    public String getTipoMueble() {
        return tipoMueble;
    }

    public void setTipoMueble(String tipoMueble) {
        this.tipoMueble = tipoMueble;
    }

    public double getPrecioMueble() {
        return precioMueble;
    }

    public void setPrecioMueble(double precioMueble) {
        this.precioMueble = precioMueble;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

}
