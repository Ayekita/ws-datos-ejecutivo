package cl.cnsv.integracion.datosejecutivo.util;

public class Utiles {

	private Utiles() {
		throw new IllegalStateException("Utiles class");
	}


	public static String calcularDigito(String vrut)
	{
		String rut = vrut.trim();

		int cantidad = rut.length();
		int factor = 2;
		int suma = 0;
		String verificador = "";

		for(int i = cantidad; i > 0; i--)
		{
			if(factor > 7)
			{
				factor = 2;
			}
			suma += (Integer.parseInt(rut.substring((i-1), i)))*factor;
			factor++;

		}
		verificador = String.valueOf(11 - suma%11);
		if(verificador.equals("10")){
			verificador = "K";
		}

		return verificador;        
	} 


	public static String calcularRutString(int rut)
	{
		String sRut = Integer.toString(rut);
		switch (sRut.length()) {
			case (13):
				sRut = "0" + sRut;
			break;
			case (12):
				sRut = "00" + sRut;
			break;
			case (11):
				sRut = "000" + sRut;
			break;
			case (10):
				sRut = "0000" + sRut;
			break;
			case (9):
				sRut = "00000" + sRut;
			break;
			case (8):
				sRut = "000000" + sRut;
			break;
			case (7):
				sRut = "0000000" + sRut;
			break;
			case (6):
				sRut = "00000000" + sRut;
			break;
			case (5):
				sRut = "000000000" + sRut;
			break;
			case (4):
				sRut = "0000000000" + sRut;
			break;
			case (3):
				sRut = "00000000000" + sRut;
			break;
			case (2):
				sRut = "000000000000" + sRut;
			break;
			case (1):
				sRut = "0000000000000" + sRut;
			break;
			default:
			break;
		}
		return sRut;        
	} 
}
