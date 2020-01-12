package com.gildedrose;

public class AgedBrieUpdater implements Updater {

    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            if (item.sellIn <= 0) {
                item.quality++;
            }
            item.quality++;
        }
    }
}
