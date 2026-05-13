package edu.teamrocket;

import org.junit.jupiter.api.Test;
import edu.teamrocket.domain.Sulfuras;
import static org.junit.jupiter.api.Assertions.*;

class SulfurasTest {

    @Test
    void crearSulfuras() {

        Sulfuras sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras.getName());
        assertEquals(0, sulfuras.getSellIn(), 0);
        assertEquals(80, sulfuras.getQuality(), 0);
    }

    @Test
    void toStringTest() {
        Sulfuras sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
        System.out.println("Sulfuras toString() test");
        System.out.println(sulfuras.toString());
    }

    @Test
    void updateQualitySulfuras() {

        Sulfuras sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
        sulfuras.updateQuality();
        assertEquals(0, sulfuras.getSellIn(), 0);
        assertEquals(80, sulfuras.getQuality(), 0);
    }
}
