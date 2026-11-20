package labfinal1;

import java.io.*;  // read/write er jonno
import java.net.*; // ServerSocket, Socket er jonno

public class Server {

    public static void main(String[] args) {

        try {
            // port 1001 khulchi, client-er jonno wait korchhi
            ServerSocket serverSocket = new ServerSocket(1001);
            System.out.println("Server is waiting for client");

            // client connect korle ei socket pabo
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            // client theke data porar jonno
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // client-e reply pathanor jonno
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // client-er pathano name ar id porchi
            String name = in.readLine();
            String id = in.readLine();

            System.out.println("Name: " + name);
            System.out.println("Id: " + id);

            // reply pathalchi
            out.println("Server received: " + name + " (" + id + ")");

            // bondo korchi
            serverSocket.close();

        } catch (IOException e) {
            // error hole dekhabey
            e.printStackTrace();
        }
    }
}
