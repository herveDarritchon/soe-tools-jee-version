package com.hervedarritchon.rpg.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Hervé Darritchon
 * Date: 09/05/2014
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public class SoeApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public SoeApplication() {
        final Logger log = LoggerFactory.getLogger(SoeApplication.class);

        log.info("SoeApplication registered.");
        register(RequestContextFilter.class);
        register(UserResource.class);
        log.debug("All resources registered.");
    }
}
