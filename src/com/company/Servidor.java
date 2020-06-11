package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

       // ServerSocket servidor = null;

        Integer numCliente;

        //puerto de nuestro servidor
        final int PUERTO = 3000;

        try {
            //Creamos el socket del servidor
            InetAddress addr = InetAddress.getByName("192.168.0.47");
            ServerSocket servidor = new ServerSocket(3000, 50,addr);

           // servidor = new ServerSocket(PUERTO);

            System.out.println("Servidor iniciado");
            numCliente = 1;

            //Siempre estara escuchando peticiones
            while (true) {

                Socket sc = null;

                //Espero a que un cliente se conecte
                sc = servidor.accept();
                if(numCliente < 6){
                    Cliente cliente = new Cliente(sc, numCliente);

                    cliente.start();
                    numCliente++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}