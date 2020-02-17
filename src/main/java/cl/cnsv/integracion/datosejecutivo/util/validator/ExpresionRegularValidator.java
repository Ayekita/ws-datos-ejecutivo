package cl.cnsv.integracion.datosejecutivo.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class ExpresionRegularValidator {

    private static final Logger LOGGER = Logger.getLogger(ExpresionRegularValidator.class);

    public static final String VALIDA_RUT = "^[0-9]{1,9}-[0-9kK]{1}?$";
    public static final String VALIDA_EMAIL = "[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
    public static final String VALIDA_NOMBRE = "^([A-Za-zÑñáéíóúÁÉÍÓÚ ]+)$";
    public static final String VALIDA_ALFANUMERICO = "^([A-Za-z0-9]+)$";
    public static final String VALIDA_NUMERICO = "^([0-9]+)$";
    public static final String VALIDA_ALFANUMERICO_GUION = "^([A-Za-z0-9-]+)$";
    public static final String VALIDA_ALFANUMERICO_GUIONBAJO = "^([A-Za-z0-9_]+)$";
    public static final String VALIDA_ALFANUMERICO_ESPACIO = "^([A-Za-z0-9 ]+)$";
    public static final String VALIDA_ALFANUMERICO_ESPECIAL = "^([A-Za-z0-9_.-]+)$";
    
    private ExpresionRegularValidator() {
        throw new IllegalStateException("ExpresionRegularValidator class");
      }

    public static boolean validarExpresionRegular(String cadena, String expresion) {
        try {
            cadena = cadena.replaceAll("\u00A0", " ");

            Pattern pat = Pattern.compile(expresion);
            Matcher mat = pat.matcher(cadena);
            if (mat.find()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            LOGGER.error("Error en metodo validarExpresionRegular: " + ex);
            return false;
        }
    }
}