package com.github.beatrizgomees.desgin.patterns.domain;

import java.util.Objects;

public abstract class Animal {

    private Type type;
    private double weight;
    private double height;
    private String name;

    public Animal(Type type, double weight, double height, String name) {
        this.type = type;
        this.weight = weight;
        this.height = height;
        this.name = name;
    }

    public Animal() {
    }

    public void comer(){
        System.out.println("comendo...");
    }

    public void andar(){
        System.out.println("andar...");
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(weight, animal.weight) == 0 && Double.compare(height, animal.height) == 0 && type == animal.type && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, height, name);
    }
}
