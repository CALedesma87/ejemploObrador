
package ejemploobrador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        
           /* //Agregar empleado.
            String sql = "INSERT INTO empleado (dni, apellido, nombre, acceso,estado) "
                    + "VALUES(45325458, 'Rodriguez', 'Esteban', 3, true) ";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int registro = ps.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Se ah agregado 1 empleado " +registro);
            
           
           //Agregar herramienta
           String sql = "INSERT INTO herramienta (nombre, descripcion,stock, estado) "
                    + "VALUES('pala', 'Pala ancha', 3, true) ";
            PreparedStatement inserther = conexion.prepareStatement(sql);
            int registro = inserther.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Se ah agregado 1 herramienta ");
           */
           
            //Listar todas las herramientas con stock superior a 10.
            String sql = "SELECT * FROM herramienta WHERE stock >=10";
            PreparedStatement listarher = conexion.prepareStatement(sql);
            ResultSet resultado = listarher.executeQuery();
            
            while(resultado.next()){
                System.out.println("ID" + resultado.getInt("idHerramienta"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Descripcion: " + resultado.getString("descripcion"));
                System.out.println("Stock: " + resultado.getInt("stock"));
                System.out.println("Estado: " + resultado.getBoolean("estado"));
                System.out.println("");
            }
        
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el Driver "+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de Datos "+ex.getMessage());
        }
    }
    
}
