# Entorno de desarrollo

Para el desarrollo de la aplicación se ha usado el IDE Intellij. Lo proyectos han sido creados en la página web
[**Spring Initializr**](https://start.spring.io/), que permite configurar un proyecto maven con dependecias de
Spring deseadas. Al descargar el proyecto, se puede importar desde Intellij y ya tendríamos el proyecto listo
para comenzar a trabajar.

<br>
Para el proyecto la única configuración destacable y necesaria, es la que permite a cada microservicio ir al config
server a buscar su configuración, allí definida, y en el caso del config server, la indicación del repositorio
que almacena los ficheros de configuración. Veamos cómo realizarlo:

<br>
<br>

## Configuración para los microservicios:

1. Primero se ha de crear el fichero bootstrap.yml y borrar el fichero application.properties en caso de que existiera.
2. En este fichero se indicarán 4 parámetros:
    <br><br>
    - **name**: Este será el nombre que le daremos al microservicio, con este nombre, el config server será capaz de
        reconocer que fichero de configuración pertenece a cada uno de los microservicios que se conectan a él
        pues los ficheros de configuración deben llamarse con el nombre del microservicio, seguido de la extensión
        que se vaya a usar .yml, .yaml, .properties... Este nombre además será el Id con el que eureka registre
        al microservicio.
        <br><br>
    - **label**: Indica la rama del repositorio en el que se encuentra el fichero de configuración del microservicio.
        <br><br>
    - **uri**: Indica la dirección donde está funcionando el Service Config.
        <br><br>
    - **fail-test**: Esta propiedad, si se indica como verdadera, hará que el microservicio no arranque si no es capaz
                 de obtener la configuración del Service Config.

#### Codigo usado en el proyecto:

<code>spring:
  application:
    name: alerta #Nombre que le daremos al microservicio.
  cloud:
    config:
      label: master
      uri: http://54.161.173.48:8888  #dirección dónde se encuentra el service config
      fail-fast: true             #con esta opción activada, el servidor no arrancará si no es capaz de leer la configuración
</code>

<br>
<br>




## Configuración para el config server:

1. Primero se ha de crear el fichero bootstrap.yml y borrar el fichero application.properties en caso de que existiera.
2. En este fichero se indicarán 10 parámetros, los mas destacables son los siguientes:
    <br><br>
    - **name**: Nombre que daremos al microservicio.
        <br><br>
    - **uri**: Indica la dirección del repositorio donde se encuentran los ficheros de configuración.
        <br><br>
    - **fail-test**: Esta propiedad, si se indica como verdadera, hará que el microservicio no arranque si no es capaz
                 de obtener la configuración del Service Config.
        <br><br>
    - **default-label**: Configura la rama por defecto del repositorio.

#### Codigo usado en el proyecto:

<code>server:
  port: 8888
spring:
  application:
    name: config
  cloud:
    config:
      server:
        git:
          uri: https://github.com/AlexisRuiz00/servercloudconfig.git
          force-pull: true
          clone-on-start: true
          default-label: master
          repos:
            local:
              uri: https://github.com/AlexisRuiz00/servercloudconfig.git
              force-pull: true
              clone-on-start: true
              default-label: master<code>

