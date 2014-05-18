package com.hervedarritchon.rpg.services;

import com.hervedarritchon.rpg.mongo_consumer.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        String output = "";
        int returnCode=404;
        try {
            output = user.toString();
            log.info("HTTP POST against Users Resource with {} as data.", output);
            returnCode=200;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            output = e.getMessage();
            log.error("HTTP POST against Users Resource with error message {}.", output);
            returnCode=500;
        } finally {
            return Response.status(returnCode).entity(output).build();
        }
        // return Response.created(createdUri).build();
        //return Response.created(UriBuilder.fromResource(UserEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
    }

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public User addContact(
            final User user) {
        log.info("HTTP POST against Users Resource with {} as data.", user.toString());
        return user;
    }

    @PUT
    public Response updateUser(User user) {
        String output = "";
        try {
            output = user.toString();
            log.info("HTTP PUT against Users Resource with {} as data.", output);
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            output = e.getMessage();
            log.error("HTTP PUT against Users Resource with error message {}.", output);
        } finally {
            return Response.status(500).entity(output).build();
        }
        // return Response.created(createdUri).build();
        //return Response.created(UriBuilder.fromResource(UserEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
    }
}
