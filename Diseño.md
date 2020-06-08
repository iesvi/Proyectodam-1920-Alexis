# Diseño de la aplicación


### Modelo de objetos de negocio.

### Diagrama de clases




<br>
<br>
<br>

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