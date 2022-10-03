
package Modelo;

import java.util.List;


public interface CRUD {
    
    public List<Persona> listar();
    public String add(String nombre,String apellido,String sexo,int edad);
    public String update(int id,String nombre,String apellido,String sexo,int edad);
    
}
