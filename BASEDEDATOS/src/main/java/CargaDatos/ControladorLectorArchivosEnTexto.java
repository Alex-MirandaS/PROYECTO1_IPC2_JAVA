/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;

import CLASES.Cliente;
import CLASES.Mueble;
import CLASES.Pieza;
import CLASES.Tipo;
import CLASES.Usuario;
import Enums.CargaDatosEnum;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class ControladorLectorArchivosEnTexto {

    private ArrayList<Tipo> tiposPiezasTemp = new ArrayList<>();

    public boolean verificarDatosUsuario(String[] campos, ArrayList<Usuario> usuarios) {
        try {
            if (campos.length > 3 || campos.length < 1) {
                return false;
            } else {
                String nombreUsuario = campos[0];
                String contraseña = campos[1];
                int tipo = Integer.parseInt(campos[3]);
                String[] lista = new String[usuarios.size()];

                for (int i = 0; i < usuarios.size(); i++) {
                    lista[i] = usuarios.get(i).getNombreUsuario();
                }

                if (!datoRepetido(nombreUsuario, lista)
                        && contraseña.length() > 6
                        && tipo > 0 && tipo < 4) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
//EL FORMATO DEL TIPO DE USUARIO NO ES VALIDO
        }
        return false;
    }

    public boolean verificarDatosPieza(String[] campos, ArrayList<Tipo> tiposPieza) {
        try {
            if (campos.length > 2 || campos.length < 1) {
                return false;
            } else {
                String nombrePieza = campos[0];
                double costo = Double.parseDouble(campos[1]);
                tiposPiezasTemp = tiposPieza;
                String[] lista = new String[tiposPieza.size()];

                for (int i = 0; i < tiposPieza.size(); i++) {
                    lista[i] = tiposPieza.get(i).getNombre();
                }

                if (!datoRepetido(nombrePieza, lista)) {
                    tiposPieza.add(new Tipo(tiposPieza.size() + 1, nombrePieza));
                } else {
                    for (int i = 0; i < lista.length; i++) {
                        if (nombrePieza.equalsIgnoreCase(lista[i])) {
                            tiposPieza.get(i).agregarCantidad(1);
                        }
                    }
                }
                return true;
            }
        } catch (NumberFormatException e) {
//EL FORMATO DEL TIPO DE USUARIO NO ES VALIDO
        } catch (NullPointerException e) {
            //NO HA INGRESADO NINGUN DATO
        }
        return false;
    }

    public boolean verificarDatosMueble(String[] campos, ArrayList<Mueble> muebles) {
        try {
            if (campos.length > 2 || campos.length < 1) {
                return false;
            } else {
                String nombreMueble = campos[0];
                Double precio = Double.parseDouble(campos[1]);
                String[] lista = new String[muebles.size()];

                for (int i = 0; i < muebles.size(); i++) {
                    lista[i] = muebles.get(i).getNombreMueble();
                }

                if (!datoRepetido(nombreMueble, lista)) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
//EL FORMATO DEL TIPO DE USUARIO NO ES VALIDO
        } catch (NullPointerException e) {
            //NO HA INGRESADO NINGUN DATO
        }
        return false;
    }

    public boolean verificarDatosCliente(String[] campos, ArrayList<Cliente> clientes) {
        try {
            if (campos.length > 5 || campos.length < 1) {
                return false;
            } else {
                String nombre = campos[0];
                String NIT = campos[1];
                String direccion = campos[2];

                String[] lista = new String[clientes.size()];

                for (int i = 0; i < clientes.size(); i++) {
                    lista[i] = clientes.get(i).getNIT();
                }

                if (!incluyeDato(NIT, '-') && !datoRepetido(NIT, lista)) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
//EL FORMATO DEL TIPO DE USUARIO NO ES VALIDO
        }
        return false;
    }

    public Object crearObjeto(String[] campos, CargaDatosEnum dato) {
        switch (dato) {
            case USUARIO:
                return new Usuario(campos[1], campos[0], Integer.parseInt(campos[2]));
            case PIEZA:
                return new Pieza(Double.parseDouble(campos[1]), 0, obtenerTipoPieza(campos[0]));
            case MUEBLE:
                return new Mueble(0, Double.parseDouble(campos[1]), campos[0]);
            case CLIENTE:
                if (campos.length > 3) {
                    return new Cliente(campos[0], campos[1], campos[2], campos[3], campos[4]);
                } else {
                    return new Cliente(campos[0], campos[1], campos[2]);
                }
                default:
                    return null;
        }
    }

    private boolean datoRepetido(String dato, String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (dato.equalsIgnoreCase(lista[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean incluyeDato(String linea, char valor) {
        char[] lineaChar = linea.toCharArray();

        for (int i = 0; i < lineaChar.length; i++) {
            if (lineaChar[i] == valor) {
                return true;
            }
        }
        return false;
    }

    private Tipo obtenerTipoPieza(String dato) {
        for (int i = 0; i < tiposPiezasTemp.size(); i++) {
            if (dato.equalsIgnoreCase(tiposPiezasTemp.get(i).getNombre())) {
                return tiposPiezasTemp.get(i);
            }
        }
        return null;
    }

    /*
    
    public void cargarObjetoBaseDatos() {
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(fileChosser);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();
            try {             
                switch(datos){
                    case USUARIO:
                        
                }
                
            
                if (text.equalsIgnoreCase("Vuelo")) {
                    ArrayList<Vuelo> objetos;
                    objetos = prin.getLectorVuelosTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorVuelos().guardarObjeto(objetos.get(i), objetos.get(i).getCodigoVuelo());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Aeropuerto")) {
                    ArrayList<Aereopuerto> objetos;
                    objetos = prin.getLectorAereopuertosTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorAereopuertos().guardarObjeto(objetos.get(i), objetos.get(i).getNombre());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Aereolínea")) {
                    ArrayList<Aereolínea> objetos;
                    objetos = prin.getLectorAereolineasTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorAereolineas().guardarObjeto(objetos.get(i), objetos.get(i).toString());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Avion")) {
                    ArrayList<Avión> objetos;
                    objetos = prin.getLectorAvionesTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorAviones().guardarObjeto(objetos.get(i), objetos.get(i).getCodigoAvión());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Pasaporte")) {
                    ArrayList<Pasaporte> objetos;
                    objetos = prin.getLectorPasaportesTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorPasaportes().guardarObjeto(objetos.get(i), "" + objetos.get(i).getNumPasaporte());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Tarjeta")) {
                    ArrayList<Tarjeta> objetos;
                    objetos = prin.getLectorTarjetasTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorTarjetas().guardarObjeto(objetos.get(i), "" + objetos.get(i).getNumTarjeta());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Reservación")) {
                    ArrayList<Reservación> objetos;
                    objetos = prin.getLectorReservaciónTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorReservación().guardarObjeto(objetos.get(i), objetos.get(i).toString());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else if (text.equalsIgnoreCase("Distancia")) {
                    ArrayList<Distancia> objetos;
                    objetos = prin.getLectorDistanciaTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorDistancia().guardarObjeto(objetos.get(i), objetos.get(i).toString());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                } else {
                    ArrayList<RenovaciónPasaporte> objetos;
                    objetos = prin.getLectorRenovaciónPasaporteTexto().leerFichero(fichero, text);
                    for (int i = 0; i < objetos.size(); i++) {
                        prin.getEscritorRenovaciónPasaporte().guardarObjeto(objetos.get(i), objetos.get(i).toString());
                    }
                    JOptionPane.showMessageDialog(null, "OBJETOS ENCONTRADOS Y CARGADOS");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
                ex.printStackTrace();
            }
        }
     */
}
