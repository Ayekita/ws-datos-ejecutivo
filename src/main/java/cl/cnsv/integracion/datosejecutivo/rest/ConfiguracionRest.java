package cl.cnsv.integracion.datosejecutivo.rest;

import org.apache.log4j.PropertyConfigurator;

import cl.cnsv.integracion.datosejecutivo.config.Config;
import cl.cnsv.integracion.datosejecutivo.rest.datosejecutivo.ServicioDatosEjecutivo;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("restcns")
public class ConfiguracionRest extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		PropertyConfigurator.configure(System.getProperty("ARCHIVOS_BASE") + Config.RUTA_CONFIG + "log4j.properties");

		Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
		resources.add(UncaughtExceptionMapper.class);
		addRestResourceClasses(resources);

		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method.
	 * It is automatically populated with
	 * all resources defined in the project.
	 * If required, comment out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(ServicioDatosEjecutivo.class);
	}
}
