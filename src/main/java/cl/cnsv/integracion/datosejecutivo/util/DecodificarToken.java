package cl.cnsv.integracion.datosejecutivo.util;

import org.apache.commons.codec.binary.Base64;

import org.json.JSONObject;

import cl.cnsv.integracion.datosejecutivo.modelo.Ejecutivo;

public class DecodificarToken {

	public Ejecutivo decodificarTokenJWT(String token){
		String[] splitString = token.split("\\.");
		String base64EncodedBody = splitString[1];

		Base64 base64Url = new Base64(true);
		String body = new String(base64Url.decode(base64EncodedBody));

		JSONObject objetoJson = new JSONObject(body);
		Ejecutivo ejecutivo = new Ejecutivo();
		if(!objetoJson.isNull("cnsv-Rut")){
			ejecutivo.setRut(objetoJson.getInt("cnsv-Rut"));  
		}
		if(!objetoJson.isNull("name")){
			ejecutivo.setNombre(objetoJson.getString("name")); 
		}
		if(!objetoJson.isNull("email")){
			ejecutivo.setEmail(objetoJson.getString("email")); 
		}
		if(!objetoJson.isNull("preferred_username")){
			ejecutivo.setUser(objetoJson.getString("preferred_username")); 
		}
	
		return ejecutivo;
	}
}
