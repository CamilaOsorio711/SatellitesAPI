# SatellitesAPI

Este proyecto es una Rest API que calcula las coordenadas x,y de una fuente que emite un mensaje a 3 satelites, teniendo en cuenta la trilateracion de distancias y posiciones. 

Expone 3 servicios: 

- **POST /topsecret/**
Recibe un JSON con la información de los 3 satelites (nombre, distancia y mensaje) y realiza el calculo de la posición x,y y descifra el mensaje del emisor. 
Retorna un JSON las posiciones y el mensaje. 
Si no puede determinar el mensaje o la posición retorna NOT_FOUND, de lo contrario retona OK.
Estructura del request
```json

{
   "satellites": [
{
"name": "Kenobi",
"distance": 100.0,
"message": ["este", "es", "", "mensaje", ""]
},
{
"name": "skywalker",
"distance": 115.5,
"message": ["este", "", "un", "", "secreto"]
},
{
"name": "sato",
"distance": 142.7,
"message": ["este", "", "un", "", ""]
}
]
}
```

- **POST /topsecret_split/{satellite_name}**
Recibe un JSON con la información de un solo satelite (distancia y mensaje) y almacena la información. 
Retorna CREATED, si pudo almacenar los datos del satelite. 

Estructura del request
```json

{
"distance": 142.7,
"message": ["este", "", "un", "", ""]
}
```

- **GET /topsecret_split/{satellite_name}**
Recibe un JSON con la información de un solo satelite (distancia y mensaje) y, si ya tiene la información de los 3 satelites, realiza el calculo de la posición x,y y descifra el mensaje del emisor. 
Retorna OK, si pudo determinar posición y mensaje.
Retorna NOT_FOUND si no tiene la información suficiente para realizar el calculo. 

Estructura del request
```json

{
"distance": 142.7,
"message": ["este", "", "un", "", ""]
}
```

## Tecnologías
Para este proyecto, se usaron las siguiente tecnologías

- Java Version 8
- SpringBoot/SpringWeb
- Maven
- JUnit

## Deploy en Local
1. Descargar el código fuente de este repositorio
2. Abrir el proyecto mvn en el IDE de preferencias
3. Ejecutar el programa principal
4. Probar los servicios con POSTMAN o el de preferencia

## Host
Esta API esta hosteada en Cloud en Google App Engine y la URL es https://satellites-api.oa.r.appspot.com/ 


