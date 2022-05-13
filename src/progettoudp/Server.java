/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progettoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int porta = 2000;
        
        DatagramSocket ds;
        DatagramPacket dpi; //input
        DatagramPacket dpo; //output
        
        
        byte[] buffer;
        
        String msgIn, msgOut; //messaggio di input e messaggio di output
        try {
            ds = new DatagramSocket(porta);
            System.out.println("Server pronto!");
            while(true){ //ciclo infinito
                System.out.println("server in ascolto!!");
                buffer = new byte[256];
                dpi = new DatagramPacket(buffer,buffer.length);
                ds.receive(dpi);
                InetAddress cliIP = dpi.getAddress();
                int cliPort = dpi.getPort();
                msgIn = new String(dpi.getData(), 0, dpi.getLength());
                
                System.out.println("Sono il client" + cliIP + "e ho detto" + msgIn);
                
                
            }
              
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    }
    

