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
public class Tipo {

    private String idTipoPieza;
    private String nombre;

    public Tipo(String idTipoPieza, String nombre) {
        this.idTipoPieza = idTipoPieza;
        this.nombre = nombre;
    }

    public String getIdTipoPieza() {
        return idTipoPieza;
    }

    public void setIdTipoPieza(String idTipoPieza) {
        this.idTipoPieza = idTipoPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
