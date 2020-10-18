package com.gildedrose;

import java.util.Objects;

final class ItemName {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final String value;

    ItemName(final String value) {
        this.value = value;
    }

    Boolean isAgedBrie() {
        return AGED_BRIE.equals(value);
    }

    Boolean isBackstagePasses() {
        return BACKSTAGE_PASSES.equals(value);
    }

    Boolean isSulfuras() {
        return SULFURAS.equals(value);
    }

    @Override
    public boolean equals(final Object object) {
        if(this == object) return true;
        if(!(object instanceof ItemName)) return false;

        final ItemName itemName = (ItemName) object;
        return Objects.equals(value, itemName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
