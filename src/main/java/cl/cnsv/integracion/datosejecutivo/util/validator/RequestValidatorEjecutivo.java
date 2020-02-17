package cl.cnsv.integracion.datosejecutivo.util.validator;

import cl.cnsv.integracion.datosejecutivo.modelo.ParamsEjecutivo;
import cl.cnsv.integracion.datosejecutivo.modelo.Respuesta;
import cl.cnsv.integracion.datosejecutivo.util.Constantes;

public class RequestValidatorEjecutivo {
	
	private RequestValidatorEjecutivo() {
		throw new IllegalStateException("RequestValidatorEjecutivo class");
	}

	public static Respuesta validarRequestGetEjecutivo(ParamsEjecutivo inGetEjecutivo) {

		if (!StringValidator.validaNulos(inGetEjecutivo.getNbranch()) && !StringValidator.validaNulos(inGetEjecutivo.getNproducto())) {
			return new Respuesta("01", Constantes.VAL_REQUEST_NULO);
		}

		if (!StringValidator.validaNulos(inGetEjecutivo.getNbranch())) {
			return new Respuesta("01", Constantes.VAL_NBRANCH_NULO_VACIO);
		} else if (!ExpresionRegularValidator.validarExpresionRegular(inGetEjecutivo.getNbranch(), ExpresionRegularValidator.VALIDA_NUMERICO)) {
			return new Respuesta("01", Constantes.VAL_NBRANCH_FORMATO);
		}
		
		if (!StringValidator.validaNulos(inGetEjecutivo.getNproducto())) {
			return new Respuesta("01", Constantes.VAL_NPRODUCTO_NULO_VACIO);
		} else if (!ExpresionRegularValidator.validarExpresionRegular(inGetEjecutivo.getNproducto(), ExpresionRegularValidator.VALIDA_NUMERICO)) {
			return new Respuesta("01", Constantes.VAL_NPRODUCTO_FORMATO);
		}

		return null;
	}

}
