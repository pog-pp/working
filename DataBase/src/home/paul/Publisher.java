package home.paul;
import javax.xml.ws.Endpoint;
/**
 * Created by paul on 28.02.16.
 */
public class Publisher {
    private static final String url = "http://localhost:8080/WS/MyService";
    public static void main(String[] args){
        Endpoint.publish(url,new FirstView());
    }
}
