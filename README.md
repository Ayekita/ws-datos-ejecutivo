# Servicio para obtener datos relacionados a un ejecutivo #
En este artefacto se encuenta el servicio necesario para obtener datos del ejecutivo.

La documentación de este servicio se puede revisar a traves de swagger-ui 
en esta misma aplicacion en la ruta:

http://&lt;dominio&gt;/ws-datos-ejecutivo


Tambien es posible descargar la definición de los servicios en 
formato swagger 1.2 en la ruta:

http://&lt;dominio&gt;/ws-datos-ejecutivo/restcns/api-docs


El servicio necesita que en el encabezado Autorization se envie un bearer token el cual es validado contra el SSO de consorcio
 




[![](https://d2k4v76wo6voed.cloudfront.net/assets/home/logos/cl/consorcio-c47fda1b644d7e89c57b7b1d422f5c8c2025d7b8cde3901b397061773f4ef77d.png)](https://consorcio.cl)
# Documentación de Proyecto Servicio para la obtención de los datos del ejecutivo  #

### Información del proyecto ###

* En este artefacto se encuentan los servicios necesarios para realizar el cambio de via de pago. 
* La documentación de estos servicios se puede revisar a traves de swagger-ui en esta misma aplicacion en la ruta:
    * http://&lt;dominio&gt;/ws-datos-ejecutivo
* Tambien es posible descargar la definición de los servicios en  formato swagger 1.2 en la ruta:
    * http://&lt;dominio&gt;/ws-datos-ejecutivo/restcns/api-docs
* Los servicios necesitan que en el encabezado Autorization se envie un bearer token el cual es validado contra el SSO de consorcio

### Instalación y configuración ###

* Configuración de servidor de aplicación: 
    * Crear los siguientes directorios en Glassfish:
        * /usr/archivos/ws-datos-ejecutivo/data/log
    * En caso de que el war ws-datos-ejecutivo.war no sea instalado por el sistema de integración continua, deberá subirlo desde la consola Glassfish.     
             
* Instrucciones de compilación y deploy: 

Compilar con maven

```sh
$ cd ws-datos-ejecutivo
$ mvn clean package
```

### Otros temas de interés ###

* Información de contacto de equipo de desarrollo: 
	desarrollador: jessica.catalan@digitali.cl
	
