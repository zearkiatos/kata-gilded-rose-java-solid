package com.gildedrose;

final class StandardItem extends UpdatableItem {
    private static final int DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    Item item;

    StandardItem(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseSellIn();
        descreaseQuality();

        if (sellIn() < DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD) {
            descreaseQuality();
        }
    }
}
