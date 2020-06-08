# Entorno de desarrollo

Para el desarrollo de la aplicación se ha usado el IDE Intellij. Lo proyectos han sido creados en la página web <br>
[**Spring Initializr**](https://start.spring.io/), que permite configurar un proyecto maven con dependecias de <br>
Spring deseadas. Al descargar el proyecto, se puede importar desde Intellij y ya tendríamos el proyecto listo <br>
para comenzar a trabajar.

<br>
Para el proyecto la única configuración destacable y necesaria, es la que permite a cada microservicio ir al config<br>
server a buscar su configuración, allí definida, y en el caso del config server, la indicación del repositorio <br>
que almacena los ficheros de configuración. Veamos cómo realizarlo:


Configuración para los microservicios:

1. Primero se ha de crear el fichero bootstrap.yml y borrar el fichero application.properties en caso de que existiera.
2. En este fichero se indicarán 4 parámetros:
    - name: Este será el nombre que le daremos al microservicio, con este nombre, el config server será capaz de<br>
            reconocer que fichero de configuración pertenece a cada uno de los microservicios que se conectan a él<br>
            pues los ficheros de configuración deben llamarse con el nombre del microservicio, seguido de la extensión<br>
            que se vaya a usar .yml, .yaml, .properties... Este nombre además será el Id con el que eureka registre<br>
            al microservicio.
    <br>
    - label: Indica la rama del repositorio en el que se encuentra el fichero de configuración del microservicio.
    - uri: Indica la dirección donde está funcionando el Service Config.
    - fail-test: Esta propiedad, si se indica como verdadera, hará que el microservicio no arranque si no es capaz <br>
                 de obtener la configuración del Service Config.


spring:
  application:
    name: alerta #Nombre que le daremos al microservicio.
  cloud:
    config:
      label: master
      uri: http://54.161.173.48:8888  #dirección dónde se encuentra el service config
      fail-fast: true             #con esta opción activada, el servidor no arrancará si no es capaz de leer la configuración
