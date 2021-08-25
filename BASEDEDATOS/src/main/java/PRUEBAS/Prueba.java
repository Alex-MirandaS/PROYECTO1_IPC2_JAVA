/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRUEBAS;

import Enums.ClienteEnum;
import MANAGERS.ManagerCliente;
import MANAGERS.ManagerPieza;
import MANAGERS.ManagerTipoPieza;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Prueba {

    ManagerCliente manager = new ManagerCliente();
    ManagerPieza pieza = new ManagerPieza();
    ManagerTipoPieza tipoPieza = new ManagerTipoPieza();
    Scanner sc = new Scanner(System.in);

    public Prueba() {
       datosCliente();
        
    }

    public void inicio() {
        insertarCliente();
        datosCliente();
    }

    public void insertarCliente() {

        System.out.println("Inserte su nuevo Cliente");
        System.out.println("Ingrese su NIT");
        int nit = sc.nextInt();
        System.out.println("Ingrese su Nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su Direccion");
        String direccion = sc.next();

        manager.insertarCliente(nit, nombre, direccion);
        ImprimirClientes();
    }

    public void borrarCliente() {

        ImprimirClientes();
        System.out.println("Borrar Cliente");
        System.out.println("Ingrese su NIT");
        int nit = sc.nextInt();
        manager.borrarCliente(nit);
        ImprimirClientes();
    }

    public void editarCliente() {

        ImprimirClientes();
        System.out.println("Editar Cliente");
        System.out.println("Ingrese su NIT");
        int nit = sc.nextInt();
        System.out.println("Ingrese lo que desea editar");
        System.out.println("1. NIT");
        System.out.println("2. NOMBRE");
        System.out.println("3. Direccion");
        int eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                System.out.println("Ingrese lo que desea cambiar");
                int datoCambiado = sc.nextInt();
                manager.updateCliente(nit, "" + datoCambiado, ClienteEnum.NIT);
                break;
            case 2:
                System.out.println("Ingrese lo que desea cambiar");
                String datoCambiado1 = sc.next();
                manager.updateCliente(nit, datoCambiado1, ClienteEnum.Nombre_Cliente);
                break;
            case 3:
                System.out.println("Ingrese lo que desea cambiar");
                String datoCambiado2 = sc.next();
                manager.updateCliente(nit, datoCambiado2, ClienteEnum.Direccion);
                break;
        }
        ImprimirClientes();
    }

    public void datosCliente() {
      //  ImprimirClientes();
        System.out.println("Inserte su nuevo Cliente");
        System.out.println("Ingrese su ID");
        int nit = sc.nextInt();


            System.out.println("");
            System.out.println("NIT");
            System.out.println(pieza.seleccionarPieza(nit).getTipo().getNombre());
            System.out.println("Nombre");
            System.out.println(pieza.seleccionarPieza(nit).getCantidad());
            System.out.println("Dirección");
            System.out.println(pieza.seleccionarPieza(nit).getCostoUnitario());

        
    }

    public void ImprimirClientes() {
        for (int i = 0; i < manager.seleccionarTodo().size(); i++) {
            System.out.println("");
            System.out.println("NIT");
            System.out.println(manager.seleccionarTodo().get(i).getNIT());
            System.out.println("Nombre");
            System.out.println(manager.seleccionarTodo().get(i).getNombre());
            System.out.println("Dirección");
            System.out.println(manager.seleccionarTodo().get(i).getDireccion());

        }
    }
}
