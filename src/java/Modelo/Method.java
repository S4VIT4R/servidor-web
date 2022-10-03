package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Method implements CRUD{
    
    PreparedStatement ps;
    ResultSet rs; 
    Connection conn;
    Conexion conex= new Conexion();
    int res;
    String  mensaje;

    @Override
    public List<Persona> listar() {
        List<Persona> datos = new ArrayList<Persona>();
        String sql="select * from personas";
        try{
            conn=conex.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona pro = new Persona();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setApellido(rs.getString("apellido"));
                pro.setSexo(rs.getString("sexo"));
                pro.setEdad(rs.getInt("edad"));

                datos.add(pro);
            }
        }catch(SQLException e){
            
        }
        return datos;
    }

    @Override
    public String add(String nombre, String apellido, String sexo, int edad) {
        String sql = "insert into personas(nombre,apellido,sexo,edad) values (?,?,?,?)";
        try{
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, sexo);
            ps.setInt(4, edad);
            res= ps.executeUpdate();          
            if(res==1){
                mensaje = "Personas registrada correctamente!";
            } else{
                mensaje="Error al registrar la persona!";
            }           
        }catch(Exception e){
            
        }
        return mensaje;
    }

    @Override
    public String update(int id, String nombre, String apellido, String sexo, int edad) {
        String sql = "UPDATE personas SET nombre = ?, apellido = ?, sexo = ?, edad = ? WHERE id = ?";
        try{
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, sexo);
            ps.setInt(4, edad);
            ps.setInt(5, id);
            res= ps.executeUpdate();          
            if(res==1){
                mensaje = "Datos de la persona actualizados!";
            } else{
                mensaje="Error al actualizar los datos!";
            }           
        }catch(Exception e){
            
        }
        return mensaje;
    }
    
}
