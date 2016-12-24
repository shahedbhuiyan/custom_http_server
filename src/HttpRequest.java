/**
 * Created by systemdown on 25/12/16.
 */
public class HttpRequest {
    String filename;
    public HttpRequest(String request){
        String[] lines = request.split("\n");
        filename = lines[0].split(" ")[1];
        //System.out.println("FileName"+filename);
    }
}
