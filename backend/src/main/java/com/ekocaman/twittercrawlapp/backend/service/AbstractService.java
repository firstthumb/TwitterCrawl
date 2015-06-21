package com.ekocaman.twittercrawlapp.backend.service;

import com.googlecode.objectify.Key;

import java.util.List;
import java.util.Map;

import static com.ekocaman.twittercrawlapp.backend.OfyService.ofy;

public abstract class AbstractService<T> {
    private final Class<T> typeParameterClass;

    public AbstractService(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public Key<T> save(T entity) {
        Key<T> key = ofy().save().entity(entity).now();
        return key;
    }

    public Map<Key<T>, T> saveAll(T... entities) {
        Map<Key<T>, T> keys = ofy().save().entities(entities).now();
        return keys;
    }

    public void delete(Key<T> key) {
        ofy().delete().key(key).now();
    }

    public void delete(T entity) {
        ofy().delete().entity(entity).now();
    }

    public void deleteAll(T... entities) {
        ofy().delete().entities(entities).now();
    }

    public T find(Key<T> key) {
        T entity = ofy().load().key(key).safe();
        return entity;
    }

    public T findById(Long id) {
        T entity = ofy().load().type(typeParameterClass).id(id).safe();
        return entity;
    }

    public T findById(String id) {
        T entity = ofy().load().type(typeParameterClass).id(id).safe();
        return entity;
    }

    public List<T> findAll() {
        return ofy().load().type(typeParameterClass).list();
    }
}
