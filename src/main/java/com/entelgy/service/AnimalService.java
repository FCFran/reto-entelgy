package com.entelgy.service;
import com.entelgy.model.Animal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalService {

    private List<Animal> animals;

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void imprimirAnimalesAgrupados() {
        if (animals == null || animals.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        Map<String, List<Animal>> agrupados = animals.stream()
                .collect(Collectors.groupingBy(animal -> animal.getTipo().name()));

        agrupados.forEach((tipo, lista) -> {
            System.out.println("Tipo: " + tipo);
            lista.forEach(animal -> System.out.println("- " + animal.getNombre() + " hace " + animal.getOnomatopeya()));
        });
    }
}
