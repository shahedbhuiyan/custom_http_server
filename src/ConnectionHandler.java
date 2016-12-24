import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by systemdown on 25/12/16.
 */
public class ConnectionHandler extends Thread{
    Socket socket;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    public ConnectionHandler(Socket s) throws IOException {
        this.socket = s;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {

            String req = "";

            while (bufferedReader.ready() || req.length() == 0) {
                req += (char) bufferedReader.read();
            }

            System.out.println(req);

            HttpRequest httpRequest = new HttpRequest(req);

            HttpResponse httpResponse = new HttpResponse(httpRequest);

            printWriter.write(httpResponse.response.toCharArray());

            printWriter.close();
            bufferedReader.close();
            socket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
