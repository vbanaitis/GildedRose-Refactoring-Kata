package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void oldItem_QualityNotNegative() {
        Item foo = new Item("foo", 0, 0);
        Item[] items = new Item[] {foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, foo.quality);
    }

    @Test
    void sellInPassed() {
        Item foo = new Item("foo", 0, 0);
        Item[] items = new Item[] {foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, foo.sellIn);
        assertEquals(0, 0);
    }

    @Test
    void qualityDropsFasterAfterSellInDate() {
        Item foo = new Item("foo", 0, 30);
        Item[] items = new Item[] {foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, foo.sellIn);
        assertEquals(28, foo.quality);
    }



}
