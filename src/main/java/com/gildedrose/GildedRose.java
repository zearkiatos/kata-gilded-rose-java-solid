package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int AGED_BRIE_DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD = 0;

    private static final int BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10;

    private static final int BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5;

    private static final int BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD = 0;

    private static final int DEFAULT_ITEM_DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    private static final int MAX_QUALITY = 50;

    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    decreaseSellIn(item);
                    updateAgedBrieQuality(item);
                    break;
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

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void updateAgedBrieQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < AGED_BRIE_DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD) {
            increaseQuality(item);
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
            decreaseSellIn(item);
        }
    }

    private void resetQuality(Item item) {
        item.quality = 0;
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1;
        }
    }

    private void descreaseQuality(Item item) {
        if (item.quality < MIN_QUALITY) {
            item.quality -= 1;
        }
    }
}