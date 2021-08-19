/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.time.LocalDate;

/**
 *
 * @author Alex
 */
public class EnsamblajeMueble {

    private String idEnsamblajeMueble;
    private LocalDate fechaEnsamblaje;
    private String ensamblador;
    private double costoEnsamblaje;
    private SalaVenta sala;
    private Mueble mueble;

    public EnsamblajeMueble(String idEnsamblajeMueble, LocalDate fechaEnsamblaje, String ensamblador, double costoEnsamblaje, SalaVenta sala, Mueble mueble) {
        this.idEnsamblajeMueble = idEnsamblajeMueble;
        this.fechaEnsamblaje = fechaEnsamblaje;
        this.ensamblador = ensamblador;
        this.costoEnsamblaje = costoEnsamblaje;
        this.sala = sala;
        this.mueble = mueble;
    }

    public String getIdEnsamblajeMueble() {
        return idEnsamblajeMueble;
    }

    public void setIdEnsamblajeMueble(String idEnsamblajeMueble) {
        this.idEnsamblajeMueble = idEnsamblajeMueble;
    }

    public LocalDate getFechaEnsamblaje() {
        return fechaEnsamblaje;
    }

    public void setFechaEnsamblaje(LocalDate fechaEnsamblaje) {
        this.fechaEnsamblaje = fechaEnsamblaje;
    }

    public String getEnsamblador() {
        return ensamblador;
    }

    public void setEnsamblador(String ensamblador) {
        this.ensamblador = ensamblador;
    }

    public double getCostoEnsamblaje() {
        return costoEnsamblaje;
    }

    public void setCostoEnsamblaje(double costoEnsamblaje) {
        this.costoEnsamblaje = costoEnsamblaje;
    }

    public SalaVenta getSala() {
        return sala;
    }

    public void setSala(SalaVenta sala) {
        this.sala = sala;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

}
