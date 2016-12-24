import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by systemdown on 25/12/16.
 */
public class HttpResponse {
    HttpRequest httpRequest;
    String response;
    String root = "/home/systemdown/host_file";
    public HttpResponse(HttpRequest httpRequest){
        this.httpRequest = httpRequest;
        File file = new File(root + httpRequest.filename);
        System.out.println(httpRequest.filename);

        try {
            response = "HTTP/1.1 200 \r\n";
            response += "Server: Custom Java Server/1.0 \r\n";
            response += "Content-Type: text/html \r\n";
            response += "Content-Length: "+ file.length() +" \r\n";
            response += "\r\n";

            FileInputStream fileInputStream = new FileInputStream(file);
            int s;

            while((s = fileInputStream.read()) != -1){
                response += (char)s;
            }

        } catch (FileNotFoundException e) {
            response = response.replace("200","400");
        } catch (IOException e) {
            response = response.replace("200","500");
        }
    }
}

