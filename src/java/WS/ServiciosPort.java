/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Jonathan
 */
@Path("serviciosport")
public class ServiciosPort {

    private WS_client.Servicios port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiciosPort
     */
    public ServiciosPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method add
     * @param nombre resource URI parameter
     * @param apellido resource URI parameter
     * @param sexo resource URI parameter
     * @param edad resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("add/")
    public String getAdd(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido, @QueryParam("sexo") String sexo, @QueryParam("edad")
            @DefaultValue("0") int edad) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.add(nombre, apellido, sexo, edad);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method update
     * @param id resource URI parameter
     * @param nombre resource URI parameter
     * @param apellido resource URI parameter
     * @param sexo resource URI parameter
     * @param edad resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("update/")
    public String getUpdate(@QueryParam("id")
            @DefaultValue("0") int id, @QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido, @QueryParam("sexo") String sexo, @QueryParam("edad")
            @DefaultValue("0") int edad) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.update(id, nombre, apellido, sexo, edad);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method listar
     * @return an instance of javax.xml.bind.JAXBElement<WS_client.ListarResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("listar/")
    public JAXBElement<WS_client.ListarResponse> getListar() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<WS_client.Persona> result = port.listar();

                class ListarResponse_1 extends WS_client.ListarResponse {

                    ListarResponse_1(java.util.List<WS_client.Persona> _return) {
                        this._return = _return;
                    }
                }
                WS_client.ListarResponse response = new ListarResponse_1(result);
                return new WS_client.ObjectFactory().createListarResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private WS_client.Servicios getPort() {
        try {
            // Call Web Service Operation
            WS_client.Servicios_Service service = new WS_client.Servicios_Service();
            WS_client.Servicios p = service.getServiciosPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
