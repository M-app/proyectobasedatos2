package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
     String hostName = "aislamiento";
        String dbName = "colegio";
        String user = "upvhas";
        String password = "Umg123456";
        String url = String.format("jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        //jdbc:sqlserver://aislamiento.database.windows.net:1433;database=colegio;user=upvhas@aislamiento;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
        Connection connection = null;
        
       public void conectar(){
         try {
             connection = DriverManager.getConnection(url);
         } catch (SQLException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
                String schema;
         try {
             schema = connection.getSchema();
             System.out.println("Successful connection - Schema: " + schema);
         } catch (SQLException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
}
