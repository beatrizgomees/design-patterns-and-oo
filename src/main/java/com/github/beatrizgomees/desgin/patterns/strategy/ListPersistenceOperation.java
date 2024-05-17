package com.github.beatrizgomees.desgin.patterns.strategy;

import com.github.beatrizgomees.desgin.patterns.domain.CrudService;

import java.util.ArrayList;
import java.util.List;

public class ListPersistenceOperation<T> implements CrudService<T> {

    private final List<T> data = new ArrayList<>();

    @Override
    public T create(T t) {
        data.add(t);
        return t;

    }

    @Override
    public List<T> getAll() {
    return new ArrayList<>(data);
    }
}
