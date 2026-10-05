import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        String msg = (args.length > 0) ? args[0] : "coucou";
        try {
            Socket socket = new Socket("localhost", 2016);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream dIn = new DataInputStream(socket.getInputStream());

            dOut.writeUTF(msg);
            dOut.flush();
            System.out.println("Envoye : " + msg);
            System.out.println("Recu   : " + dIn.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
