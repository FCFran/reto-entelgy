package com.entelgy.model;

import com.entelgy.enums.TipoAnimal;

public  class Volador extends Animal {
    public Volador(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public TipoAnimal getTipo() {
        return TipoAnimal.VOLADOR;
    }

}