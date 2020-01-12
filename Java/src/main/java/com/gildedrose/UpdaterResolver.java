package com.gildedrose;

public class UpdaterResolver {

    public Updater resolveUpdater(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros": {
                return new SulfurusUpdater();
            }
            case "Aged Brie": {
                return new AgedBrieUpdater();
            }
            case "Backstage passes to a TAFKAL80ETC concert": {
                return new BackstagePassUpdater();
            }
            case "Conjured Mana Cake": {
                return new ConjuredUpdater();
            }
            default: {
                return new ItemUpdater();
            }
        }
    }
}
