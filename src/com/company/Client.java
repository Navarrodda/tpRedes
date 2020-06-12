package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread{

    Socket sc;
    DataInputStream in;
    DataOutputStream out;
    Integer number;
    Chat rs;

    // InetAddress addr = InetAddress.getByName("127.0.0.1");
    // ServerSocket sock = new ServerSocket(3000, 50,addr);

    public Client(Socket sc, Integer number,  Chat rs) throws IOException {
        this.sc = sc;
        this.number = number;
        this.rs = rs;
    }

    public void run(){

        rs.readClient(null,number,sc);

        try {

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            String mesaje= " ";
            String send= " ";

            //Le aviso al cliente que escriba
            out.writeUTF("\fConectado como cliente: " + number);

            while (send.equals("x") == false && send.equals("X") == false) {

                out.writeUTF("\nEscriba una mensaje:");

                send = in.readLine();

                rs.readClient(send, number, null);

                out.writeUTF( "\f Escribiste: " + send + "\f");


                if (send.equals("x") == false && send.equals("X") == false) {

                    mesaje = rs.readServer(number);

                    out.writeUTF("\f Servidor a enviado un mensaje:" + mesaje + "\f");

                } else {
                    out.writeUTF("\f Hasta luego...");
                }
            }
        }  catch (IOException ex) {

        }

        //Cierro el socket
        try {
            sc.close();
            rs.setAvailable(false);
            rs.readClient(null,number,sc);
            rs.setAvailable(false);
        } catch (IOException e) {
            System.out.println("Se ha perdido la conexión con el Cliente "+ number );
        }

    }
}
