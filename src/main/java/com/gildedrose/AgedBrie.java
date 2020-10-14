package com.gildedrose;

final class AgedBrie extends UpdatableItem {
    private static final int AGED_BRIE_DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD = 0;

    AgedBrie(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseSellIn();
        increaseQuality();

        if (sellIn() < AGED_BRIE_DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD) {
            increaseQuality();
        }
    }
}
