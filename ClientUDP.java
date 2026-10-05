import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("adresse=" + addr.getHostName());

            String s = "Hello World";
            byte[] data = s.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
            DatagramSocket sock = new DatagramSocket();
            sock.setSoTimeout(3000);   // sinon receive() bloque a l'infini si pas de serveur
            sock.send(packet);

            // Q2.3 : attente de la reponse
            DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);
            try {
                sock.receive(resp);
                System.out.println("Recu : " + new String(resp.getData(), 0, resp.getLength()));
            } catch (SocketTimeoutException e) {
                System.out.println("Pas de reponse (serveur absent ?)");
            }
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
