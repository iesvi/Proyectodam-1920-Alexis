# Codificación del proyecto.

En este documento se va a tratar uno a uno los casos de uso de la aplicacón, acompañandolos del código más significativo que los implementa, y como se 
aplica en la interfaz gráfica. Pero primero veamos como están construidos los microservicios para entender mejor el código, comenzando con una explicación
genérica de las anotaciones que se usan en los microservicios y como se adapta el patrón MVC en ellos:


- **@Autowired**: Esta anotación declarada sobre una variable hará que Spring automaticamente la inicialize.
- **@CrossOrigin(origins = "\*", allowedHeaders = "\*")**: con esta anotación se permite el intercambio de recursos de origen cruzado. 
- **@RequestMapping()**: Con RequestMapping asociamos la url definida entre los perentesis con el controlador donde se situe esta anotación.
                         si no se introduce ninguna url la dirección asociada será la dirección raiz (/).
- **@RestController**: Esta anotación convierte la clase en la que se use en un servicio REST.
- 


Los microservicios activity y login están construido usando la misma estructura:<br>

Tienen 3 paquetes principales que son **controller**, **service** y **repository**. El paquete controller supondría el paquete que conocemos
como **Vista** en un patrón **MVC**, este paquete, o componente, es el que ofrece una interfaz para que los clientes interactuen con el
microservicio, es el encargado de recibir y responder peticiones. Por otro lado tenemos los paquetes **repository** y **model**, el **Modelo** de nuestra
aplicación, que será el responsable de aglomerar las clases que representan los datos que maneja el sistema (*model*), y el encargado de manejar
la persistencia de los datos(*repository*). Entre medias de estos dos componentes se encuentra el paquete **service**, nuestro **Controlador**, será el
encargado de la lógica de negocios actuando como intermediario entre el componente controller y repository.

El microservicio alert tiene una estructura similar, pero presciende del paquete controller ya que este no se comunica con otros microservicios directamente,
sino que ejecuta una serie de comprobaciones los datos cada 24 horas e interactúa únicamente con la base de datos.


Siguiendo con la explicación de como funcionan los microservicios, las peticiones son recibidas por una interfaz **NnombreApi** en la que se definen los 
endpoints usando las anotaciones **@RestController**,**GetMapping** y **PostMapping**. Esta interfaz la implementa una clase **NombreController** 
(ambas dentro del paqute **controller**), que es definida como **servicio REST** usando la anotación **@RestController**.<br>
Ejemplo de uno de los microservicios: <br>

<br>
<div align="center" >

***ActivityApi***
<img src="./img/ApiActivity.jpg" alt="repository" />
<br>
<br>
<br>
***ActivityController***
<img src="./img/ControllerActivity.jpg" alt="repository" />
</div>

<br>
<br>

Las operaciones relacionadas con la base de datos se realizan usando una interfaz **NombreRepository** que extiende de **MongoRepository**. 
MongoRepository es una interfaz que nos permite realiazar múltiples operaciones con una base de datos MongoDB. Algunas de estas operaciones 
están ya definidase en MongoRepository y otras sólo tenemos que declararlas como métodos en nuestra interfaz *NombreRepository* utilizando palabras
claves que, Spring interpretará generando los métodos automaticamente. Un ejemplo sería para buscar cualquier objeto a partir de un atributo de su
clase, basta con definir un método tal que así: <code>Object findByAtributo(TipoAtributo valor)</code> y nos devolverá el primer objeto que encuentre
en la base de datos con un atributo que tenga el valor parametrizado.<br>
Ejemplo de uno de los microservicios:<br>

<img src="repositoryActivity.jpg" alt="repository" />

Por último, en el paquete service se crea la interfaz **NombreService** que implementa la clase **NombreServiceImpl** y es donde se desarrolla la
logica de negocio del microservicio.


<br>

