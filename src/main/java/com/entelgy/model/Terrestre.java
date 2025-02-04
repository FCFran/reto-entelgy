package com.entelgy.model;

import com.entelgy.enums.TipoAnimal;

public  class Terrestre extends Animal {
    public Terrestre(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public TipoAnimal getTipo() {
        return TipoAnimal.TERRESTRE;
    }

}