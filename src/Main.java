import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by systemdown on 25/12/16.
 */
public class Main {
    ServerSocket serverSocket;
    public static void main(String[] args){
        new Main().runServer();
    }

    public void runServer(){
        try {
            serverSocket = new ServerSocket(6544);

            acceptRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptRequest(){
        while(true){
            try {
                //System.out.println("request accepted");
                Socket s = serverSocket.accept();

                ConnectionHandler connectionHandler = new ConnectionHandler(s);
                connectionHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
