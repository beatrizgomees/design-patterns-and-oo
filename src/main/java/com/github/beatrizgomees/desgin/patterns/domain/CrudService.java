package com.github.beatrizgomees.desgin.patterns.domain;

import java.util.List;

public interface CrudService<T> {

    T create(T t);

    List<T> getAll();
}
