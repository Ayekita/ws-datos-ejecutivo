package cl.cnsv.integracion.datosejecutivo.util.validator;

import org.apache.log4j.Logger;

public class StringValidator {

    private static final Logger LOGGER = Logger.getLogger(StringValidator.class);

    public static boolean validaNulos(String campoValidado) {
        Boolean resultado = true;

        if (campoValidado == null || "".equals(campoValidado)) {
            resultado = false;
        }
        return resultado;
    }

    public static boolean validaLargoString(String valor, int largo) {
        boolean ret = false;
        if (valor != null && !"".equals(valor)) {
            try {
                if (valor.length() <= largo) {
                    ret = true;
                }
            } catch (Exception ex) {
                LOGGER.error("Error en metodo validaLargoString : " + ex);
                return false;
            }
        }

        return ret;
    }
}