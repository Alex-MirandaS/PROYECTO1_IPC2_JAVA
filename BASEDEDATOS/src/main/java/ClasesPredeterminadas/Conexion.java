
package ClasesPredeterminadas;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Conexion {

    Connection Conexion = null;
    public Conexion(){
        
    }
    public int conectar() {
        try{

            if (Conexion != null) {
                JOptionPane.showMessageDialog(null, "La conexión previa con la base de datos sigue vigente");
            }

            String url = "jdbc:mysql://localhost:3306/MI_MUEBLERIA";
            String user = "root";
            String password = "ipc2alex";
            Conexion = DriverManager.getConnection(url, user, password);
            
            
            /*Conecction conecction = null;
            conection = DriverManager.getConecction(URL_MYSQL, USER, PASSWORD);
            Statement insert = connection.createStatement();
            insert.executeUpdate("INSERT INTO estudiante VALUES("CARNET""NOMBRE""APELLIDO""FECHANACIMINETO)")
            
            Statement delete = connection.createStetement();
            delete.executeUpdate("DELETE FROM estudiante WHERE nombre = nombre")
            
            LO MISMO SE HACE PARA EL UPDATE
            
            //Para traer datos de una tabla
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM estudiante") 
            
            while(result.next()){
            System.out.println(result.getString("carnet"));
            System.out.println(result.getString("nombre"));
            System.out.println(result.getString("apellidos"));
            System.out.println(result.getDate("fecha_nacimiento"))
            }
            
            //Si no se quiere una inyeccion de SQL 
            
            PreparedStatement query = conecction.prepareStatement("SELECT * FROM estudiante WHERE apellidos like ?")
            query.setString(0,apellido);
            ResultSet result = query.executeQuery();
            
                        while(result.next()){
            System.out.println(result.getString("carnet"));
            System.out.println(result.getString("nombre"));
            System.out.println(result.getString("apellidos"));
            System.out.println(result.getDate("fecha_nacimiento"))
            }
            
            
          //Si queremos que aun no se guarden cambion:
            connection.setAutocommit(false);
            connection.commit();
            //Si falla algo y queremos que regrese a la normalidad
            connection.rollback();
            
            
            //EJEMPLO
            
            connection.setautoCommit(false);
            try{
            Statement insert = connection.createStatement();
            insert.executeUpdate("UPDATE estudiante SET nombre = cambio WHERE carnet = 123");
            
            INSERT.EXECUTEupdate("UPDATE curso SET nombre = cambio2 WHERE codigo = 001");
            conection.commit();
            catch(SQLException e){
            conecction.rolback()
            }finally 
            
            connection.setAutoCommit(false);
            }
            */
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Conexion Fallida");
            return 2;
        }
        return 0;
    }
    
    public int desconectar(){
        Conexion = null;
        if (Conexion!=null) {
            JOptionPane.showMessageDialog(null, "Error al desconectar de base de datos, sigue conectado");
            return 1;
        }
        return 0;
    }
    
    public Connection getConnection(){
        return Conexion;
    }
}
