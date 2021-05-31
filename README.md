# Aplicación REST con Spring Boot 2 y Java 11

![](https://img.shields.io/badge/Java11-orange.svg)
![](https://img.shields.io/badge/Spring%20Boot-2.5.0-green.svg)

## Contenido del repositorio
- Proyecto `maven` con `SpringBoot`
- Conexión a una base de datos en `H2` almacenada en memoria
- Utiliza `JPA` para el mantenimiento de la base de datos
- Autenticación con `JWT`
- Documentación con `Swagger` ofreciendo una interfaz de usuario con `Swagger-ui`
- Tests con `Junit` y `MockMVC`
- Uso de un `Interceptor` para identificar las peticiones con un UUID
- Uso de un `Filter` para validar token
- Se crea la anotación `TrackTime`para controlar el tiempo de ejecución de algunos servicios
- Uso de un `HandlerException` para controlar y personalizar excepciones
- Se cachean algunas peticiones con `Spring Cache`

## Ejecutar la aplicación en local:
Compilar y preparar el jar:
```
mvn clean install
```
Arrancar la aplicación:
```
mvn spring-boot:run
```
Ruta base de la API Rest: http://localhost:8080

Swagger-ui: http://localhost:8080/swagger-ui.html

## Servicios REST publicados ##
- Sin atenticación:
  - http://localhost:8080/superheroes (HTTP:GET)
  - http://localhost:8080/superheroes/{id} (HTTP:GET)
  - http://localhost:8080/superheroes/cache (HTTP:DELETE)
- Con autenticación:
  - http://localhost:8080/superheroe (HTTP:PUT)
  - http://localhost:8080/superheroe/{id} (HTTP:DELETE)
- Obtener token:
  - http://localhost:8080/usuario (HTTP:POST)
    
## Docker ##
Comando para construir el contenedor:
```
docker build -t api-superheroes .
```
Comando para ejecutar el contenedor:
```
run -p 8080:8080 api-superheroes
```
## Documentación API ##
http://localhost:8080/v2/api-docs
