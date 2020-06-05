package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        Scanner sn = new Scanner (System.in);

        //puerto de nuestro servidor
        final int PUERTO = 3000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);

            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                //Le envio un mensaje
                out.writeUTF("Comience a escribir:");

                String mensaje = " ";

                while(mensaje != "x" || mensaje != "X" ){

                    //Leo el mensaje que me envia
                    mensaje = in.readLine();

                    out.writeUTF( "\fCliente:" +mensaje +"\f");
                    System.out.println("\nCliente:" +mensaje);

                    String enviar = sn.nextLine();

                    //Le envio un mensaje
                    out.writeUTF("\f Servidor:" + enviar +"\f");
                    System.out.println("\nServidor:" + enviar);
                }

                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");
            }


        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}