### Microservicio Activity:<br>
Este microservicio se encarga de realizar las operaciones que tengan que ver con la **creación/modificación de actividades** y 
está organizado en las siguientes carpetas y clases:<br>

<img src="./img/arbolActivity.jpg" align="right" />


- **OrganizeIt**: Carpeta que contiene todo el proyecto.
  - **activity**: Carpeta que se usa para separar la clase ActivityApplication del resto del proyecto.
    - **config**
      - **Configuration**: Clase que define la configuración de beans.
    - **controller**
      - **constant**
        - **EndPointUris**: Clase en la que se definen las constantes que se van a usar para el mapeo de los puntos de entrada.
      - **impl**
        - **ActivityController**: Clase que implementa a la interfaz ActivityApi y define los métodos de esta.
      - **ActivityApi**: Interfaz en la que se definen los puntos de entrada a la aplicación.
    - **model**
      - **dto**
        - **ActivityDTO**: Clase que se usa para enviar información sobre una actividad a la interfaz.
        - **ActivityDTOStringed**: Objeto que se recibe desde la interfaz en el que todos los datos son de tipo primario.
        - **FechaDTO**: Clase que envia la interfaz cuando un usuario vota o propone una fecha.
        - **LugarDTO**: Clase que envia la interfaz cuando un usuario vota o propone un lugar.
        - **UserDTO**: Clase se recive desde el microservicio login.
      - **Activity**: Clase que se almacena en la base de datos.
      - **Fecha**: Clase que guarda una fecha junto a los votos de esta.
      - **Lugar**: Clase que guarda un lugar junto a los votos de este.
    - **repository**
      - **ActivityRepository**: Interfaz que extiende a MongoRepository y con la que se manejan los documentos de la clase activity.
    - **service**
      - **impl**
        - **ActivityServiceImpl** Clase que implementa a la interfaz ActivityService y define los métodos de esta.
      - **util**
        - **Converter**: Clase en la que se definen los métodos necesarios para la conversion entre clases. 
      - **ActivityService**: Interfaz que funciona entre el controlador y el repositorio encargandose de procesar los datos que viajan entre estas.
      - **LoginFeign**: Intefaz que define un cliente feign del microservicio login. En esta interfaz se declaran los métodos que vayan a ser necesarios para obtener información del microservicio login.
  - **ActiviyApplication**: Clase principal de la aplición, es la que inicia el programa.

<br>
<br>


### Microservicio Login:<br>
Este microservicio se encarga de realizar las operaciones que tengan que ver con la **creación/modificación de usuarios** y 
está organizado en las siguientes carpetas y clases:<br>

<img src="./img/arbolLogin.jpg" align="right" />


- **OrganizeIt**: Carpeta que contiene todo el proyecto.
  - **login**: Carpeta que se usa para separar la clase ActivityApplication del resto del proyecto.
    - **config**
      - **Configuration**: Clase que define la configuración de beans.
    - **controller**
      - **constant**
        - **EndPointUris**: Clase en la que se definen las constantes que se van a usar para el mapeo de los puntos de entrada.
      - **impl**
        - **LoginController**: Clase que implementa a la interfaz LoginApi y define los métodos de esta.
      - **LoginApi**: Interfaz en la que se definen los puntos de entrada a la aplicación.
    - **model**
      - **dto**
        - **UserDTO**: Clase se evía cuando se consume este microservicio.
      - **User**: Clase que se almacena en la base de datos.
    - **repository**
      - **LoginRepository**: Interfaz que extiende a MongoRepository y con la que se manejan los documentos de la clase User.
    - **service**
      - **impl**
        - **LoginServiceImpl** Clase que implementa a la interfaz LoginService y define los métodos de esta.
      - **util**
        - **Converter**: Clase en la que se definen los métodos necesarios para la conversion entre clases. 
      - **LoginService**: Interfaz que funciona entre el controlador y el repositorio encargandose de procesar los datos que viajan entre estas.
  - **LoginApplication**: Clase principal de la aplición, es la que inicia el programa.

