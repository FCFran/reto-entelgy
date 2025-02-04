package com.entelgy;

import com.entelgy.enums.TipoAnimal;
import com.entelgy.model.*;
import com.entelgy.service.AnimalService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EntelgyApp {

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Debe proporcionar la ruta del archivo de animales como argumento");
            return;
        }

        String rutaArchivo = args[0];

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnimalService animalService = context.getBean("animalService", AnimalService.class);

        List<Animal> animales = leerAnimalesDesdeArchivo(rutaArchivo);
        animalService.setAnimals(animales);
        animalService.imprimirAnimalesAgrupados();

        context.close();


    }

    private static List<Animal> leerAnimalesDesdeArchivo(String rutaArchivo){
        List<Animal> animales = new ArrayList<>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas){
                String[] partes = linea.split("\\|");
                if (partes.length == 3){
                    Animal animal = instanciarAnimal(partes[0], partes[1], partes[2]);
                    if (animal != null){
                        animales.add(animal);
                    }
                }else {
                    System.out.println("Formato incorrecto en la linea: " + linea);
                }
            }

        }catch (IOException e){
            System.out.println("Error al Leer el archivo: " + e.getMessage());
        }
        return animales;
    }

    private static Animal instanciarAnimal(String nombre, String tipo, String onomatopeya){
        try{
            TipoAnimal tipoAnimal = TipoAnimal.valueOf(tipo.toUpperCase());
            return switch (tipoAnimal){
                case TERRESTRE -> determinarAnimalTerrestre(nombre, onomatopeya);
                case VOLADOR -> new Loro(nombre);
                case ACUATICO -> new Pez(nombre);
                default -> null;
            };

        }catch (IllegalArgumentException e){
            return null;
        }

    }

    private static Animal determinarAnimalTerrestre(String nombre, String onomatopeya) {
        if (onomatopeya.equals("guau")){
            return new Perro(nombre);
        } else if (onomatopeya.equals("miau")) {
            return new Gato(nombre);
        }
        return null;
    }
}
