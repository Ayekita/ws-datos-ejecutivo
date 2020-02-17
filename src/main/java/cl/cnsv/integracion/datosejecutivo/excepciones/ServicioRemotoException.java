package cl.cnsv.integracion.datosejecutivo.excepciones;

public class ServicioRemotoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String url;


    public ServicioRemotoException(String url, Throwable e) {
        this.url = url;
        this.initCause(e);
    }

    @Override
    public String getMessage() {
        return "el servicio remoto: " + url + "Respondio con un error: " + getCause().getMessage();
    }
}
