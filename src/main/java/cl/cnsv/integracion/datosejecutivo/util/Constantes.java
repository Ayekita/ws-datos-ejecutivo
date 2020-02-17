package cl.cnsv.integracion.datosejecutivo.util;

public abstract class Constantes {

	private Constantes() {
		throw new IllegalStateException("Constantes class");
	}

	public static final String DS_WSDATOSEJECUTIVO = "jdbc/WsDatosEjecutivo";

	public static final String VAL_REQUEST_NULO = "Error Validacion: Request es nulo";
	public static final String VAL_NBRANCH_NULO_VACIO = "Error Validacion: Debe ingresar el campo nbranch";
	public static final String VAL_NBRANCH_FORMATO = "Error Validacion: El campo nbranch puede ser solo numerico";
	public static final String VAL_NPRODUCTO_NULO_VACIO = "Error Validacion: Debe ingresar el campo nproducto";
	public static final String VAL_NPRODUCTO_FORMATO = "Error Validacion: El campo nproducto puede ser solo numerico";
	public static final String VAL_RUT_NULO_VACIO = "Error Validacion: El Rut del ejecutivo no viene en el SSO";
	public static final String VAL_RUT_NO_EXISTE = "Error BD: El Rut del ejecutivo no existe en la base de datos";
	public static final String RES_PROCESO_OK = "OK";
}
