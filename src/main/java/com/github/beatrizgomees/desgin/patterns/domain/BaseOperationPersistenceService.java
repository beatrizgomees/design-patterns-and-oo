package com.github.beatrizgomees.desgin.patterns.domain;

import java.util.List;

public class BaseOperationPersistenceService<T, ID>{
    private final CrudService<T> persistenceOperation;


    public BaseOperationPersistenceService(CrudService<T> persistenceOperation) {
        this.persistenceOperation = persistenceOperation;
    }


    public T create(T entity) {
        return persistenceOperation.create(entity);
    }

    public List<T> getAll() {
        return persistenceOperation.getAll();
    }
}
