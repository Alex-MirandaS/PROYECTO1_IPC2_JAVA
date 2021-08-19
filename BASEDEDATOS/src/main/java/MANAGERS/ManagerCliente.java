/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MANAGERS;

import CLASES.Cliente;
import com.mysql.cj.xdevapi.PreparableStatement;
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
public class ManagerCliente {

    private Cliente cliente;
    private Connection conexion;
    // QUERYS   
    private String insertarCliente = "INSERT INTO Cliente VALUES(?,?,?)";
    private String borrarCliente = "DELETE FROM Cliente WHERE NIT = ?";
    private String seleccionarTodo = "SELECT * FROM Cliente";
    //UPDATE
    //INSERT
    //DELETE
    //SELECT

    public ManagerCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void insertarCliente(int nit, String nombre, String direccion) {

        try {
            PreparedStatement ps = conexion.prepareStatement(insertarCliente);
            ps.setInt(1, nit);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Cliente> seleccionarTodo() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(insertarCliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nit = rs.getString("NIT");
                String nombre = rs.getString("Nombre_Cliente");
                String direccion = rs.getString("Direccion");
                Cliente cliente = new Cliente(nit, nombre, direccion);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

}
