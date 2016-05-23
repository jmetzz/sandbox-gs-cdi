package com.github.jmetzz;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


/**
 * Created by Jean Metz.
 */

@Path("hello")
public class HelloWorldController {

    @GET
    public String sayHello(@QueryParam("name") String name) {
        String message = "Hello " + name;
        // do some logic here ...
        return "/WEB-INF/jsp/hello.jsp";
    }
}