<br>
<br>
<br>


## Caso de Uso: Crear actividad:

El usuario crea una actividad en la interfaz de react, la actividad es envida al microservicio **activity** que la almacena
en la base de datos de MongoDB.


### Interfaz de react.

<img src="./img/react/newactivity.jpg" />



#### ActivityApi.java

<code>@PostMapping("/new")
ResponseEntity newActivity (@RequestBody(required = false) ActivityDTOStringed activityDTOStringed);</code>

Se crea un punto de entrada en el que se recibirá un objeto ActivityDTOStringed y devolvera una respuesta http usando ResponseEntity.
Se usa la propiedad **requiered=false** para permitir objetos de la clase ActivityDTOStringed con el atributo id vacío.


### ActivityController.java

<code>public ResponseEntity newActivity(ActivityDTOStringed activityDTOStringed) {
        return as.newActivity(Converter.converActivityDtoStringedToActivity(activityDTOStringed));
    }</code>
    
El objeto ActivityDTOStringed que se recive, se convierte a un objeto de la clase Activity usando la clase Converter, y se pasa
al método **newActivity** de la clase ActivityService que devolverá un objeto ResponseEntity.


### ActivityServiceImpl.java

<code>public ResponseEntity newActivity(Activity activity) {
    return ResponseEntity.ok(activiyRepository.insert(activity));
}</code>

Se inserta el objeto en la base de datos usando la clase ActivityRepository, y se devuelve el resultado de esta operación encapsulado
en un objeto de ResponseEntity con un mensaje de estado Http 200.








<br>
<br>
<br>


## Caso de Uso: Ver actividades relacionadas a un usuario.

El sistema muestra al usuario una lista de actividades relacionadas con él, actividades a las que el usuario asista, haya sido invitado, o
de las que él sea creador. Para implementar esta funcionalidad, react realiza 3 peticiones al microservicio activity enviando el email
del usuario que está identificado en el sistema, cada una de estas peticiones tiene como respuesta las distintas listas de actividades
que la interfaz mostrará.


### Interfaz de react.

<img src="./img/react/myactivities.jpg" />



#### ActivityApi.java

<code>@GetMapping(EndPointUris.GetByUserInvited)
ResponseEntity<List<Activity>> getActivityByUserIsInvited (@PathVariable("email") String email);</code>

Crea un punto de entrada en el que el microservicio recibe el email de un usuario y devuelve una lista con las actividades en las que
ha sido invitado. El email que recibe lo pasa al método **findByUserIsInvited** de la la interfaz ActivityService que se encargará de devolver la lista de
actividades.

<code>@GetMapping(EndPointUris.GetByUserAssists)
ResponseEntity<List<Activity>> getActivityByUserAssist (@PathVariable("email") String email);</code>

Crea un punto de entrada en el que el microservicio recibe el email de un usuario y devuelve una lista con las actividades a las que
el usuario asiste. El email que recibe lo pasa al método **findByUserAssist** de la la interfaz ActivityService que se encargará de devolver la lista de
actividades.

<code>@GetMapping(EndPointUris.GetByUserIsCreator)
ResponseEntity<List<Activity>> getActivityByUserIsCreator (@PathVariable("email") String email);</code>

Crea un punto de entrada en el que el microservicio recibe el email de un usuario y devuelve una lista con las actividades en las que
el usuario es creador. El email que recibe lo pasa al método **findByUserIsCreator** de la la interfaz ActivityService que se encargará de devolver la lista de
actividades.



### ActivityServiceImpl.java

<code>public ResponseEntity<List<Activity>> findByUserAsisst(String email) {
   return ResponseEntity.ok(activiyRepository.findByUsuariosContaining(email));
}</code>

Usa la intefaz ActivityRepository para buscar en la base de datos las actividades que tengan el email recibido por parámetro en la lista
de usuarios que son asistentes, y devuelve el resultado de la operación encapsulado en un objeto de ResponseEntity con un mensaje de estado
Http 200.


