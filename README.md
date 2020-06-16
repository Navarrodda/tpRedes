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
Los endpoints son las URLs de un API o un backend que responden a una petición. Los mismos entrypoints tienen que calzar con un endpoint para existir. Algo debe responder para que se renderice un sitio con sentido para el visitante. Por cada entrypoint esperando la visita de un usuario puede haber docenas de endpoints sirviendo los datos para llenar cada gráfico e infografía que se despliega en el entrypoint. Se asume que cuando se habla de un endpoint estamos en un entorno RESTful, por lo cual (a diferencia del uso de un browser), el cliente puede usar un mismo endpoint con distintos verbos. Un endpoints esta formado por un grupo o familia de propiedades de direccionamiento de mensajes y da características de extremo a extremo de mensajes, como las referencias de la fuente y el destino de los criterios de valoración, así como la identidad de los mensajes para permitir el uniforme direccionamiento de mensajes "Independientes". 

3. ¿Que es un socket? 
-Un socket (enchufe), es un método para la comunicación entre un programa del cliente y un programa del servidor en una red. Un socket se define como el punto final en una conexión. Un socket es conocido como un tipo de software que actúa como un punto final que funciona estableciendo un enlace de comunicación de red bidireccional entre el extremo del servidor y el programa receptor del cliente. Los sockets se crean y se utilizan con un sistema de peticiones o de llamadas de función a veces llamados interfaz de programación de aplicación de sockets (API, application programming interface). Un socket es capaz de simplificar el funcionamiento de un programa porque los programadores ahora sólo tienen que preocuparse de manipular las funciones del socket y esto les permite confiar en el sistema operativo para transportar los mensajes a través de la red correctamente.
-Un socket es también una dirección de Internet, combinando una dirección IP (la dirección numérica única de cuatro partes que identifica a un ordenador particular en Internet) y un número de puerto (el número que identifica una aplicación de Internet particular, como FTP, Gopher, o WWW).

4. ¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Porque? 
La comunicación mediante sockets es una interfaz (o servicio) con la capa de transporte (nivel 4) de la jerarquía OSI y en el modelo TCP/IP. La filosofía de la división por capas de un sistema es encapsular, dentro de cada una de ellas, detalles que conciernen sólo a cada capa, y presentársela al usuario de tal forma que este pueda trabajar con ella sin necesidad de conocer sus detalles de implementación.

5. ¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets? 
-Por el lado del Servidor:
1° Socket: Creación del socket.
2° Bind: ¿Qué puerto usa?
3° Listen: Encolar petición.
4° Accept (o paso directo al paso 7° y finaliza ): Espera conexión.
5° Recv/Read (o paso directo/intercambio al paso 6° ): Recibe petición.
6° Send/Write : Sirve petición.
7° Close: Cierra conexión.
-Por el lado del Cliente:
1° Socket: Creación del socket.
2° Connect: Conecta con servidor.
3° Send/Write (o paso directo/intercambio al paso 4°): Pide Servicio.
4° Recv/Read: Recibe respuesta.
5° Close: Cierra conexión.

6. ¿Cuales son las causas comunes por la que la conexión entre cliente/servidor falle? 
En este esquema la capa de transporte se encarga de los fallos en comunicaciones, sin embargo si se usan datagramas en vez de paquetes, es la aplicación la que tendrá que encargarse de ordenar  dichos datagramas fuera de secuencia, solicitar su retransmisión y/o restablecer los enlaces. La capa de transporte por sí misma otorga el concepto de Calidad en el Servicio, (QoS) pero no es una solución definitiva para todos los casos.
Los fallos mas comunes son:
-Fallo crash: El servidor de detiene, pero estaba operando correctamente.
-Fallo por omisión: Un servidor falla en responder a las peticiones.
-Omision de recibido: El servidor falla en recibir mensajes.
-Omision de envío: El servidor falla en mandar mensajes.
-Fallo de tiempo: L arespuesta del servidor no esta en el onervalo de tiempo especificaddo.
-Fallo de respuesta: La respuesta del servidor es incorrecta.
-Fallo de valor: El valor de la respuesta es incorrecto.
-Fallo de estado de transición: El servidor se desvía del flujo de control.
-Fallo arbitrario: El servidor produce fallos arbitrarios en tiempos indefinidos.


7. Diferencias entre sockets UDP y TCP 
La principal diferencia entre ambos es:
» El UDP necesita que le entregemos paquetes de datos que el usuario debe construir. Envía los datos directamente al ordenador de destino sin verificar si el sistema esta listo para recibir o no. Más rápido, no confiable.
» El TCP admite bloques de datos (cuyo tamaño puede ir desde 1 bytes hasta muchos K bytes, dependiendo de la implementación) que serán empaquetados de forma transparente antes de ser transmitidos. Establece la coneccion entre los ordenadores antes de transmitir los datos. Lento, confiable.
■ Otra diferencia importante. Tanto los paquetes de datos UDP como los segmentos TCP pueden perderse. Si un paquete se pierde el UDP no hace nada. Por el contrario, si un segmento se pierde el TCP lo retransmitirá, y este proceso durará hasta que el segmento ha sido correctamente entregado al host receptor, o se produzca un número máximo de retransmisiones.

8. Diferencia entre sync & async sockets?
Nos estamos refiriendo a dos formas de intercambio de la información en función de la simultaneidad con la que se envía y ofrece el mensaje.
■ La comunicación sincrónica es aquella “en la que los usuarios, a través de una red telemática, coinciden en el tiempo y se comunican entre sí mediante texto, audio y/o vídeo”. Programación secuencial donde las llamadas Accept() (petición de conexión de un cliente) y Recv() (recepción de datos) son bloqueantes. Similar a una conversación telefónica.
■En la asincrónica, “se utilizan el sistema de comunicación en tiempos diferentes”.  Las llamadas NO son bloqueantes y la programación es mediante eventos o señales. Similar a interrupciones.
---Necesario disponer de algún tipo de mecanismo para tratar la comunicación asíncrona: EVENTOS por notificación de mensajes.

»Las comunicaciones asincrónicas no esperan una respuesta, la ejecución síncrona requiere que las partes o los componentes funcionen simultáneamente en tiempo real”.

Las transmisiones TCP son asincronas, al utilizar este protocolo en conjunto con sockets logramos un modelo orientado a la conexión.
