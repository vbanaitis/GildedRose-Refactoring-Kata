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

    @Test
    void AgedBrieQualityIncrease() {
        Item foo = new Item("Aged Brie", 18, 10);
        Item[] items = new Item[] {foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, foo.sellIn);
        assertEquals(11, foo.quality);
    }

    @Test
    void AgedBrieQualityNeverOver50() {
        Item foo = new Item("Aged Brie", 18, 50);
        Item[] items = new Item[] {foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, foo.sellIn);
        assertEquals(50, foo.quality);
    }

    @Test
    void SulfurusNoChangeQualityOrSellIn() {
        Item foo = new Item("Sulfuras, Hand of Ragnaros", 18, 30);
        Item[] items = new Item[] {foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, foo.sellIn);
        assertEquals(30, foo.quality);
    }
}
