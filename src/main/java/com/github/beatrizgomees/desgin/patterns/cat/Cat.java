package com.github.beatrizgomees.desgin.patterns.cat;

import com.github.beatrizgomees.desgin.patterns.domain.Animal;

public class Cat extends Animal {

    public Cat() {
        System.out.println("Você criou um gato");
    }


    @Override
    public void comer() {
        System.out.println("O gato está comendo");
    }

    @Override
    public void andar() {
        System.out.println("O gato está andando");
    }

    public void drinkMilk(){
        System.out.println("O gato está bebendo leite");

    }



}
