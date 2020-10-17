package com.gildedrose;

import java.util.Objects;

final class ItemSellIn {
    private final Integer value;

    ItemSellIn(final Integer value) {
        this.value = value;
    }

    ItemSellIn decrease() {
        return new ItemSellIn(value - 1);
    }

    Boolean isLessThan(Integer days) {
        return value < days;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object)
            return true;
        if (!(object instanceof ItemSellIn))
            return false;
        final ItemSellIn that = (ItemSellIn) object;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
