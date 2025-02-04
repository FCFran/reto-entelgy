import com.entelgy.enums.TipoAnimal;
import com.entelgy.model.Gato;
import com.entelgy.model.Loro;
import com.entelgy.model.Perro;
import com.entelgy.model.Pez;
import com.entelgy.service.AnimalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AnimalTests {

    @Test
    void testCrearPerro(){
        Perro perro = new Perro("toby");
        Assertions.assertNotNull(perro);
        Assertions.assertEquals("toby", perro.getNombre());
        Assertions.assertEquals("guau", perro.getOnomatopeya());
        Assertions.assertEquals(TipoAnimal.TERRESTRE, perro.getTipo());
    }

    @Test
    void testLoro(){
        Loro loro = new Loro("Pepe");
        Assertions.assertNotNull(loro);
        Assertions.assertEquals("Pepe", loro.getNombre());
        Assertions.assertEquals("squawk", loro.getOnomatopeya());
        Assertions.assertEquals(TipoAnimal.VOLADOR, loro.getTipo());
    }

    @Test
    void testPez(){
        Pez pez = new Pez("Atun");
        Assertions.assertNotNull(pez);
        Assertions.assertEquals("Atun", pez.getNombre());
        Assertions.assertEquals("glup-glup", pez.getOnomatopeya());
        Assertions.assertEquals(TipoAnimal.ACUATICO, pez.getTipo());
    }

    @Test
    void testAgruparAnimalesPortipo(){
        AnimalService service = new AnimalService();
        service.setAnimals(Arrays.asList(
                new Perro("Toby"),
                new Gato("Garfield"),
                new Loro("Piolín"),
                new Pez("Nemo")
        ));

        assertFalse(service.getAnimals().isEmpty());
        assertEquals(4, service.getAnimals().size());
        assertEquals(TipoAnimal.TERRESTRE, service.getAnimals().get(0).getTipo());
        assertEquals(TipoAnimal.VOLADOR, service.getAnimals().get(2).getTipo());
        assertEquals(TipoAnimal.ACUATICO, service.getAnimals().get(3).getTipo());


    }

}
