/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MANAGERS;

import CLASES.Tipo;
import ClasesPredeterminadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class ManagerTipoPieza {

    private Connection conexion;
    // QUERYS   
    private String insertarTipoPieza = "INSERT INTO Tipo (Nombre) VALUES(?)";
    private String borrarTipoPieza = "DELETE FROM Tipo WHERE Id_Tipo_Pieza = ?";
    private String seleccionarTipoPieza = "SELECT * FROM Tipo WHERE Id_Tipo_Pieza = ?";
    private String seleccionarTodo = "SELECT * FROM Tipo";
    private String updateNombre = "UPDATE Cliente SET Nombre = ? WHERE Id_Tipo_Pieza = ?";

    //C
    public ManagerTipoPieza() {
        this.conexion = Conexion.getConnection();
    }

    public void insertarTipoPieza(String nombre) {

        try {
            PreparedStatement ps = conexion.prepareStatement(insertarTipoPieza);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarTipoPieza(int id_Tipo_Pieza) {

        try {
            PreparedStatement ps = conexion.prepareStatement(borrarTipoPieza);
            ps.setInt(1, id_Tipo_Pieza);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTipoPieza(String datoCambiado) {

        try {
            PreparedStatement ps = conexion.prepareStatement(updateNombre);
            ps.setString(1, datoCambiado);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Tipo> seleccionarTodo() {
        ArrayList<Tipo> piezas = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(seleccionarTodo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_Tipo_Pieza = rs.getInt("Id_Tipo_Pieza");
                String nombre = rs.getString("Nombre_Cliente");

                Tipo tipo = new Tipo(id_Tipo_Pieza, nombre);
                piezas.add(tipo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    public Tipo seleccionarTipoPieza(int id_Tipo_Pieza) {
        Tipo pieza = null;
        try {

            PreparedStatement ps = conexion.prepareStatement(seleccionarTipoPieza);
            ps.setInt(1, id_Tipo_Pieza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Id_Tipo_Pieza");
                pieza = new Tipo(id_Tipo_Pieza, nombre);
                break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pieza;
    }

}
