# Análisis de la aplicación.


## Requisitos funcionales: diagrama de casos de uso.

<br>
<img src="/img/diagramauso.jpg" height="600" width="800"/>
<br>
<br>
<br>


## Requisitos funcionales: descripción de casos de uso.


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
