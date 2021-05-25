package com.example.CourseWork.dao;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

class InMemoryAbstractDao<T> implements AbstractDao<T> {

    protected Map<Integer, T> entities;

    protected Function<T, Integer> idGetter;

    protected BiConsumer<T, Integer> idSetter;

    protected InMemoryDatabase database;

    public InMemoryAbstractDao(Map<Integer, T> entities,
                               Function<T, Integer> idGetter,
                               BiConsumer<T, Integer> idSetter,
                               InMemoryDatabase database) {
        this.entities = entities;
        this.idGetter = idGetter;
        this.idSetter = idSetter;
        this.database = database;
    }

    @Override
    public T get(Integer id) {
        return entities.get(id);
    }

    @Override
    public Collection<T> findAll() {
        return entities.values();
    }

    @Override
    public void insert(T entity, boolean genID) {
        if (genID) {
            int maxID = entities.keySet()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);
            idSetter.accept(entity, maxID + 1);}
        entities.put(idGetter.apply(entity), entity);
    }

    @Override
    public void delete(T entity) {
        entities.remove(idGetter.apply(entity));
    }

    @Override
    public void update(T entity) {
        entities.put(idGetter.apply(entity), entity);
    }
}
