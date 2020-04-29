# ProyectoDam: Organize-It App



Este proyecto final para el grado DAM tratará el desarrollo de una aplicación con solución SaaS, la aplicación a su vez dará solución </br>
a la organización de diferentes tipos de actividades permitiendo que varias personas se pongan de acuerdo de la forma más </br>
rápida y eficiente posible. 

<br>

## Índice
> **[1- Objetivo General.](#1)**
>
> **[2- Objetivos especificos.](#2)**
>
> **[3- Tecnologías de desarollo.](#3)**
>
> **[4- Requisitos funcinoales (Casos de uso).](#4)**


<br>
<br>


<a name="1"></a>
## Objetivo general
Ralizar un estudio del modelo de distribución de software SaaS basado en microservicios, identificando los componentes claves </br>
necesarios para llegar a desplegar una aplicación basada en esta arquitectura.

<br>

<a name="2"></a>
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
    <li>Despliege de la aplicación.</li>
</ul>

<br>


<a name="4"></a>

## Tecnologías de desarrollo
 
<ul>
    <li><b>SaaS: </b>Es un modelo de distribución de software en el que se ofrece al usuario un servicio accesible<br>
                desde cualquier dispositivo. Esto se consigue alojando todo el soporte lógico y datos del cliente en servidores.</li>
    <li><b>Microservicios: </b>Es una arquitectura para el desarrollo del software en la que una aplicación es formada por <br>
                distintos servicios independientes que se despliegan según se vayan necesitando.</li>
    <li><b>Spring: </b>Es un framework para java.</li>
    <li><b>AWS: </b>Es una colección de servicios cloud que ofrece amazon.</li>
</ul>



<br>
<br>

<a name="3"></a>

# Analisis de requisitos funcionales.

<br>

## Diagrama de casos de uso.

<br>
<img src="/img/diagramauso.jpg" height="350" width="600"/>
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
			<td> 	<p>1. El usuario configura el tipo de actividad "Quedada", "Deportiva" o"Celebración".</p>
		     		<p>2. El usuario propone los detalles mínimos necesarios para publicar la actividad ("Lugar", "Fecha y hora", "descripción", "Fecha límite de organización" y otros que dependeran del tipo de actividad).</p>
				<p>3. El usuario agrega los detalles extras que desee, según el tipo de actividad configurada. ("Regalo", "Equipos", "Presupuesto general", "Presupuesto por cabeza", etc).</p>
				<p>4. El usuario clasifica la actividad como "pública" o "privada".</p>
				<p>5. El usuario publica la actividad.</p>
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
			<p>4. El usuario no propone ningún detalle mínimo necesario.</p>
		     	<p>5. El usuario clasifica la actividad como "pública" o "privada".</p>
			<p>6. El sistema no permite publicar la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 2:</b></p>
		     <p>El usuario no configura detalles extras.</p>
		</td>
		<td>
			<p>4. El usuario no agrega ninguna opción extra.</p>
		    <p>5. El usuario clasifica la actividad como "pública" o "privada".</p>
			<p>6. El usuario publica la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 3:</b></p>
		     <p>El usuario no publica la actividad.</p>
		</td>
		<td>
			<p>6. El usuario no publica la actividad.</p>
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
   		<td>SSe muestran los detalles de una actividad.</td>
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
   		<td>El usuario está viendo los detalles de una actividad.</td>
 	 	</tr>
	<tr>
  		<td><b>Secuencia normal:</b></td>
			<td>
			<p>1. El usuario clica en "Apuntarse a la actividad".</p>
		    <p>2. Si el usuario no está identificado en el sistema, el sistema alerta al usuario para que se identifique.</p>
			<p> 2.1 El usuario se identifica.</p>
			<p>3. El usuario se une a la actividad.</p>
		</td>
 	</tr>
	<tr>
  		<td><b>Postcondición:</b></td>
   		<td>El usuario se une a una actividad.</td>
 	</tr>
	<tr>
  		<td>
		     <p><b>Alternativa 1:</b></p>
		     <p>El usuario no se identifica.</p>
		</td>
		<td>
			<p>2.1 El usuario no se identifica.</p>
		    <p>3. El usuario no se une a la actividad.</p>
		</td>
 	</tr>
</table>

<br>
<br>

