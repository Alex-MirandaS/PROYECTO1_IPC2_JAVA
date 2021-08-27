/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Alex
 */
public enum CargaDatosEnum {
    USUARIO(8),
    PIEZA(6),
    MUEBLE(7),
    ENSAMBLAJE_PIEZA(17),
    ENSAMBLAR_MUEBLE(17),
    CLIENTE(8);

    int caracteres;

    private CargaDatosEnum(int caracteres) {
        this.caracteres = caracteres;
    }

    public int getCaracteres() {
        return caracteres;
    }

}
