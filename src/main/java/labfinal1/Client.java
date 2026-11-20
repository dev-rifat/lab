package labfinal1;

import java.io.*;  // read/write er jonno
import java.net.*; // Socket er jonno

public class Client {

    public static void main(String[] args) {
//clint thekhe just send
        try {
            // server er sathe connect korchi
            Socket socket = new Socket("localhost", 1001);
            System.out.println("Connected to server");

            // server theke data porar jonno
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // server-e data pathanor jonno
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // amar name ar id
            String name = "Lutfat Rahman";
            String id = "0272320005101051";

            // age name, por id pathalchi
            out.println(name);
            out.println(id);

            // server-er reply porchi
            System.out.println("Server: " + in.readLine());

            // connection bondo korchi
            socket.close();

        } catch (IOException e) {
            // problem hole error dekhabey
            e.printStackTrace();
        }
    }
}
