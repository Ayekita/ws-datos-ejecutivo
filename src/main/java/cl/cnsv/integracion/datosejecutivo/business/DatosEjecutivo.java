package cl.cnsv.integracion.datosejecutivo.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import cl.cnsv.integracion.datosejecutivo.dao.SqlOracleDao;
import cl.cnsv.integracion.datosejecutivo.modelo.Ejecutivo;
import cl.cnsv.integracion.datosejecutivo.modelo.ParamsEjecutivo;
import cl.cnsv.integracion.datosejecutivo.modelo.Respuesta;
import cl.cnsv.integracion.datosejecutivo.modelo.RespuestaEjecutivo;
import cl.cnsv.integracion.datosejecutivo.util.Constantes;
import cl.cnsv.integracion.datosejecutivo.util.DecodificarToken;
import cl.cnsv.integracion.datosejecutivo.util.Utiles;
import cl.cnsv.integracion.datosejecutivo.util.validator.RequestValidatorEjecutivo;

public class DatosEjecutivo {

	private static Logger logger = Logger.getLogger(DatosEjecutivo.class);

	public Respuesta getDatosEjecutivo(String token, ParamsEjecutivo inGetEjecutivo){
		Respuesta respuesta = null;
		RespuestaEjecutivo respuestaEjecutivo = null;
		DecodificarToken ct = new DecodificarToken();
		SqlOracleDao sqlDao = new SqlOracleDao();

		logger.info("");
		logger.info("-----------------------------------------------------------");
		logger.info(">>>>>>>>>> INICIO Web Service getDatosEjecutivo <<<<<<<<<<");
		logger.info("------------------------------------------------------------");

		respuesta = RequestValidatorEjecutivo.validarRequestGetEjecutivo(inGetEjecutivo);
		if (respuesta == null) {
			Ejecutivo ejecutivo = ct.decodificarTokenJWT(token);
			if(ejecutivo.getRut() != 0){
				ejecutivo.setNbranch(Integer.parseInt(inGetEjecutivo.getNbranch()));
				ejecutivo.setNproduct(Integer. parseInt(inGetEjecutivo.getNproducto()));
				ejecutivo.setDv(Utiles.calcularDigito(Integer.toString(ejecutivo.getRut())));
				ejecutivo.setsRut(Utiles.calcularRutString(ejecutivo.getRut()));

				try {
					respuestaEjecutivo = sqlDao.invocacionServicioDatosEjecutivo(ejecutivo);
				} catch (SQLException e) {
					logger.error("Error en getDatosEjecutivos: " + e.getMessage());
				}
				if(respuestaEjecutivo != null){
					respuesta = new Respuesta("00", Constantes.RES_PROCESO_OK, respuestaEjecutivo);
				}else{
					respuesta = new Respuesta("02", Constantes.VAL_RUT_NO_EXISTE);
				}
			}else{
				respuesta = new Respuesta("01", Constantes.VAL_RUT_NULO_VACIO);
			}
		}

		logger.info("--------------------------------------------------------");
		logger.info(">>>>>>>>>> FIN Web Service getDatosEjecutivo <<<<<<<<<<");
		logger.info("--------------------------------------------------------");
		logger.info("");

		return respuesta;
	}
}
