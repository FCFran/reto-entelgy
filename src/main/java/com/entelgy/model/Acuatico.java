package com.entelgy.model;

import com.entelgy.enums.TipoAnimal;

public abstract class Acuatico extends Animal {
    public Acuatico(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public TipoAnimal getTipo() {
        return TipoAnimal.ACUATICO;
    }


}
