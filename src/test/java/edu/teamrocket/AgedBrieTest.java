package edu.teamrocket;

import org.junit.jupiter.api.Test;
import edu.teamrocket.domain.AgedBrie;
import static org.junit.jupiter.api.Assertions.*;

public class AgedBrieTest {

    @Test
    void crearAgedBrie() {

        AgedBrie cheese = new AgedBrie("Aged Brie", 2, 0);
        assertEquals("Aged Brie", cheese.getName());
        assertEquals(0, cheese.getSellIn(), 0);
        assertEquals(2, cheese.getQuality(), 0);
    }

    @Test
    void toStringTest() {
        AgedBrie cheese = new AgedBrie("Aged Brie", 2, 0);
        String result = cheese.toString();
        assertNotNull(result);
        assertTrue(result.contains("Aged Brie"));
    }

    @Test
    void updateQualityBrie() {

        AgedBrie cheese = new AgedBrie("Aged Brie", 2, 1);
        cheese.updateQuality();
        assertEquals(0, cheese.getSellIn(), 0);
        assertEquals(3, cheese.getQuality(), 0);
    }

    @Test
    void updateQualityBrieExpired() {

        AgedBrie cheese = new AgedBrie("Aged Brie", 0, 0);
        cheese.updateQuality();
        assertEquals(-1, cheese.getSellIn(), 0);
        assertEquals(2, cheese.getQuality(), 0);    
    }

    @Test
    void qualityMax50() {

        AgedBrie brie = new AgedBrie("Aged Brie", 50, -1);
        brie.updateQuality();
        assertEquals(-2, brie.getSellIn(), 0);
        assertEquals(50, brie.getQuality(), 0);

        brie = new AgedBrie("Aged Brie", 49, -1);
        brie.updateQuality();
        assertEquals(-2, brie.getSellIn(), 0);
        assertEquals(50, brie.getQuality(), 0);
    }
}
