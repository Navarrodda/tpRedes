package com.company;

import java.net.Socket;
import java.util.Scanner;

public class Chat {//EL CLIENTE ENVIA E IMPRIME POR PANTALLA
    private boolean available = false;
    Scanner sn = new Scanner(System.in);

    public synchronized void readClient (String mesaje, Integer number, Socket sc){//LO QUE MANDA EL CLIENTE
        while (available) {

            try{
                wait();
            }catch (InterruptedException e) {
                System.out.println("Se ha perdido la conexión con el Cliente "+ number );
            }
        }

        if(sc == null) {

            System.out.println("El Cliente " + number + " a enviado: " + mesaje);
            available = true;

        }
        else{
            if(sc.isClosed()){
                System.out.println("Cliente "+ number +" a finalizado la transmisión");
                available = true;
            }
            else{
                System.out.println("\t");
                System.out.println("Cliente "+ number + ":");
                System.out.println('\t' + "LocalPort " + sc.getLocalPort());
                System.out.println('\t' + "Port " + sc.getPort());
                System.out.println('\t' + "LocalSocketAddress " + sc.getLocalSocketAddress());
                available = false;
            }
        }

        notifyAll();
    }

    public synchronized String readServer(Integer numero ){

        while (!available) {

            try{
                wait();
            }catch (InterruptedException e) {
                System.out.println("Se ha perdido la conexión con el Cliente "+ numero );
            }
        }

        //Le aviso al Servidor que escriba
        System.out.println("Escriba un mensaje para el Cliente "+ numero  +" :");

        String mesaje = sn.nextLine();

        System.out.println("\nEscribiste un mensaje al Cliente "+ numero  +" :" + mesaje);

        available = false;
        notifyAll();

        return mesaje;
    }

    public void setAvailable(Boolean bool){
        this.available = bool;
    }
}
