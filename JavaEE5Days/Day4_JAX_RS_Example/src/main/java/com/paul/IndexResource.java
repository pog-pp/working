package com.paul;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by paul on 16.03.16.
 */
@Path("/")
public class IndexResource {
    @GET
    @Produces("text/plain")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public String sayHelloTo(@PathParam("name") String msg) {
        return "Hello " + msg +"!";
    }
}
