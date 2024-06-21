package ServerClientQA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";

        try (Socket clientSocket = new Socket(host, Server.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println(in.readLine());
            out.println("Client");
            System.out.println(in.readLine());
            out.println("yes");
            System.out.println(in.readLine());
            out.println("no");
            System.out.println(in.readLine());
            out.println("goodBye!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
