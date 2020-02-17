package cl.cnsv.integracion.datosejecutivo.modelo;

import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Representa el mensaje estandar base para las respuesta de servicios.
 *
 * @author {digitali}
 */
public class ParamsEjecutivo {

	@ApiModelProperty(value = "nbranch", required = true)
	@NotNull
	private String nbranch;
	
	@ApiModelProperty(value = "nproducto", required = true)
	@NotNull
	private String nproducto;
	/**
	 * @return the nbranch
	 */
	public String getNbranch() {
		return nbranch;
	}
	/**
	 * @param nbranch the nbranch to set
	 */
	public void setNbranch(String nbranch) {
		this.nbranch = nbranch;
	}
	/**
	 * @return the nproducto
	 */
	public String getNproducto() {
		return nproducto;
	}
	/**
	 * @param nproducto the nproducto to set
	 */
	public void setNproducto(String nproducto) {
		this.nproducto = nproducto;
	}


}
