package com.company;

import java.net.Socket;
import java.util.Scanner;

public class Chat {//EL RECURSO COMPARTIDO ES LA POSIBILIDAD DE ESCRIBIR Y LEER POR PARTE DE LA CONSOLA DEL SERVIDOR

    private boolean available = false;
    Scanner sn = new Scanner(System.in);

    //ACCESO A ESCRIBIR EN LA CONSOLA DEL SERVIDOR
    public synchronized void readClient (String message, Integer number, Socket sc){//LO QUE MANDA EL CLIENTE

        while (available) {
            try{
                wait();
            }catch (InterruptedException e) {
                System.out.println("Se ha perdido la conexión con el Cliente "+ number );
            }
        }

        if(message != null ) {

            System.out.println("--El Cliente " + number + " a enviado: " + message );
            available = true;

        }
        else{
            if(sc.isClosed()){

                System.out.println("--Cliente "+ number +" a finalizado la transmisión .......");
                available = true;

            }
            else{

                System.out.println("\t╔═══════════════════════════════════════════════╗");
                System.out.println("\t║ Cliente "+ number + ":" + "                                    ║");
                System.out.println('\t' + "║ » LocalPort " + sc.getLocalPort() + "                              ║");
                System.out.println('\t' + "║ ▓ Port " + sc.getPort() + "                                  ║");
                System.out.println('\t' + "║ ▲ LocalSocketAddress"+ sc.getLocalSocketAddress());
                System.out.println("\t╚═══════════════════════════════════════════════╝");
                available = false;

            }
        }

        notifyAll();
    }

    //ACCESO A LEER DESDE LA CONSOLA DEL SERVIDOR
    public synchronized String readServer(Integer numero ){

        while (!available) {
            try{
                wait();
            }catch (InterruptedException e) {
                System.out.println("Se ha perdido la conexión con el Cliente "+ numero);
            }
        }

        //Le aviso al Servidor que escriba
        System.out.println("Escriba un mensaje para el Cliente "+ numero  +" :");

        String mesaje = sn.nextLine();

        System.out.println("\n--Escribiste un mensaje al Cliente "+ numero  +" :" + mesaje );

        available = false;
        notifyAll();

        return mesaje;
    }

    public void setAvailable(Boolean bool){
        this.available = bool;
    }
}
