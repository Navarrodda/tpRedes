package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{
    Socket sc;
    DataInputStream in;
    DataOutputStream out;
    Integer numero;
    Scanner sn = new Scanner(System.in);
   // InetAddress addr = InetAddress.getByName("127.0.0.1");
   // ServerSocket sock = new ServerSocket(3000, 50,addr);

    public Cliente(Socket sc, Integer numero) throws IOException {
        this.sc = sc;
        this.numero = numero;
    }

    public void run(){
        System.out.println("Cliente "+ numero +" conectado: " + sc);

        try {

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            String mensaje = " ";
            String enviar = " ";

            while (mensaje.equals("x") == false && mensaje.equals("X") == false) {

                //Le aviso al cliente que escriba
                out.writeUTF("Escriba una mensaje:");

                //Leo el mensaje que me envia
                mensaje = in.readLine();

                out.writeUTF("\fCliente " + numero + ":" + mensaje + "\f");
                System.out.println("\nCliente " + numero + ":" + mensaje);

                if (mensaje.equals("x") == false && mensaje.equals("X") == false) {

                    //Le aviso al Servidor que escriba
                    System.out.println("Escriba un mensaje:");

                    enviar = sn.nextLine();

                    //Le envio un mensaje
                    out.writeUTF("\f Servidor:" + enviar + "\f");
                    System.out.println("\nServidor:" + enviar);
                } else {
                    out.writeUTF("\f Hasta luego...");
                }
            }
        }  catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cierro el socket
        try {
            sc.close();
            System.out.println("Cliente "+ numero +" desconectado");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
