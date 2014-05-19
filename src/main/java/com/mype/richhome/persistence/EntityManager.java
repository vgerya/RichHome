package com.mype.richhome.persistence;

import com.mype.richhome.persistence.entities.Envelope;

import java.io.FileNotFoundException;

/**
 * @author Vitaliy Gerya
 */
public interface EntityManager {
    Envelope read() throws FileNotFoundException;
    void write(Envelope envelope);
}
