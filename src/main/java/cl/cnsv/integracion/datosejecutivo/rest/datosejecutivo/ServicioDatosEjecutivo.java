package cl.cnsv.integracion.datosejecutivo.rest.datosejecutivo;

import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.*;

import cl.cnsv.integracion.datosejecutivo.business.DatosEjecutivo;
import cl.cnsv.integracion.datosejecutivo.modelo.*;

/**
 * Servicio REST para obtener informacion del ejecutivo.
 *
 * @author {digitali}
 */
@RequestScoped
@Path("/v1")
@Api(value = "v1", description = "Servicios para obtener los datos de un ejecutivo")
public class ServicioDatosEjecutivo {

	/**
	 * Json utf-8.
	 */
	private static final String JSON_UTF8 = MediaType.APPLICATION_JSON + "; charset=UTF-8";

	@POST
	@Path("getDatosEjecutivo")	
	@Produces({ JSON_UTF8 })
	@ApiOperation(
			value = "Este servicio obtiene los datos de un ejecutivo",
			notes = "Este servicio obtiene los datos de un ejecutivo",
			response = Respuesta.class
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Token de autorizacion", required = true, dataType = "string", paramType = "header"),
	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK, se realizo la obtencion del ejecutivo."),
			@ApiResponse(code = 500, message = "Ocurrio un error no identificado")})
	public Respuesta obtenerEjecutivo(@Valid ParamsEjecutivo params, @Context HttpHeaders httpheaders) {
		Respuesta respuesta = null;
		String token = httpheaders.getHeaderString("Authorization");
		DatosEjecutivo datos = new DatosEjecutivo();
		respuesta = datos.getDatosEjecutivo(token, params);
		
		return  respuesta;
	}
}
