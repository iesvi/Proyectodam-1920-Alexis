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

<br>
<br>
Veamos ahora cómo se aplicará esta tecnología al desarrollo y puesta en producción del proyecto:
<br>
<br>

### SaaS
<hr>

<b>SaaS</b> por tanto es un modelo de distribución de software en el que se ofrece al usuario un servicio disponible desde <br>
 cualquier dispositivo, pues al estar alojado en la nube sólo se necesita conexión a internet para acceder a este. Este modelo<br>
 de distribución es el que se usará para el despliegue de la aplicación.


<br>
<br>

### Gitab
<hr>

Gitlab es un **PaaS** *(Plataforma como servicio)* que nos permite hacer control de versiones de un proyecto de desarrollo, en este<br>
servicio es donde se alojarán el código, y la documentación de la aplicación.

<br>
<br>
<br>
<img src="./img/aws.png" align="right" >

### AWS
<hr>

**Amazon Web Services** es una colección de servicios que ofrece amazon, será la plataforma que se usará para desplegar los microservicios
de la aplicación. Concretamente se usará un servicio de los que ofrece esta plataforma, llamado EC2, este servicio permite alquilar maquinas
virtuales *(IaaS)* con unos recursos personalizables y en las que tenemos un control total sobre el sistema. En el apartado [despliegue](depliegue/Despliegue.md)
se explica paso a paso cómo se han usado estos servicios para hacer el despliuegue de la aplicación.

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



<img src="./img/react.png" height="70" width="70" align="right"/>

## React:
React es una biblioteca de javascript que agiliza el desarrollo de interfaces y ha cambiado la forma en la que se entendía el uso de **HTML+CSS+Javascript**,
que, hasta su aparación, se trataban como códigos independientes ya que se establecía una separación por lenguaje, en lugar de por funcionalidad,
que es como funciona React. Para conseguir esta integración de HTML+CSS+Javascript, el desarrollo de interfaces con React se hace creando componentes.

### Componentes

Un componente es una función de Javascript que renderiza un codigo HTML al que se le puede dar estilo usando CSS, usando componentes podemos separar
una interfaz por piezas que se usan unas a otras estableciendo relaciones padre-hijo. Los componentes pueden reutilizarse en diferentes partes del
codigo de la interfaz y pueden tener variables de estado, en las que se almacene información que cambie de forma dinámica como puede ser un título,
y propiedades, que se pueden entender como valores que recibe del componente que los declare. Cuando un componente declara a otro componente se
establece una relación de padre-hijo, siendo el padre el componente que declara, esta relación se maneja internamente como si se tratara de un arbol
de nodos y es posible gracias al uso de Jsx.

Ejemplo de un componente:

<br>
<img src="./img/componente.jpg" align="center" />
<br>

En el ejemplo se puede ver como el componente es una función de Javascript que se llama LugarAdd:

<br>
<img src="./img/react1.jpg" align="center" />
<br>

Que tiene una variable de estado llamada thisLugar:

<br>
<img src="./img/react2.jpg" align="center" />
<br>

Este estado toma su valor de una propiedad que hereda del padre que lo declare:

<br>
<img src="./img/react3.jpg" align="center" />
<br>

El componente devuelve un código HTML que forma su estructura:

<br>
<img src="./img/react4.jpg" align="center" />
<br>

Y dentro de este código HTML podemos hacer referencia a las variables de estado o propiedades del componente

<br>
<img src="./img/reac5.jpg" align="center" />
<br>


<br>
<br>



### JSX

JSX es una extensión de javascript desarrollada para definir estructuras de nodos con propiedades y atributos de forma sencilla con una sintaxis familiar
y concisa. Con JSX podemos anidar componentes como si se tratara de un XML, donde cada componente sería el equivalente a un elemento, y las propiedades que
se le pasan los atributos.

<br>
<img src="./img/react6.jpg" align="center" />
<br>
<br>
<br>


<img src="./img/nodejs.png" height="110" width="100" align="right"/>
<br>


## Node.Js:
Para instalar los paquetes necesarios de React, se usará Node.JS, un gestor de paquetes que nos permite, además de descargar e instalar paquetes,
crear un fichero de dependencias llamado **package.json**, en el que se guarde una referencia a todos los paquetes que se han instalado en nuestro entorno de trabajo. De esta
forma podremos mover el codigo de react sin necesidad de arrastrar con él la carpeta **node_modules**, que es donde se almacenan todos estos paquetes
instalados y que puede llegar a alcanzar un peso considerable que relentize la movilidad del proyecto para realizar su despliegue en otras máquinas.

Comandos usados para las instalación de dependencias:<br>
<br>

<code>    npm add 'nombreDependencia' --save</code>

Con esta instrucción instalaremos cualquier paquete y con el parámetro --save guardaremos esa dependecia en el fichero **package.json**. Al parámetro
--save se le puede añadir --save-dev, esto hará que la dependencia se guarde como una dependencia necesaria sólo para el desearrollo, de forma que
cuando se instalen las depencias para la puesta en producción, no se instalen paquetes innecesarios.
<br>
<br>

<code align="center">     npm install</code>

Con esta otra será con la que podremos instalar todas las dependecias del fichero **package.json** y reconstruir la carpeta node_modules.

Muestro aquí una captura con las dependecias usadas para este proyecto:

<br>
<br>
<img src="./img/nodejs2.jpg" />
<br>

<br>
<br>


<a name="figura" />

### A continuación un diagrama en el que se muestra cómo se organizará la aplicación usando todas las tecnologías mencionadas.
<br>
<br>
<br>


<img src="./img/arquitectura.jpg" height="600" width="991" align="right"/>

