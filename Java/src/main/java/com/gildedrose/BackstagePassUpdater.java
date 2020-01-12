package com.gildedrose;

public class BackstagePassUpdater implements Updater {

    @Override
    public void update(Item item) {
        item.quality++;
        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality++;
            }
        }
        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

}
