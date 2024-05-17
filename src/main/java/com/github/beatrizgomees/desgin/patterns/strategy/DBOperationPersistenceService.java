package com.github.beatrizgomees.desgin.patterns.strategy;

import com.github.beatrizgomees.desgin.patterns.domain.CrudService;

import java.util.ArrayList;
import java.util.List;

public class DBOperationPersistenceService<T> implements CrudService<T> {

    private final List<T> database = new ArrayList<>();


    @Override
    public T create(T t) {
    System.out.println("Implementado com a persistencia do banco de dados");
        database.add(t);
        return t;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(database);
    }
}
