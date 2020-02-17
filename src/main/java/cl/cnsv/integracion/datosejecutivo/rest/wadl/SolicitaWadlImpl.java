package cl.cnsv.integracion.datosejecutivo.rest.wadl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

public class SolicitaWadlImpl implements SolicitaWadl {

	private static final Logger logger =  Logger.getLogger(SolicitaWadlImpl.class);

	@Override
	public String getWadl(String base) {
		
		String wadl = "";
		String aux = "";
		String errorWadl = "<h1>NO ENCONTRADO</h1>";
		
		try(FileReader fr = new FileReader("src/main/resources/application.wadl")) {
			try(BufferedReader br = new BufferedReader(fr)) {
				while ((aux = br.readLine()) != null) {
					wadl = wadl.concat(aux);
				}
	
				wadl = wadl.replace("base=\"/\"", base);
				
			} catch (IOException e) {
				wadl = errorWadl;
				logger.error("Error al leer archivo wadl: " + e.getMessage(), e);
			} catch (Exception e) {
				wadl = errorWadl;
				logger.error("Error general: " + e.getMessage(), e);
			}

		} catch (FileNotFoundException e) {
			wadl = errorWadl;
			logger.error("Archivo wadl no encontrado: " + e.getMessage(), e);
		} catch (Exception e) {
			wadl = errorWadl;
			logger.error("Error general: " + e.getMessage(), e);
		}
		
		return wadl;
	}
}

