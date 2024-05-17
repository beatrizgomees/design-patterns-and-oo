package com.github.beatrizgomees.desgin.patterns;


import com.github.beatrizgomees.desgin.patterns.cat.Cat;
import com.github.beatrizgomees.desgin.patterns.cat.CatService;
import com.github.beatrizgomees.desgin.patterns.domain.Type;
import com.github.beatrizgomees.desgin.patterns.strategy.DBOperationPersistenceService;
import com.github.beatrizgomees.desgin.patterns.strategy.ListPersistenceOperation;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ListPersistenceOperation<Cat> listPersistenceOperation = new ListPersistenceOperation<>();

        CatService catService = new CatService(listPersistenceOperation);
        System.out.println();
        System.out.println(" //PERSISTENCIA COM LISTA ================== ");
        Cat cat1 = new Cat();

        cat1.setName("Percy");
        cat1.setType(Type.TERRESTRE);
        cat1.setHeight(0.5);
        cat1.setWeight(1.0);


        catService.create(cat1);

        List<Cat> allCats = catService.getAll();
        allCats.forEach(cat -> {
            System.out.println(cat.getName());
            System.out.println(cat.getType());
            System.out.println(cat.getHeight());
            System.out.println(cat.getWeight());
        });


        //PERSISTENCIA COM BANCO DE DADOS
        System.out.println();
        System.out.println(" //PERSISTENCIA COM BANCO DE DADOS ================== ");

        DBOperationPersistenceService<Cat> dbOperationPersistenceService = new DBOperationPersistenceService<>();
        CatService catServiceDB = new CatService(dbOperationPersistenceService);


        Cat cat1DB = new Cat();

        cat1DB.setName("ANNABETH");
        cat1DB.setType(Type.AQUATICO);
        cat1DB.setHeight(0.5);
        cat1DB.setWeight(1.0);

        catServiceDB.create(cat1DB);

        List<Cat> allCatsDB = catServiceDB.getAll();
        allCatsDB.forEach(cat -> {
            System.out.println(cat.getName());
            System.out.println(cat.getType());
        });



    }
}