package cl.cnsv.integracion.datosejecutivo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import cl.cnsv.integracion.datosejecutivo.dao.conexion.Conexion;
import cl.cnsv.integracion.datosejecutivo.modelo.Ejecutivo;
import cl.cnsv.integracion.datosejecutivo.modelo.RespuestaEjecutivo;

public class SqlOracleDao {

	private static Logger logger = Logger.getLogger(SqlOracleDao.class);

	public RespuestaEjecutivo invocacionServicioDatosEjecutivo(Ejecutivo ejecutivo) throws SQLException {
		String error = "Error en invocacionServicioDatosEjecutivo: ";
		Connection con= null;
		CallableStatement cst = null;
		RespuestaEjecutivo resultadoLista = null;
		try{
			logger.info("Inicio Acceso Datos en invocacionServicioDatosEjecutivo ");
			con = Conexion.getConexion();

			cst = con.prepareCall("{call SP_GET_DATOS_EJECUTIVO(?,?,?,?,?,?,?,?,?)}");

			//Parametrso de entrada
			cst.setString(1, ejecutivo.getsRut());
			cst.setInt(2, ejecutivo.getNbranch());
			cst.setInt(3, ejecutivo.getNproduct());

			//Parametros de Salida
			cst.registerOutParameter(4, java.sql.Types.INTEGER);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.INTEGER);
			cst.registerOutParameter(7, java.sql.Types.INTEGER);
			cst.registerOutParameter(8, java.sql.Types.INTEGER);
			cst.registerOutParameter(9, java.sql.Types.VARCHAR);

			cst.execute();
			int errorCst = cst.getInt(8);
			String mensaje = cst.getString(9);

			if(errorCst != 0){
				logger.error(error + mensaje);
			}else{
				logger.info("invocacionServicioDatosEjecutivo::Registros obtenidos.");
				resultadoLista = mapeoDatosEjecutivo(cst, ejecutivo);
			}
			logger.info("Fin Acceso Datos en invocacionServicioDatosEjecutivo");
		}catch(SQLException ex){
			logger.error(error + ex.getMessage());
		}catch(Exception e){
			logger.error(error + e.getMessage());
		}finally{
			SqlOracleDao.closeables(con, null, cst);
		}
		return resultadoLista;
	}

	public RespuestaEjecutivo mapeoDatosEjecutivo(CallableStatement cst, Ejecutivo ejecutivo) throws SQLException{
		RespuestaEjecutivo result = null; 
		result = new RespuestaEjecutivo();
		result.setnRut(ejecutivo.getRut());
		result.setsRut(ejecutivo.getsRut());
		result.setsDv(ejecutivo.getDv());
		result.setsNombre(ejecutivo.getNombre());
		result.setsEmail(ejecutivo.getEmail());
		result.setsUser(ejecutivo.getUser());
		result.setnCodIntermediario(cst.getInt(4));
		result.setnSucursal(cst.getInt(5));
		result.setnOficina(cst.getInt(6));
		result.setnAgencia(cst.getInt(7));			
		return result;
	}      

	public static void closeables(Connection con, ResultSet rs, CallableStatement cs){
		String error = "Error en closeables: ";
		if (con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				logger.error(error + e.getMessage());
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(error + e.getMessage());
			}
		}
		if(cs!=null){
			try {
				cs.close();
			} catch (SQLException e) {
				logger.error(error + e.getMessage());
			}
		}
	}
}