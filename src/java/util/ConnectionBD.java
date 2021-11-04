package util;
 
 
import java.sql.*;

public class ConnectionBD  {
   
   // JDBC driver name and database URL.
   static final String JDBC_DRIVER = "org.postgresql.Driver";
   static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/situacao22";
   
   // declare Connection and Statement for accessing 
   // and querying database
   private Connection connection;
   
   // constructor connects to database, queries database, processes 
   
   public ConnectionBD() 
   {
     
     
      try {
                 
         // load database driver class
         Class.forName( JDBC_DRIVER );

         // establish connection to database
         connection = DriverManager.getConnection( DATABASE_URL,"postgres","postgres" );
         
        // System.out.println("Sucesso  connection = DriverManager.getConnection( DATABASE_URL );");

         // create Statement for querying database
         
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
         
   } 
    

public Connection getConnection()
{

      return connection;

}
}