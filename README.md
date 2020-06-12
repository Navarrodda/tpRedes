# tpRedes

Trabajo practico de Redes

Integrantes:
» Latorre, Ariana Guillermina.
» Navarro David.

Preguntas: 
1. ¿Que es un puerto? 
Un puerto es una interfaz a través de la cual se pueden enviar y recibir los diferentes tipos de datos.
-La interfaz puede ser de tipo física (hardware) o puede ser a nivel lógico o de software, en cuyo caso se usa frecuentemente el término puerto lógico
-Se denomina “puerto lógico” a una zona o localización de la memoria de acceso aleatorio (RAM) de la computadora que se asocia con un puerto físico o un canal de comunicación, y que proporciona un espacio para el almacenamiento temporal de la información que se va a transferir entre la localización de memoria y el canal de comunicación. 

2. ¿Como estan formados los endpoints? 
Un endpoints esta formado por un grupo o familia de propiedades de direccionamiento de mensajes y da características de extremo a extremo de mensajes, como las referencias de la fuente y el destino de los criterios de valoración, así como la identidad de los mensajes para permitir el uniforme direccionamiento de mensajes "Independientes".

3. ¿Que es un socket? 
Un socket es un tipo de software que actúa como un punto final que funciona estableciendo un enlace de comunicación de red bidireccional entre el extremo del servidor y el programa receptor del cliente. También se le conoce como un punto final en un canal de comunicación bidireccional.

4. ¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Porque? 
Pertenese a la capa 4 la de "Transporte", A la 3 de "Red" y a la capa 2 "Vínculo de datos". Porque en ella se transportan los datos que enviamos y resivimos a traves de la red que vincula los datos en ese sockets.

5. ¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets? 
~ El TCP/IP y los sockets permiten la comunicación entre dos aplicaciones de forma local o remota.
~ Se usa el protocolo TCP del protocolo TCP/IP, para gestionar la conexipara.
~ El modelo Cliente-Servidor define la estructura de las aplicaciones comunicantes y su sincronización

6. ¿Cuales son las causas comunes por la que la conexión entre cliente/servidor falle? 
-Que el servidor termine la ejecución del proceso principal antes de que los clientes se desconecten.
-Si la dirección IP de la máquina servidor está configurada a una dinámica, esto puede causar problemas de conexión entre el servidor y el cliente, se recomienda usar una IP fija.
-Que el Cliente interrumpa su coenxión antes de enviar un mensaje, y el mismo no llegue al Servidor, solo la excepcion.

7. Diferencias entre sockets UDP y TCP 
La principal diferencia entre ambos es:
» El UDP necesita que le entregemos paquetes de datos que el usuario debe construir
» El TCP admite bloques de datos (cuyo tamaño puede ir desde 1 bytes hasta muchos K bytes, dependiendo de la implementación) que serán empaquetados de forma transparente antes de ser transmitidos.
■ Otra diferencia importante. Tanto los paquetes de datos UDP como los segmentos TCP pueden perderse. Si un paquete se pierde el UDP no hace nada. Por el contrario, si un segmento se pierde el TCP lo retransmitirá, y este proceso durará hasta que el segmento ha sido correctamente entregado al host receptor, o se produzca un número máximo de retransmisiones.

8. Diferencia entre sync & async sockets?
Nos estamos refiriendo a dos formas de intercambio de la información en función de la simultaneidad con la que se envía y ofrece el mensaje.

■ La comunicación sincrónica es aquella “en la que los usuarios, a través de una red telemática, coinciden en el tiempo y se comunican entre sí mediante texto, audio y/o vídeo”
■En la asincrónica, “se utilizan el sistema de comunicación en tiempos diferentes”

»Las comunicaciones asincrónicas no esperan una respuesta, la ejecución síncrona requiere que las partes o los componentes funcionen simultáneamente en tiempo real”.
