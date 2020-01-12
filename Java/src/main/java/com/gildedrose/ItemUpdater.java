package com.gildedrose;

public class ItemUpdater implements Updater {

    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            if (item.sellIn <= 0) {
                item.quality--;
            }
            item.quality--;
        }
    }

}
