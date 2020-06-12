# Tecnologías de desarrollo

*A continuación se describen las tecnologías que han sido usadas para el desarrollo y despliegue de la aplicación.*

<br>
<br>




## Cloud Services

<img src="./img/piramidecloud.png" height="261" width="278" align="right"/>

Uno de los objetivos de este proyecto, es el de desplegar la aplición como SaaS *(Software como servicio)*, como se puede<br>
  ver en la figura a la derecha, SaaS forma parte de un conjunto de servicios llamados Servicios cloud, estos servicios<br>
 han cambiado la forma de entender tanto la gestión como el acceso a los recursos informáticos, pues con ellos hemos <br>
 dejado atrás un modelo en el que la única manera de obtener estos recursos era adquiriéndolos fisicamente y hacesrse<br>
 cargo de su instalación y mantenimiento.


Con la aparición de los <b>cloud services</b> el escenario a dado un giro al consumo bajo demanda dónde los recursos <br>
 son consumidos como servicios. El usuario final se desentiende totalmente del mantenimiento y se limíta al uso y<br>
 consumo, volviendose algo intangible para el usuario, que no conoce, ni necesita conocer, la localización física<br>
 de estos recursos (si fuese hardware), o la máquina en la que se está ejecutando (si fuese software).


Veamos ahora cómo se aplicará esta tecnología al desarrollo y puesta en producción del proyecto:


### SaaS

<b>SaaS</b> por tanto es un modelo de distribución de software en el que se ofrece al usuario un servicio disponible desde <br>
 cualquier dispositivo, pues al estar alojado en la nube sólo se necesita conexión a internet para acceder a este. Este modelo<br>
 de distribución es el que se usará para el despliegue de la aplicación.


### Gitab

Gitlab es un **PaaS** *(Plataforma como servicio)* que nos permite hacer control de versiones de un proyecto de desarrollo, en este<br>
servicio es donde se alojarán el código, y la documentación de la aplicación.


### AWS

**Amazon Web Services** es una colección de servicios que ofrece amazon, será la plataforma que se usará para desplegar los microservicios<br>
de la aplicación. Concretamente se usará un servicio de los que ofrece esta plataforma, llamado EC2, este servicio permite alquilar maquinas<br>
virtuales *(IaaS)* con unos recursos personalizables y en las que tenemos un control total sobre el sistema.

<br>
<br>




## Microservicios:


Es una arquitectura para el desarrollo del software, en la que una aplicación es formada por distintos servicios
independientes que se despliegan según se vayan necesitando. Con este tipo de arquitectura conseguimos una 
alta escalabilidad y una gran facilidad para la ampliación de funcionalidades, pues al estar la aplicación
compuesta por pequeños servicios que se comunican entre ellos, para añadir uno nuevo, no es necesario detener
nada.

A la hora de desplegar una arquitectura de estas características, surgen ciertas problemáticas por la naturaleza
descentralizada de la mismsa. Para dar solución a estos problemas, surgen los siguientes componentes o servicios, que
deberemos de añadir a nuestra aplicación:


  - Cloud Config:
    <br>
        Este servicio nos permitirá centralizar la configuración de todos los servicios en un único repositorio, de esta<br> 
         forma nuestra aplicación será facilmente parametrizable e incluso podremos realizar cambios en caliente.<br>

<img src="./img/microservices.png" height="261" width="350" align="left"/>


  - Service Discovery: 
    <br>
        La arquitectura de microservicios se basa en que cada servicio consuma de otros microservicios, cada uno<br>
         con un número n de instancias desplegadas. Esto significa que un microservicio no puede tener configurado<br>
         una dirección estática indicando en que dirección están los otros microservicios que va a consumir, pues<br>
         cada microservicio va a tener numerosas instancias funcionando con distintas direcciones.
    <br>
    <br>
        Para solucionar este problema se usa el Service Discovery, este servidor almacena las direcciones de cada<br>
         instancia conforme se van desplegando y registra el id del servicio al que pertenecen. De esta forma, cada<br>
         microservicio sólo necesita conocer los id de los microservicios que vaya a consumir y la dirección del<br>
         service discovery, cuando vayan a realizar una comunicación con otro servicio, preguntarán al<br>
         service discovery por la dirección de *x* id y este les devolverá una dirección que en ese<br>
         momento esté siendo usada por el servicio en cuestión.
        
  - Gateway:
    <br>
        Con este definiremos un único punto de entrada a nuestra aplicación, que se encargará de enrutar<br>
         las peticiones externas hacia el microservicio pertinente y de devolver las respuestas.


