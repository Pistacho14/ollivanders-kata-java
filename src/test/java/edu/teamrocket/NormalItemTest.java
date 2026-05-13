package edu.teamrocket;

import org.junit.jupiter.api.Test;
import edu.teamrocket.domain.NormalItem;
import static org.junit.jupiter.api.Assertions.*;

class NormalItemTest {

    @Test
    void crearNormalItem() {

        NormalItem normal = new NormalItem("+5 Dexterity Vest", 20, 10);
        assertEquals("+5 Dexterity Vest", normal.getName());
        assertEquals(10, normal.getSellIn(), 0);
        assertEquals(20, normal.getQuality(), 0);
    }

    @Test
    void toStringTest() {
        NormalItem normal = new NormalItem("+5 Dexterity Vest", 20, 10);
        System.out.println(normal.toString());
    }

    @Test
    void updateQualityNormalItem() {

        NormalItem normal = new NormalItem("+5 Dexterity Vest", 20, 10);
        normal.updateQuality();
        assertEquals(9, normal.getSellIn(), 0);
        assertEquals(19, normal.getQuality(), 0);
    }

    @Test
    void updateQualityNormalItemExpired() {

        NormalItem normal = new NormalItem("+5 Dexterity Vest", 0, 20);
        normal.updateQuality();
        assertEquals(-1, normal.getSellIn(), 0);
        assertEquals(18, normal.getQuality(), 0);    
    }

    @Test
    void qualityMinZERO() {

        NormalItem normal = new NormalItem("+5 Dexterity Vest", 10, 0);
        normal.updateQuality();
        assertEquals(9, normal.getSellIn(), 0);
        assertEquals(0, normal.getQuality(), 0);
    }
}
