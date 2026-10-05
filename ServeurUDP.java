import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket sock = new DatagramSocket(1234);
            while (true) {
                System.out.println("-Waiting data");
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                sock.receive(packet);
                // getLength() : evite d'afficher les 1024 octets du tampon
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println("str=" + str);

                // Q2.3 : renvoi de la chaine a l'expediteur
                byte[] rep = str.getBytes();
                DatagramPacket reply = new DatagramPacket(
                    rep, rep.length, packet.getAddress(), packet.getPort());
                sock.send(reply);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
