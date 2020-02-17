package cl.cnsv.integracion.datosejecutivo.dao.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cl.cnsv.integracion.datosejecutivo.util.Constantes;

public class Conexion {

	private static Logger logger = Logger.getLogger(Conexion.class);

	private static Connection con; 

	private Conexion() {
		throw new IllegalStateException("Conexion class");
	}

	/**
	 * Descripción de getConexion
	 * @return     conexion oracle
	 */        

	public static Connection getConexion() {
		String dsName = Constantes.DS_WSDATOSEJECUTIVO;
		DataSource ds = null;
		try {
			if(con == null || con.isClosed()) {
				Context ic = new InitialContext();
				ds = (DataSource) ic.lookup(dsName);
				con = ds.getConnection();
			}
		} catch (NamingException|SQLException e) {
			logger.error("Error en getConexion: " + e.getMessage());
		} 
		return con;
	}
}