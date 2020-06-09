# Tecnologías de desarrollo

*A continuación se describen las tecnologías que han sido usadas para el desarrollo y despliegue de la aplicación.*

<br>
<br>




## SaaS

<img src="./img/piramidecloud.png" height="261" width="278" align="right"/>
 
Como se puede ver en la figura a la derecha, SaaS forma parte de un conjunto de servicios llamados Servicios cloud, estos <br>
 servicios han cambiado la forma de entender tanto la gestión como el acceso a los recursos informáticos, pues con<br>
 ellos hemos dejado atrás un modelo modelo en el que la única manera de obtener estos recursos era adquiriéndolos<br>
 fisicamente y hacerse cargo de su instalación y mantenimiento.


Con la aparición de los <b>cloud services</b> el escenario a dado un giro al consumo bajo demanda dónde los recursos <br>
 son consumidos como servicios. El usuario final se desentiende totalmente del mantenimiento y se limíta al uso y<br>
 consumo, volviendose algo intangible para el usuario, que no conoce, ni necesita conocer, la localización física<br>
 de estos recursos (si fuese hardware), o la máquina en la que se está ejecutando (si fuese software).



<b>SaaS</b> por tanto es un modelo de distribución de software en el que se ofrece al usuario un servicio disponible desde <br>
 cualquier dispositivo, pues al estar alojado en la nube sólo se necesita conexión a internet para acceder a este.




<br>
<br>




## Microservicios:


Es una arquitectura para el desarrollo del software en la que una aplicación es formada por distintos servicios
independientes que se despliegan según se vayan necesitando. Con este tipo de arquitectura conseguimos una 
alta escalabilidad y una gran facilidad para la ampliación de funcionalidades, pues al estar la aplicación
compuesta por pequeños servicios que se comunican entre ellos, para añadir uno nuevo no es necesario detener
nada.

A la hora de desplegar una arquitectura de estas características, surgen ciertas problemáticas por la naturaleza
descentralizada de esta. Para dar solución a estos problemas, surgen los siguientes componentes o servicios, que
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



<br>
<br>



## Spring:

<img src="./img/spring.png" height="261" width="350" align="right"/>

 
Spring es un framework para java que ofrece herramientas con las que podremos construir rápidamente los <br>
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
MongoDB es una base de datos no relacional, y será la utilizada para almacenar los datos de la aplicación.




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


### A continuación un diagrama en el que se muestra cómo se organizará la aplicación usando todas las tecnologías mencionadas.
<br>
<br>
<br>


<img src="./img/arquitectura.jpg" height="600" width="991" align="right"/>

