package com.helesto.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.helesto.repositories.users.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/users")
public class UsersResource {

    private static final Logger LOG = LoggerFactory.getLogger(UsersResource.class);

    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        LOG.info("Hello resouce");

        userRepository.findAll().forEach(user -> LOG.info("user: " + user + "\n"));

        return "hello";
    }
}