<code>public ResponseEntity<List<Activity>> findByUserIsCreator(String email) {
    return ResponseEntity.ok(activiyRepository.findActivityByCreador(email));
}</code>

Usa la intefaz ActivityRepository para buscar en la base de datos las actividades en las que el email sea el valor del atributo creador,
y devuelve el resultado de la operación encapsulado en un objeto de ResponseEntity con un mensaje de estado
Http 200.


<code>public ResponseEntity<List<Activity>> findByUserIsIvited(String email) {
    return ResponseEntity.ok(activiyRepository.findByUsuariosInvitadosContaining(email));
}</code>

Usa la intefaz ActivityRepository para buscar en la base de datos las actividades que tengan el email recibido por parámetro en la lista
de usuarios que han sido invitados, y devuelve el resultado de la operación encapsulado en un objeto de ResponseEntity con un mensaje de estado
Http 200.








<br>
<br>
<br>


## Caso de Uso: Ver detalles de una actividad.

El usuario clica sobre la miniatura de una actividad, y el sistema muestra la actividad con todos sus datos. Para implementar esta funcionalidad
la interfaz envía al microservicio activity el id de la actividad que desea mostrar y este le devuelve los datos completos de la actividad.


### Interfaz de react.

<img src="./img/react/activity.jpg" />



#### ActivityApi.java

@GetMapping(EndPointUris.GetById)
ResponseEntity<ActivityDTO> getActivityById (@PathVariable("id") String id);

Se crea un punto de entrada al microservicio para recibir una petición con el id de una actividad, a esta petición se le responde devolviendo
un objeto ActivityDTO recuperado de la base de datos usando el id recibido. Para obtener el objeto ActivityDTO, se le pasa el id al 
método **getActivityById** que devolverá un objeto ActivityDTO.


### ActivityServiceImpl.java

<code>public ResponseEntity<ActivityDTO> getActivityById(String id) {
  Activity activityTmp = activiyRepository.findById(id).get();

  List<UserDTO> usersDTO = Arrays.asList(
    Objects.requireNonNull(loginFeign.getActivityUsers(activityTmp.getUsuarios())));

return ResponseEntity.ok(Converter.convertActivityToActivityDTO(activityTmp,usersDTO));
}</code>

Para recuperar la actividad de la base de datos, se usa la intefaz ActivityRepository con el método **findById**, que nos devolverá un objeto
Activity. Una vez tenemos el objeto de la clase Activity hay que convertirlo a ActivityDTO, para ello necesitamos una lista de objetos UserDTO.
Esta lista son los usuarios que asisten a la actividad, que, en la clase Activity se guarda tan sólo el email de los usuarios, pero la interfaz
necesita conocer también el nombre de cada uno. Para generar esta lista se llama al microservicio **login**, usando el endpoint **/user** y pasándole
el array con los emails de los usuarios, este devolverá un array con los objetos UserDTO que cree por cada email.
Para la llamada al microservicio se usa un cliente **feign**. Feign nos permite realizar llamadas a microservicios usando su id en lugar de
su dirección ip, para ello feign pregunta al servicio eureka por la dirección ip de un servicio con ese id, y este le devuelve la dirección
que tenga registrada.

El cliente feign se crea a partir de una interfaz y utilizando la anotación **@FeignClient()** y entre los paréntesis **name = 'id del servicio'**, y 
ya en el cuerpo de la interfaz se definen los métodos que se vayan a usar. Los métodos se definen especificando el endpoint con la anotación **@GetMapping**, **@PostMapping**,
o cual sea el tipo de petición http, y definiendo los parámetros y el objeto que retorna el método.

<code>
@FeignClient(name = "login")
public interface LoginFeign {
    @GetMapping("/user")
    UserDTO[] getActivityUsers(@RequestBody List<String> users);
}</code>













