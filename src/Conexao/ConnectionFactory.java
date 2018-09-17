package Conexao;

import java.sql.*;

public class ConnectionFactory {
    
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/bd_aguia_master","root","");
            
        }
        catch(SQLException ex){
            throw new RuntimeException(ex);
            
        }
    }

}