Al mismo tiempo, esta descentralización tiene unas ventajas que con una arquitectura monolítica serían imposibles de<br>
conseguir:

  - Tolerancia a fallos: El tener la posibilidad de desplegar varias instancias por cada microervicio hace sea<br>
                         muy poco probable que se caigan todas, esto junto a una buena configuracion que redirija<br>
                         las peticiones cuando no haya respuesta, nos da una garantía casi al 100% de ofrecer un<br>
                         servicio siempre disponible.
  - Distintos lenguajes: Cada microservicio pude estar codificado con un lenguaje distinto.
  - Escalado: Podemos tener un cluster por cada microservicio y tener en funcionamiento la cantidad de instancias<br>
              que necesitemos en cada momento.


La aplicación se basará en este tipo de arquitectura, siendo estos los microservicios que se desarrollarán:
- Activity:.
- Login.
- Alert.
- Gateway, Cloud Config, Eureka *(Service Discovery)*.

En este [apartado](/codificacion/Codificacion.md) se explica a fondo la funcionalidad de cada uno, y como se han desarrollado. Más [abajo](#figura) encontraréis una figura<br>
en la que se explica gráficamente la arquitectura de la aplicación.


<br>
<br>



## Spring:

<img src="./img/spring.png" height="261" width="350" align="right"/>

 
Spring es un framework para Java que ofrece herramientas con las que podremos construir rápidamente los <br>
 servicios mencionados en el punto anterior. Para cada uno de ellos usaremos las siguientes herramientas<br>
 de Spring:

- **Spring Boot** →  Para construir los microservicios que manejen la lógica de nuestra aplicación.
- **Spring Cloud Config** →  Para construir el Config server.
- **Spring Cloud Netflix Zuul** →  Para construir el Gateway
- **Spring Cloud Netflix Eureka** →  Para construir el Service discover. 


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>



<img src="./img/mongodb.png" height="110" width="200" align="right"/>
<br>

## MongoDB:
MongoDB es una base de datos no relacional, y será la utilizada para almacenar los datos de la aplicación. Se usará lanzando una máquina<br>
virtual **EC2** de **aws** en la que se instalará un servidor de MongoDB que será al que se conectarán los microservicios para recuperar y<br>
guardar los datos. Gracias a que es un tipo de base de datos no relacional, podemos comenzar a trabajar con ella sin necesidad de configurar
ni crear nada, se instala el servidor, se arranca y ya se puede utilizar, la base de datos creará automaticamente una colección. Una colección,
sin entrar demasiado en detalle de como funcionan las bases de datos no relacionales, es algo así como una carpeta en la que se guardan todos
los documentos que pertenecen a una misma clase. Esto de identificar una clase como documento se puede ver en la [explicación del código](codificacion/Codificacion.md#repository)
inserte el primer documento, y ya el resto de documentos que sean de la misma clase, se insertarán en esa colección.




<img src="./img/aws.png" height="110" width="100" align="right"/>
<br>

## AWS:
Es una colección de servicios cloud que ofrece amazon, y será donde se realizará el despliegue de la aplicación.




<img src="./img/react.png" height="70" width="70" align="right"/>

## React:
Es una colección de servicios cloud que ofrece amazon, y será donde se realizará el despliegue de la aplicación.




<img src="./img/nodejs.png" height="110" width="100" align="right"/>
<br>

## Node.Js:
Gestor de paquetes

<br>
<br>


<a name="figura" />

### A continuación un diagrama en el que se muestra cómo se organizará la aplicación usando todas las tecnologías mencionadas.
<br>
<br>
<br>


<img src="./img/arquitectura.jpg" height="600" width="991" align="right"/>

