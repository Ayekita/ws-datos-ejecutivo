package cl.cnsv.integracion.datosejecutivo.rest.wadl;

import javax.ws.rs.*;

@Consumes("application/json; charset=UTF-8") 
@Produces("application/json; charset=ISO-8859-1")
public interface SolicitaWadl {
	
	@GET 
	@Path("application.wadl") 
	@Produces("application/vnd.sun.wadl+xml,application/xml") 
	@Consumes("application/json; charset=UTF-8")
    String getWadl(String base);
}
