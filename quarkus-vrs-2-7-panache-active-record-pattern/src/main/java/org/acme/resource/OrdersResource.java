package org.acme.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.models.orders.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/orders/list")
public class OrdersResource {

    private static final Logger LOG = LoggerFactory.getLogger(OrdersResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {

        LOG.info("list");

        List<String> orderList = new ArrayList<>();

        Order.listAll().forEach(user -> {
            LOG.info("user: " + user + "\n");
            orderList.add(user.toString());
        });

        return Response.status(Response.Status.OK).entity(orderList).build();

    }
}