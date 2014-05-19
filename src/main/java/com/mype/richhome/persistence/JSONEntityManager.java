package com.mype.richhome.persistence;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.google.inject.Inject;
import com.mype.richhome.application.guice.Initializable;
import com.mype.richhome.persistence.entities.Envelope;
import com.mype.richhome.preferences.Preferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @author Vitaliy Gerya
 */
public class JSONEntityManager implements EntityManager, Initializable {
    private final static Logger logger = LoggerFactory.getLogger(JSONEntityManager.class);
    private static final String BUDGET_DIRECTORY_NAME = "RichHome";
    private final static String BUDGET_FILE_NAME = "budget.json";

    private volatile ReentrantReadWriteLock fileLock = new ReentrantReadWriteLock();


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
    public Envelope read() throws DataException {
        ReentrantReadWriteLock.ReadLock readLock = fileLock.readLock();
        try {
            readLock.lock();
            File dataDir = new File(preferences.getBudgetDirectory(), BUDGET_DIRECTORY_NAME);
            if (!dataDir.exists()) {
                throw new FileNotFoundException("Directory " + dataDir.getAbsolutePath() + " not found.");
            }
            File dataFile = new File(dataDir, BUDGET_FILE_NAME);
            if (!dataFile.exists()) {
                throw new FileNotFoundException("Directory " + dataDir.getAbsolutePath() + " not found.");
            }
            return mapper.readValue(dataFile, Envelope.class);
        } catch (JsonMappingException e) {
            throw new DataException(e);
        } catch (JsonParseException e) {
            throw new DataException(e);
        } catch (FileNotFoundException e) {
            throw new DataException(e);
        } catch (IOException e) {
            throw new DataException(e);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void write(final Envelope envelope) {
        //TODO implement it
    }

}
