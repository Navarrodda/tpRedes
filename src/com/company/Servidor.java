package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

        InetAddress address;


        ServerSocket servidor = null;

        //Acceso al recurso compartido
        Chat chat = new Chat();

        //Manejo de Clientes
        Integer numClient = 1;
        Integer clientsCant = 6;

        int port = 3000;

        //MANEJO DE EXCEPCIONES DE INGRESO DE IP Y PUERTO VÁLIDOS


        //INICIO EL SERVIDOR
        try {
            //Comprobamos si la IP es válida, se puede reemplazar el InetAddress.getLocalHost().gerHostAddress() por la direccion.
            //Si ingresamos un direccion erronea en ese campo se dispara la excepcion Bind.
            address = InetAddress.getByName(getIPAddressIPv4("wlan"));


            //Creamos el socket del servidor
            servidor = new ServerSocket(port, 1, address);

            System.out.println("Servidor iniciado en el host : " + getIPAddressIPv4("wlan"));

        }catch (BindException be) {
            System.err.println("No puedo encontrar la dirección IP : " + be);

        }catch (UnknownHostException uhe) {
            System.err.println("No puedo encontrar la dirección IP : " + uhe);

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }


        //ESPERO A LOS CLIENTES E INICIO LA CONEXIÓN
        try{

            //Siempre estara escuchando peticiones
            while (true) {
                Socket sc = null;

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                if (numClient < clientsCant) {

                    Client client = new Client(sc, numClient, chat);

                    //INICIO LA CONEXIÓN CON EL CLIENTE EN UN HILO Y CONTINUO A LA ESPERA DE NUEVOS CLIENTES.
                    client.start();

                    numClient++;

                }
            }
        }catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static String getIPAddressIPv4(String id) {
        try {

            java.util.List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (intf.getName().contains(id)) {
                    List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                    for (InetAddress addr : addrs) {

                        if (!addr.isLoopbackAddress()) {
                            String sAddr = addr.getHostAddress();
                            if (addr instanceof Inet4Address) {
                                return sAddr;
                            }
                        }

                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}