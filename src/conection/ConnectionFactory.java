/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alita
 */

//Classe de conexão com o banco de dados
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/rmiordenar";
    private static final String USER = "root"; 
    private static final String PASS = "";
    
    
    //Abrir conexão com o banco de dados
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER); //Classe do driver
            
            return DriverManager.getConnection(URL,USER,PASS);
            
        } catch (ClassNotFoundException | SQLException ex ) {
            throw new RuntimeException("Erro de conexão: ",ex);
        }
        
    }
    
    //Fechar conexão com o banco de dados
    public static void closeConnection(Connection con){
       try{
           if(con != null){
               con.close();
           }
        }catch (SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    public static void closeConnection(Connection con, PreparedStatement stat){
       
        closeConnection(con);
        
        try{
           if(stat != null){
               stat.close();
           }
        }catch (SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
     public static void closeConnection(Connection con, PreparedStatement stat, ResultSet rs){
       
        closeConnection(con,stat);
        
        try{
           if(rs != null){
              rs.close();
           }
        }catch (SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

    public static Statement prepareStatement(String cmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}   

