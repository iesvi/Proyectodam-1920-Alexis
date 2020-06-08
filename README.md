# ProyectoDam: Organize-It App




<br>

## Índice
> **[1- Introducción.](#1)**
>
> **[ 1.1- Objetivo General.](#1.1)**
>
> **[ 1.2- Objetivos especificos.](#1.2)**
>
> **[2- Tecnologías de desarollo.](./Tecnologias.md)**
>
> **[3- Entorno de desarrollo.](#3)**
>
> **[4- Despliegue de la aplicación.](#4)**
>
> **[5- Análisis de la aplicación.](./Analisis.md)**
>
> **[ 5.1- Requisitos funcionales.](#5.1)**
>
> **[  5.1.2- Diagrama de casos de uso.](#5.1.2)**
>
> **[  5.1.3- Descripción de casos de uso.](#5.1.3)**
>
> **[ 5.2- Diagrama de clases.](#5.2)**
>
> **[ 6- Diseño de la aplicación.](#6)**
>
> **[ 6.1- Modelo de objetos de negocio.](#6.1)**
>
> **[7- Codificación del proyecto.](#7)**
>
> **[8- Pruebas.](#8)**
>
> **[9- Detalles técnicos.](#9)**
>
> **[10- Problemas durante el desarrollo.](#10)**
>
> **[11- Mejoras posibles.](#11)**
>
> **[12- Conclusiones.](#12)**
>
> **[13- Bibliografia/Webgrafía.](#13)**

<br>
<br>

<a name="1"></a>
# Introducción


Este proyecto final para el grado DAM tratará el desarrollo de una aplicación con solución SaaS, la aplicación a su vez dará solución
a la organización de actividades <br> permitiendo que varias personas se pongan de acuerdo de la forma más rápida y eficiente posible. 
Para el desarrollo del proyecto se utilizará una arquitectura <br> basada en microservicios, siendo que la lógica de la aplicación será dividida
 por funcionalidades que constituirán los distintos microservicios.



<a name="1.1"></a>
## Objetivo general
Ralizar un estudio del modelo de distribución de software SaaS basado en microservicios, identificando los componentes claves </br>
necesarios para llegar a desplegar una<br>  aplicación basada en esta arquitectura.


<br>

<a name="1.2"></a>
## Objetivos específicos

<ul>
    <li>Conocer los principales componentes en una arquitectura de microservicios.
        <ul>
        <li>Microservicio</li>
        <li>Cloud Config.</li>
        <li>Service Discovery.</li>
        <li>Gateway.</li>
        </ul>
    </li>    
    <li>Codificación de la aplicación usando el modelo MVC y la arquitectura de microservicios.</li>
    <li>Desarrolo de una interfaz usando la biblioteca React</li>
    <li>Despliege de la aplicación en aws.</li>
</ul>


<br>
<br>
<br>
<br>


<a name="3"></a>
# Entorno de desarrollo.




<br>
<br>

<a name="4"></a>
# Despliegue de la aplicación.




<a name="6"></a>

# Diseño de la aplicación

<a name="6.1"></a>
## Modelo de objetos de negocio.


### Diagrama de entidad-relación.

<br>
<img src="/img/er.jpg" height="180" width="750"/>
<br>
<br>
<br>
<br>

<h2>Explicación</h2>

<table>
<tr>
    <td>
        <b>Entidad:</b>
    </td>
    <td>
        Actividad
    </td>
</tr>
<tr>
    <td>
    </td>
    <td>
        Esta entidad representa las actividades que pueden crear y con las que pueden interactuar los usuarios de distintas formas, <br>
            ya sea apuntandose como partícipes, proponiendo nuevos detalles, votando detalles, viendo sus detalles o buscandolas.
    </td>
</tr>
<tr>
    <td>
        <b>Atributos:</b>
    </td>
    <td>
    </td>
<tr>
    <td>
        Cod
    </td>
    <td>
        <p>Codigo único que identifica a la actividad.</p>
    </td>
</tr>
    <td>
        Pública
    </td>
    <td>
        Este atributo será un booleano que nos indicará si la actividad es pública o privada.<br>
        De forma que si es pública puede ser encontrada mediante búsqueda, y si es privada tan sólo<br>
        puede ser accesible a través de una invitación.
    </td>
</tr>
<tr>
    <td>
        Participativa
    </td>
    <td>
        Este atributo será un booleano que nos indicará si la actividad tiene unos detalles cerrados o por<br>
        el contrario está abierta a que los participantes propongan detalles como la fecha, el lugar...
    </td>
</tr>
<tr>
    <td>
        Fecha
    </td>
    <td>
        Fecha en la que se realizará la actividad.
    </td>
</tr>
<tr>
    <td>
        Finalizada
    </td>
    <td>
        Booleano que indica si la actividad a alcanzado la fecha límite marcada.
    </td>
</tr>
<tr>
    <td>
        Fecha Límite
    </td>
    <td>
        En caso de que la actividad sea participativa, este atributo establece la fecha límite para<br>
        realizar propuestas y concretar los detalles.
    </td>
</tr>
<tr>
    <td>
        Descripción
    </td>
    <td>
        Texto que define el objetivo de la actividad.
    </td>
</tr>
</table>

<br>
<br>

<table>
<tr>
    <td>
        <b>Entidad:</b>
    </td>
    <td>
        Usuario
    </td>
</tr>
<tr>
    <td>
    </td>
    <td>
        Esta entidad representa a los usuarios que podran acceder al sistema.
    </td>
</tr>
<tr>
    <td>
        <b>Atributos:</b>
    </td>
    <td>
    </td>
<tr>
    <td>
        Nombre
    </td>
    <td>
        <p>Nombre único que identifica al usuario.</p>
    </td>
</tr>
<tr>
    <td>
        Contraseña
    </td>
    <td>
        <p>Código alfanumérico que permite el acceso a una cuenta de usuario.</p>
    </td>
</tr>
<tr>
    <td>
        E-mail
    </td>
    <td>
        <p>Dirección de correo electrónico de un usuario.</p>
    </td>
</tr>
</table>

<br>
<br>


<table>
<tr>
    <td>
        <b>Relación:</b>
    </td>
    <td>
        Asisten
    </td>
</tr>
<tr>
    <td>
    </td>
    <td>
        Los usuarios pueden asistir a ninguna o varias actividades, de la misma forma que a una actividad pueden<br>
        asistir uno (creador) o varios usuarios.
    </td>
</tr>
<tr>
    <td>
        <b>Atributos:</b>
    </td>
    <td>
    </td>
<tr>
    <td>
        Es creador
    </td>
    <td>
        Este atributo define cual es el usuario creador de la actividad.
    </td>
</tr>
<tr>
    <td>
        Participa lugar
    </td>
    <td>
        Este atributo indica si el usuario ha participado en la actividad votando o añadiendo lugares.
    </td>
</tr>
<tr>
    <td>
        Participa fecha
    </td>
    <td>
        Este atributo indica si el usuario ha participado en la actividad votando o añadiendo fechas.
    </td>
</tr>

</table>

<br>
<br>
<br>
<br>
<br>

<a name="6"></a>



<a name="7"></a>
# Codificación del proyecto.


# Interfaz

<br>

## Pantalla de identificación.

<br>
<img src="/img/login.jpg" height="400" width="750"/>
<br>

## Pantalla de registro.

<br>
<img src="/img/regist.jpg" height="400" width="750"/>
<br>

## Pantalla de actividad detallada.

<br>
<img src="/img/activity.jpg" height="627" width="592"/>
<br>


## Pantalla para la creación de una actividad.

<br>
<img src="/img/newactivity.jpg" height="623" width="992"/>
<br>





<a name="8"></a>
# Pruebas.


<a name="9"></a>
# Detalles técnicos.

<a name="10"></a>
# Problemas durante el desarrollo.



<a name="11"></a>
# Mejoras posibles.

<a name="12"></a>
# Conclusiones..

<a name="13"></a>
# Bibliografia/Webgrafía.

