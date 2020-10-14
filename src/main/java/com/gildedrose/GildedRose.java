package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    private static final int BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10;

    private static final int BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5;

    private static final int BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD = 0;

    private static final int DEFAULT_ITEM_DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case BACKAGE_PASSES:
                    decreaseSellIn(item);
                    updateBackagePassesQuality(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    decreaseSellIn(item);
                    updateDefaultItemQuality(item);
            }
        }
    }

    private void updateBackagePassesQuality(Item item) {
        increaseQuality((item));
        if (item.sellIn < BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            increaseQuality(item);
        }

        if (item.sellIn < BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            increaseQuality(item);
        }

        if (item.sellIn < BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD) {
            resetQuality(item);
        }
    }

    private void updateDefaultItemQuality(Item item) {
        descreaseQuality(item);

        if (item.sellIn < DEFAULT_ITEM_DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD) {
            descreaseQuality(item);
        }
    }

}