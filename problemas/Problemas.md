# Problemas encontrados durante el darrollo de proyecto.
<br>
<br>

## Subida de imágenes.
Me ha sido imposible conseguir subir una imágen desde la interfaz de react al microservicio activity, sin embargo, usando Postman para el envío del archivo,
funciona. No he conseguido averiguar qué fallaba entre otras cosas porque me estaba tomando demasiado tiempo y no avanzaba.

## Autoescalado en AWS
Cuando estaba planteando el despliegue de la aplicación en AWS, ví que AWS ofrecía un servicio para crear grupos de autoescalado a partir de una plantilla. Esta
plantilla, podía crearla a partir de una instancia EC2, así que decidí crear una instancia para cada microservicio y configurarlas para que funionase correctamente, 
y una vez había comprobado que todo funcionaba usando estas instancias de EC2, creé la primera plantilla sin problemas, la hice del microservicio activity, pero
al intentar crear el grupo de autoescalada, AWS me lanzó un mensaje de error indicando que el tipo de cuenta (AWS Educate) que estaba usando, no tenía derechos
para usar ese servicio. Así que el despliegue se ha quedado un poco a medias, ya que, se ha desplegado, pero usar ese tipo de instancias para un microservicio y
sin posibilidad de escalado, hace que las ventajas que podemos obtener con una arquitectura de microservicios se pierdan.

## Comunicación entre instancias.
Para la comunicación entre las instancias de AWS he tenido que usar algunas IPs elásticas, ya que usando la ip privada, no funcionaba correctamente. Me ha quedado
pendiente buscar el fallo, pero debería de tener solución ya que todas las instancias están corriendo en una misma red virtual. Por falta de tiempo no he podido
hacer más pruebas.


