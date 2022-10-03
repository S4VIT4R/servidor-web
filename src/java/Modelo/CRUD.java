/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author ferru
 */
public interface CRUD {
    
    public List<Persona> listar();
    public String add(String nombre,String apellido,String sexo,int edad);
    public String update(int id,String nombre,String apellido,String sexo,int edad);
    
}
