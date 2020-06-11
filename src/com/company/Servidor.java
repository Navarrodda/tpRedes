package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;


        Integer numCliente;

        //puerto de nuestro servidor
        final int PUERTO = 3000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);


            System.out.println("Servidor iniciado");

            numCliente = 1;

            //Siempre estara escuchando peticiones
            while (true) {
                Socket sc = null;

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                Cliente cliente = new Cliente(sc , numCliente);

                cliente.start();

                numCliente ++;
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}