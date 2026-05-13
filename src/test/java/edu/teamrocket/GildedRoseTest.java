package edu.teamrocket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import edu.teamrocket.domain.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class GildedRoseTest {

    private GildedRose shop = null;
    private NormalItem normal = null;
    private AgedBrie brie = null;

    @BeforeEach
    void setupInventario() {
       shop = new GildedRose();
       normal = new NormalItem("+5 Dexterity Vest", 20, 10);
       brie = new AgedBrie("Aged Brie", 0, 2);
    }

    @Test
    void toStringTest() {
        shop.addItem(brie);
        brie = new AgedBrie("Aged Brie", 10, 10);
        shop.addItem(brie);
        System.out.println("toString() GildedRose test:");
        System.out.println(shop.toString());
    }

    @Test
    void addItemTest() {
        shop.addItem(normal);
        shop.addItem(brie);
        assertEquals(2, shop.inventory().size(), 0);
        // nuevo Java 9 metodo factoria estatico para crear unmodifiable lists List.of()
        List<NormalItem> items = List.of(normal, brie);
        assertArrayEquals(items.toArray(), shop.inventory().toArray());

        System.out.println("GildedRose addItem test:");
        System.out.println(shop.toString());
    }

    @Test
    void updateQuality() {
        shop.addItem(normal);
        shop.addItem(brie);
        assertEquals(2, shop.inventory().size(), 0);
        System.out.println("Dia 0:" + '\n' + shop.toString());
        shop.updateQuality();

        // Hay que cambiar la vista del objeto Updateable 
        // para tener acceso al metodo getQuality del
        // tipo NormalItem
        NormalItem item = (NormalItem) shop.inventory().get(0);
        assertEquals(19, item.getQuality(), 0);
        assertEquals(1, ((NormalItem) (shop.inventory().get(1))).getQuality(), 0);
        System.out.println("Dia 1:" + '\n' + shop.toString());
    }
}
