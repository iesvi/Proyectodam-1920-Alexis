# ProyectoDam: Organize-It App



Este proyecto final para el grado DAM tratará el desarrollo de una aplicación con solución SaaS, la aplicación a su vez dará solución </br>
a la organización de diferentes tipos de actividades permitiendo que varias personas se pongan de acuerdo de la forma más </br>
rápida y eficiente posible. 

<br>

## Índice
> **[1- Introducción.](#1)**
>
> **[ 1.2- Objetivo General.](#1.2)**
>
> **[ 1.3- Objetivos especificos.](#1.3)**
>
> **[2- Tecnologías de desarollo.](#3)**
>
> **[3- Requisitos funcionales (Casos de uso).](#4)**
>
> **[4- Modelo de objetos de negocio.](#5)**
>
> **[5- Interfaz (React).](#6)**


<br>
<br>

<a name="1"></a>
# Introducción





<a name="1.2"></a>
## Objetivo general
Ralizar un estudio del modelo de distribución de software SaaS basado en microservicios, identificando los componentes claves </br>
necesarios para llegar a desplegar una aplicación basada en esta arquitectura.

<br>

<a name="1.3"></a>
## Objetivos específicos

<ul>
    <li>Conocer los principales componentes en una arquitectura de microservicios.
        <ul>
        <li>Cloud Config.</li>
        <li>Service Discovery.</li>
        <li>Gateway.</li>
        </ul>
    </li>    
    <li>Codificación de la aplicación usando el modelo MVC y la arquitectura de microservicios.</li>
    <li>Despliege de la aplicación en aws.</li>
</ul>

<br>


<a name="3"></a>

## Tecnologías de desarrollo
 
<ul>
    <li><b>SaaS: </b>Es un modelo de distribución de software en el que se ofrece al usuario un servicio accesible<br>
                desde cualquier dispositivo. Esto se consigue alojando todo el soporte lógico y datos del cliente en servidores.</li>
    <li><b>Microservicios: </b>Es una arquitectura para el desarrollo del software en la que una aplicación es formada por <br>
                distintos servicios independientes que se despliegan según se vayan necesitando.</li>
    <li><b>Spring: </b>Es un framework para java.</li>
    <li><b>AWS: </b>Es una colección de servicios cloud que ofrece amazon.</li>
    <li><b>MongoDB: </b></li>Base de datos no relacional.
    <li><b>React: </b></li>
    <li><b>Node.JS: </b>Gestor de paquetes</li>
</ul>



<br>
<br>

<a name="4"></a>

# Analisis de requisitos funcionales.

<br>

## Diagrama de casos de uso.

<br>
<img src="/img/diagramauso.jpg" height="600" width="800"/>
<br>
<br>
<br>

### Descripción: Crear actividad.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_1.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario Identificado.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario identificado en el sistema crea una nueva actividad.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>El usuario está identificado en el sistema.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td><p>1. El usuario rellena los datos mínimos necesarios ("Una fecha y un lugar, fecha límite, descripción, título, participativa y pública")".</p>
				<p>2. El usuario agreaga las fechas y lugares extras que desee (hasta un máximo de 5 posibilidades si la actividad se marca como 
				<br>no participativa, y un máximo de 2 en caso de ser marcada como participativa).</p>
				<p>3. El usuario publica la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se crea una nueva actividad.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 1:</b></p>
		     <p>El usuario no configura los detalles mínimos.</p>
		</td>
		<td>
			<p>1. El usuario no propone ningún detalle mínimo necesario.</p>
		    <p>2. El usuario agrega los datos extras que desee.</p>
			<p>3. El sistema no permite publicar la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 2:</b></p>
		     <p>El usuario no configura detalles extras.</p>
		</td>
		<td>
			<p>2. El usuario no agrega ninguna opción extra.</p>
			<p>3. El usuario publica la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 3:</b></p>
		     <p>El usuario no publica la actividad.</p>
		</td>
		<td>
			<p>3. El usuario no publica la actividad.</p>
		</td>
 	</tr>
</table>

<br>
<br>


### Descripción: Ver detalles de una actividad.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_2.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario ve los detalles de una actividad.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>Ninguna.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td> 	
			<p>1. El usuaio clica en la miniatura de una actividad.</p>
     		<p>2. El sistema muestra los detalles de la actividad en una nueva ventana.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se muestran los detalles de una actividad.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativas:</b></p>
		<td>
		     <p>Ninguna.</p>
		</td>
 	</tr>
</table>

<br>
<br>

### Descripción: Unirse a una actividad.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_3.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario se une a una actividad.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>El usuario está viendo los detalles de una actividad y está identificado en el sistema.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuario clica en "Asistiré".</p>
			<p>2. El usuario se une a la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>El usuario se une a una actividad.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativas:</b></p>
		</td>
		<td>
			<p>Ninguna.</p>
		</td>
 	</tr>
</table>

<br>
<br>


### Descripción: Buscar una actividad.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_4.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>El usuario busca actividades por título.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>Ninguna.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuario introduce en la barra de búsqueda el título que desea buscar".</p>
            <p>2. El sistema muestra una lista con las actividades que tengan un título que contenga el texto buscado.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se muestra un listado de actividades.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativas:</b></p>
		</td>
		<td>
		     <p>Ninguna.</p>
		</td>
 	</tr>
</table>

<br>
<br>


### Descripción: Registrarse.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_5.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario se registra en el sistema.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>Ninguna.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuaio clica en "Registrarse"</p>
			<p>2. El sistema abre una nueva ventana y muestra un formulario de registro.</p>
            <p>3. El usuario rellena el formulario y clica en "Registrarse".</p>
            <p>4. El sistema comprueba los datos introducidos por el usuario.</p>
            <p>5. El sistema registra al usuario.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>El usuario es registrado en el sistema.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 1:</b></p>
		     <p>El usuario no rellena el formulario correctamente.</p>
		</td>
		<td>
			<p>5. El sistema lanza un mensaje al usuario "Datos incorrectos".</p>
		</td>
 	</tr>
 		<tr>
  		<td>
		     <p><b>Alternativa 2:</b></p>
		     <p>El usuario introduce un nombre en uso</p>
		</td>
		<td>
			<p>5. El sistema lanza un mensaje al usuario "El nombre ya está en uso".</p>
		</td>
 	</tr>
</table>

<br>
<br>



### Descripción: Identificarse.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_6.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario se identifica en el sistema.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>Ninguna.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuaio introduce sus credenciales.</p>
            <p>2. El sistema comprueba los datos.</p>
            <p>3. El sistema muestra una pantalla de inicio personalizada con las actividades relacionadas al usuario.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se  muestra una pantalla de inicio personalizada con las actividades relacionadas al usuario.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 1:</b></p>
		     <p>El usuario no introduce las credenciales correctamente.</p>
		</td>
		<td>
			<p>4. El sistema lanza un mensaje "Nombre de usuario o contraseña incorrectos."</p>
		</td>
 	</tr>
</table>

<br>
<br>



### Descripción: Proponer detalles extras.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_7.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario propone detalles extras para una actividad.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>El usuario está identificado en el sistema, apuntado para la actividad a la que va a hacer proposiciones, la organización de la actividad es participativa, y no se ha superado la fécha límite de organización.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuario agrega las fechas y lugares extra que desee (un máximo de 2 fechas y 2 lugares).</p>
            <p>2. El usuario confirma las propuestas.</p>
            <p>3. El sistema añade las propuestas a la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se agregan los detalles extras propuestos.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativas:</b></p>
		</td>
		<td>
		     <p>Ninguna.</p>
		</td>
 	</tr>
</table>

<br>
<br>

### Descripción: Votar detalles extras.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_8.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Usuario.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario vota detalles extras para una actividad.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>El usuario está identificado en el sistema, apuntado para la actividad en la que va a votar y no se ha superado la fécha límite de organización.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuario vota los detalles extras que desee.</p>
            <p>2. El usuario confirma los votos.</p>
            <p>3. El sistema suma los votos.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se suman las votaciones realizadas por el usuario.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativas:</b></p>
		</td>
		<td>
		     <p>Ninguna.</p>
		</td>
 	</tr>
</table>

<br>
<br>

### Descripción: Creador borra una actividad.

<table>
	<tr>
		<td><b>Identificador:</b></td>
		<td>CU_9.1</td>
 	</tr>
	<tr>
		<td><b>Actores:</b></td>
		<td>Creador.</td>
 	</tr>
	<tr>
		<td><b>Descripción:</b></td>
		<td>Un usuario creador de una actividad, la cancela.</td>
 	</tr>
 	<tr>
  		<td><b>Precondición:</b></td>
   		<td>El usuario está identificado en el sistema y es el creador de la actividad.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuario está viendo una actividad.</p>
            <p>2. El pulsa en "Cancelar actividad".</p>
            <p>3. El sistema borra la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>Se elimina la actividad de la base de datos.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativas:</b></p>
		</td>
		<td>
		     <p>Ninguna.</p>
		</td>
 	</tr>
</table>

<br>
<br>


<a name="5"></a>

# Modelo de objetos de negocio.

<br>

## Diagrama de entidad-relación.

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
