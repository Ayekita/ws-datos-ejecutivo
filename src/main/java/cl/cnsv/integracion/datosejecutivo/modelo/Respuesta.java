package cl.cnsv.integracion.datosejecutivo.modelo;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class Respuesta {

	/**
	 * Codigo de respuesta.
	 */
	@ApiModelProperty(value = "0: OK\n" +
			"99: Error Genérico, ver el mensaje.\n" +
			"98: Error en la validación.\n")
	private String codigo;

	@ApiModelProperty(value = "\"OK\" o el mensaje del detalle del error")
	private String mensaje;

	@ApiModelProperty(value = "Respuesta del servicio que obtiene los datos del ejecutivo")
	private RespuestaEjecutivo respuestaEjecutivo;


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public RespuestaEjecutivo getRespuestaEjecutivo() {
		return respuestaEjecutivo;
	}

	
	public Respuesta() {
		
	}

	public void setRespuestaEjecutivo(RespuestaEjecutivo respuestaEjecutivo) {
		this.respuestaEjecutivo = respuestaEjecutivo;
	}

	public Respuesta(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public Respuesta(String codigo, String mensaje, RespuestaEjecutivo respuestaEjecutivo) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.respuestaEjecutivo = respuestaEjecutivo;
	}

	@Override
	public String toString() {
		return "Respuesta{" +
				"codigo='" + codigo + '\'' +
				", mensaje='" + mensaje + '\'' +
				", respuestaEjecutivo=" + respuestaEjecutivo +
				'}';
	}
}
