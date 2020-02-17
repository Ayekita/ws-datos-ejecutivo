package cl.cnsv.integracion.datosejecutivo.config;

import cl.cnsv.crypto.encryption.CryptoUtil;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Config(){}
    private static final Properties propiedades = new Properties();

    /**
     * Ruta donde se encuentran las configuraciones.
     */
    public static final String RUTA_CONFIG = "ws-datos-ejecutivo/data/mae/";

    /**
     * Logger de la clase.
     */
    private static final Logger LOGGER = Logger.getLogger(Config.class);
    public static final CryptoUtil cryptoCns;

    static{
        final String origen = System.getProperty("ARCHIVOS_BASE");
        try (InputStream inputStream = new FileInputStream(origen + RUTA_CONFIG + "config.properties")) {
            propiedades.load(inputStream);

        } catch (IOException e) {
            LOGGER.fatal("Ocurrio un error al leer la configuración", e);
        }
        cryptoCns = new CryptoUtil("", propiedades.getProperty("consorcio.app.cns-key"));

    }

    public static String getValue(String key){
        return propiedades.getProperty(key);
    }

    public static Long getValueAsLong(String key){
        return Long.valueOf(propiedades.getProperty(key)) ;
    }

    public static String getDecrypted(String key){
        return cryptoCns.decryptData(propiedades.getProperty(key));
    }

}
