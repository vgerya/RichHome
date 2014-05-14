package com.mype.richhome.persistence.dao;

/**
 * @author Vitaliy Gerya
 */
public interface AbstractDao<T> {
    T load();
    void save(T entity);
}
