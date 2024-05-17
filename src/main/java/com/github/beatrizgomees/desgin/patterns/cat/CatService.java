package com.github.beatrizgomees.desgin.patterns.cat;

import com.github.beatrizgomees.desgin.patterns.domain.BaseOperationPersistenceService;
import com.github.beatrizgomees.desgin.patterns.domain.CrudService;

public class CatService extends BaseOperationPersistenceService<Cat, Long> {

    public CatService(CrudService<Cat> persistenceOperation) {
        super(persistenceOperation);
    }
}
