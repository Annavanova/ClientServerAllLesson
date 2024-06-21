package ServerClientQA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    protected static final Integer PORT = 8080;

    public static void main(String[] args) {

             System.out.println("Сервер стартовал");
            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(PORT);
                        Socket client = serverSocket.accept();
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ) {
                    out.println("Write your name?");
                    final String nameClient = in.readLine();
                    out.println(String.format("Hi %s! \n Are you child? (yes/no)", nameClient));
                    final String answerForChildren = in.readLine();
                    System.out.println(answerForChildren);
                    if(answerForChildren.equals("yes")){
                        out.println(String.format("Welcome to the kids area, %s! Let's play!",nameClient));
                    } else if (answerForChildren.equals("no")) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", nameClient));
                    } else if (answerForChildren.equals("goodBye")) {
                        serverSocket.close();
                    } else System.out.println("Error");

                }catch (IOException e) {
                    throw new RuntimeException(e);
            }
        }
    }
}
