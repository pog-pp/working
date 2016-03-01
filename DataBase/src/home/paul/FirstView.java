package home.paul;

/**
 * Created by paul on 28.02.16.
 */

import javax.jws.WebService;

@WebService(endpointInterface = "home.paul.MyService")
public class FirstView implements MyService {
    public String reverse(String value){
        if (value == null) return null;
        return new StringBuffer(value).reverse().toString();
    }
}
