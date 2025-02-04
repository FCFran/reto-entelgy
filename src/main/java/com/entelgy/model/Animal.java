package com.entelgy.model;

import com.entelgy.enums.TipoAnimal;

public abstract class Animal implements EspecieAnimal {
    private String nombre;
    private String onomatopeya;

    public Animal(String nombre, String onomatopeya) {
        this.nombre = nombre;
        this.onomatopeya = onomatopeya;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOnomatopeya() {
        return onomatopeya;
    }


    @Override
    public abstract TipoAnimal getTipo();
}
