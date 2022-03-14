package org.acme.resource;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.models.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/users/list")
@ApplicationScoped
public class UsersResource {

    private static final Logger LOG = LoggerFactory.getLogger(UsersResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {

        LOG.info("list");

        List<String> userList = new ArrayList<>();

        User.listAll().forEach(user -> {
            LOG.info("user: " + user + "\n");
            userList.add(user.toString());
        });

        return Response.status(Response.Status.OK).entity(userList).build();

    }
}