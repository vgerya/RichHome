package com.mype.richhome.persistence.dao;

import com.google.inject.Inject;
import com.mype.richhome.persistence.EntityManager;

/**
 * @author Vitaliy Gerya
 */
public class AbstractDaoImpl<T> implements AbstractDao<T> {
    @Inject
    private EntityManager entityManager;

    @Override
    public T load() {
        return null;  //TODO implement it
    }

    @Override
    public void save(final T entity) {
        //TODO implement it
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
