package cl.cnsv.integracion.datosejecutivo.rest;

import org.apache.log4j.Logger;
import cl.cnsv.integracion.datosejecutivo.excepciones.ServicioRemotoException;
import cl.cnsv.integracion.datosejecutivo.modelo.Respuesta;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class UncaughtExceptionMapper implements ExceptionMapper<Throwable> {
    /**
     * Logger de la clase.
     */
    private static final Logger LOGGER = Logger.getLogger(UncaughtExceptionMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        Respuesta r = new Respuesta();
        r.setCodigo("99");
        if (exception instanceof ServicioRemotoException && exception.getCause() instanceof WebApplicationException) {
            WebApplicationException wex = (WebApplicationException) exception.getCause();
            LOGGER.fatal("Un servicio remoto devolvio un codigo de error: Codigo:" + wex.getResponse().getStatus()
                    + ". Mensaje:" + wex.getResponse().readEntity(String.class), exception);
            r.setMensaje(exception.getMessage());
        } else {
            LOGGER.fatal("Ocurrio un error inesperado.", exception);
            r.setMensaje("Ocurrio un error inesperado.");

        }
        return Response.status(500).entity(r).type("application/json").build();
    }
}
