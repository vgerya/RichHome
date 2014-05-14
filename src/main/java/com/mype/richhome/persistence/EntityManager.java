package com.mype.richhome.persistence;

import com.mype.richhome.persistence.entities.Envelope;

/**
 * @author Vitaliy Gerya
 */
public interface EntityManager {
    Envelope read();
    void write(Envelope envelope);
}
