# Despliegue de la aplicación.

Tal y como se detalla en el apartado ***tecnologías a desarrollar***, el proyecto tiene como uno de sus objetivos realizar el
despliegue de la aplicación haciendo uso de los **amazon web services**, y es en este documento donde veremos como se ha llevado
a cabo ese proceso.



## Despliegue de los microservicios

Todos los microservicios han sido desplegados en instancias de ubuntu 18.04, a las que se le ha instalado el paquete **openjdk-8-jre-headless**,
a cada una de estas instancias se les ha transferido con SCP los ficheros jar construidos en Intellij, con el comando
<code>scp -i "clave" fichero.jar usuario@maquina:fichero</code>, y se ha programado la ejecución de cada
uno de los jar para que arranquen al mismo tiempo que se inicia la instancia. Para automatizar este proceso, se ha creado un
script llamado startapp.sh en la carpeta /etc/init.d/ con este codigo: <br>

<code>#!/bin/bash
java -jar 'direccion del fichero .jar'
</code>

<br>
Y una vez creado el script, se configura cron en la máquina para ejecutarlo al inicio. Esto se hace ejecutando 'crontab -e',
con esto podremos editar el fichero de configuración crontab. Para añadir el script y que se ejecute al iniciar la máquina
se añade una línea como la siguiente:
<br>

<code>@reboot /etc/init.d/startapp.sh</code>

Por último se modifican los permisos del script para que cron lo ejecute sin problemas.

<code>  sudo chmod +x /etc/init.d/startapp.sh</code>
<br>
<br>


## Despliegue de la interfaz en react.


## Despliegue de MongoDB
