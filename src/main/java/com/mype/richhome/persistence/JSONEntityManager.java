package com.mype.richhome.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.google.inject.Inject;
import com.mype.richhome.application.guice.Initializable;
import com.mype.richhome.persistence.entities.Envelope;
import com.mype.richhome.preferences.Preferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Vitaliy Gerya
 */
public class JSONEntityManager implements EntityManager, Initializable {
    private final static Logger logger = LoggerFactory.getLogger(JSONEntityManager.class);

    @Inject
    private Preferences preferences;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() {
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        mapper.registerModule(module);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        logger.info("EntityManager has been initialized.");
    }

    @Override
    public Envelope read() {
        return null;  //TODO implement it
    }

    @Override
    public void write(final Envelope envelope) {
        //TODO implement it
    }

}
