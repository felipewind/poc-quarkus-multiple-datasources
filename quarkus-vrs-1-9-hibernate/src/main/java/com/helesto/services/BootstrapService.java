package com.helesto.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class BootstrapService {

    private static final Logger LOG = LoggerFactory.getLogger(BootstrapService.class);

    void onStart(@Observes StartupEvent ev) {
        LOG.info("onStart");
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOG.info("onStop");
    }

}
