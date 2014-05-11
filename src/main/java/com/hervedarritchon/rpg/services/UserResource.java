package com.hervedarritchon.rpg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Hervé Darritchon
 * Date: 09/05/2014
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
@Path("/users")
public class UserResource {

    final Logger log = LoggerFactory.getLogger(UserResource.class);
    /*    @Autowired
    private GreetingService greetingService;
    //    @Autowired
    @Inject
    private DateTimeService timeService;*/

    public UserResource() {
        log.info("HelloWorldResource() called.");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        log.info("HTTP GET against Users Resource.");
        return String.format("%s: %s", "02/02/1978 - 23:45", "world");
    }
}
