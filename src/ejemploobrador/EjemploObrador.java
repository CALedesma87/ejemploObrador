
package ejemploobrador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class EjemploObrador {

  
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            //Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");
            
            //Conexion a la base de dato
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/obrador", "root", "");
        
        
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el Driver "+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de Datos "+ex.getMessage());
        }
    }
    
}
