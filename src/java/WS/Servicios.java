/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Modelo.Method;
import Modelo.Persona;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(serviceName = "Servicios")
public class Servicios {
    
    Method method = new Method();

    @WebMethod(operationName = "listar")
    public List<Persona> listar() {
        List<Persona> datos =method.listar();  
        return datos;
    }
    

    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "sexo") String sexo, @WebParam(name = "edad") int edad) {
        //TODO write your implementation code here:
        String mensaje=method.add(nombre, apellido, sexo, edad);
        return mensaje;
    }
    
    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "sexo") String sexo, @WebParam(name = "edad") int edad) {
        //TODO write your implementation code here:
        String mensaje=method.update(id, nombre, apellido, sexo, edad);
        return mensaje;
    }
    
    
}
