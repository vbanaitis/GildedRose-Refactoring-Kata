package com.gildedrose;

public class ConjuredUpdater implements Updater {

    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality -= 2;
        }
    }
}
