package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread{

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Integer number;
    Chat chat;

    public Client(Socket sc, Integer number,  Chat chat) throws IOException {
        this.socket = sc;
        this.number = number;
        this.chat = chat;
    }

    public void run(){

        //PARA AVISARLE AL SERVIDOR QUE HAY UNA NUEVO CONEXIÓN DEBO ACCEDER AL RECURSO COMPARTIDO
        chat.readClient(null,number,socket);

        try {

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String mesaje= " ";
            String send= " ";

            //LE AVISO AL CLIENTE QUE ESTA CONECTADO CON EL SERVIDOR
            out.writeUTF("\fServidor en contrado \tConectado como cliente: " + number);

            //LA CONEXIÓN SE TERMINARA CUANDO EL CLIENTE ENVÍE "X"
            while (send.equals("x") == false && send.equals("X") == false && mesaje.equals("x") == false && mesaje.equals("X") == false ) {

                out.writeUTF("\nEscriba una mensaje:");

                send = in.readLine();

                chat.readClient(send, number, null);

                out.writeUTF( "\f Escribiste: " + send + "\f");


                if (send.equals("x") == false && send.equals("X") == false) {

                    mesaje = chat.readServer(number);

                    out.writeUTF("\f█ Servidor a enviado un mensaje:" + mesaje + " █\f");

                } else {
                    out.writeUTF("\f Hasta luego...");
                }
            }
        }  catch (IOException ex) {
            System.out.println("\n╔Se ha perdido la conexión con el Cliente "+ number + " o el");
        }

        //CIERRO EL SOCKET
        try {
            socket.close();

            chat.setAvailable(false);//EL CAMBIO DE VALOR A FALSE ES POR UN BUG QUE SUCEDE CUANDO UN CLIENTE SALE DEL
            // CHAT Y DEJA LA VARIABLE EN TRUE, POR LO QUE EL THREAD QUE QUIERA FINALIZAR LA CONEXION NO PODRA AVISARLE
            // AL SERVIDOR Y QUEDARA BLOQUEADO.

            chat.readClient(null, number, socket);

            chat.setAvailable(false);

        } catch (IOException e) {
            System.out.println("Se ha perdido la conexión fallo con el Cliente "+ number );
        }

    }
}
