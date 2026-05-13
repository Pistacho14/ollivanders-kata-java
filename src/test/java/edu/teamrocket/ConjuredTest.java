package edu.teamrocket;

import org.junit.jupiter.api.Test;
import edu.teamrocket.domain.Conjured;
import static org.junit.jupiter.api.Assertions.*;


class ConjuredTest {

    @Test
    void crearConjured() {

        Conjured conjured = new Conjured("Conjured Mana Cake", 6, 3);
        assertEquals("Conjured Mana Cake", conjured.getName());
        assertEquals(3, conjured.getSellIn(), 0);
        assertEquals(6, conjured.getQuality(), 0);
    }

    @Test
    void toStringTest() {
        Conjured conjured = new Conjured("Conjured Mana Cake", 6, 3);
        System.out.println("toString() Conjured test:");
        System.out.println(conjured.toString());
    }

    @Test
    void updateQualityConjured() {

        Conjured conjured = new Conjured("Conjured Mana Cake", 6, 3);
        conjured.updateQuality();
        assertEquals(2, conjured.getSellIn(), 0);
        assertEquals(4, conjured.getQuality(), 0);
    }

    @Test
    void updateQualityConjuredJustExpired() {

        Conjured conjured = new Conjured("Conjured Mana Cake", 0, 6);
        conjured.updateQuality();
        assertEquals(-1, conjured.getSellIn(), 0);
        assertEquals(2, conjured.getQuality(), 0);    
    }

    @Test
    void updateQualityConjuredExpired() {

        Conjured conjured = new Conjured("Conjured Mana Cake", -1, 6);
        conjured.updateQuality();
        assertEquals(-2, conjured.getSellIn(), 0);
        assertEquals(2, conjured.getQuality(), 0);
    }

    @Test
    void qualityMinZERO() {

        Conjured brie = new Conjured("Conjured Mana Cake", 1, 1);
        brie.updateQuality();
        assertEquals(0, brie.getSellIn(), 0);
        assertEquals(0, brie.getQuality(), 0);

        brie = new Conjured("Conjured Mana Cake", -1, 0);
        brie.updateQuality();
        assertEquals(-2, brie.getSellIn(), 0);
        assertEquals(0, brie.getQuality(), 0);
    }
}
