package home.paul;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by paul on 28.02.16.
 */
@WebService
public interface MyService {
    @WebMethod
    String reverse(String value);
}
