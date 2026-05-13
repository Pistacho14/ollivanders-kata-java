package edu.teamrocket;

import org.junit.jupiter.api.Test;
import edu.teamrocket.domain.Backstage;
import static org.junit.jupiter.api.Assertions.*;

public class BackstageTest {

    @Test
    void crearBackstage() {

        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", pass.getName());
        assertEquals(15, pass.getSellIn(), 0);
        assertEquals(20, pass.getQuality(), 0);
    }

    @Test
    void toStringTest() {
        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        System.out.println("toString() Backstage test");
        System.out.println(pass.toString());
    }

    @Test
    void updateQualityOverTEN() {
        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        pass.updateQuality();
        assertEquals(21, pass.getQuality(), 0);
        assertEquals(14, pass.getSellIn(), 0);
    }

    @Test
    void updateQualityOverFIVE() {

        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        pass.updateQuality();
        assertEquals(5, pass.getSellIn(), 0);
        assertEquals(22, pass.getQuality(), 0);    
    }

    @Test
    void updateQualityOverZERO() {

        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        pass.updateQuality();
        assertEquals(4, pass.getSellIn(), 0);
        assertEquals(23, pass.getQuality(), 0);
    }

    @Test
    void updateQualityPassExpired() {

        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        pass.updateQuality();
        assertEquals(-1, pass.getSellIn(), 0);
        assertEquals(0, pass.getQuality(), 0);
    }

    @Test
    void qualityMax50() {

        Backstage pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        pass.updateQuality();
        assertEquals(4, pass.getSellIn(), 0);
        assertEquals(50, pass.getQuality(), 0);

        pass = new Backstage("Backstage passes to a TAFKAL80ETC concert", 9, 49);
        pass.updateQuality();
        assertEquals(8, pass.getSellIn(), 0);
        assertEquals(50, pass.getQuality(), 0);
    }
}
