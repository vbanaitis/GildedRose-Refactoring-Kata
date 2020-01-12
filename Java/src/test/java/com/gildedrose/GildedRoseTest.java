package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void oldItem_QualityNotNegative() {
        Item foo = new Item("foo", 0, 0);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, foo.quality, "Quality expected to be 0");
    }

    @Test
    void sellInPassed() {
        Item foo = new Item("foo", 0, 0);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, foo.sellIn, "SellIn expected to be -1");
        assertEquals(0, foo.quality, "Quality expected to be zero");
    }

    @Test
    void qualityDropsFasterAfterSellInDate() {
        Item foo = new Item("foo", 0, 30);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, foo.sellIn, "SellIn expected to be -1");
        assertEquals(28, foo.quality, "Quality expected to be 28");
    }

    @Test
    void AgedBrieQualityIncrease() {
        Item foo = new Item("Aged Brie", 18, 10);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, foo.sellIn, "SellIn");
        assertEquals(11, foo.quality, "Quality");
    }

    @Test
    void AgedBrieQualityIncreaseAfterSellIn() {
        Item foo = new Item("Aged Brie", 0, 10);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, foo.sellIn, "SellIn");
        assertEquals(12, foo.quality, "Quality");
    }

    @Test
    void AgedBrieQualityNeverOver50() {
        Item foo = new Item("Aged Brie", 18, 50);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, foo.sellIn, "SellIn");
        assertEquals(50, foo.quality, "Quality");
    }

    @Test
    void SulfurusNoChangeQualityOrSellIn() {
        Item foo = new Item("Sulfuras, Hand of Ragnaros", 18, 30);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, foo.sellIn, "SellIn");
        assertEquals(30, foo.quality, "Quality");
    }

    @Test
    void BackStagePassesQualityIncrease() {
        Item foo = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, foo.sellIn, "SellIn");
        assertEquals(11, foo.quality, "Quality");
    }

    @Test
    void BackStagePassesQualityIncreaseByTwoWhenLessThanTenDays() {
        Item foo = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, foo.sellIn, "SellIn");
        assertEquals(11, foo.quality, "Quality expected to be 11");
        app.updateQuality();
        assertEquals(9, foo.sellIn, "SellIn");
        assertEquals(13, foo.quality, "Quality");
    }

    @Test
    void BackStagePassesQualityDecreaseToZeroAfterSellInPassed() {
        Item foo = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, foo.sellIn,"SellIn");
        assertEquals(13, foo.quality, "Quality");
        app.updateQuality();
        assertEquals(-1, foo.sellIn, "SellIn");
        assertEquals(0, foo.quality, "Quality");
    }

    @Test
    void ConjuredQualityDegrageTwiseAsFast() {
        Item foo = new Item("Conjured Mana Cake", 20, 10);
        Item[] items = new Item[]{foo};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, foo.sellIn, "SellIn");
        assertEquals(8, foo.quality, "Quality");
    }
}
