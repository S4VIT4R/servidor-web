/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection conn;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aplicaciones?user=root&password=");
        }catch(Exception e){
           
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        System.out.println(con.getConnection());
    }
    
}
