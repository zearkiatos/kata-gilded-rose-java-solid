package com.gildedrose;

import java.util.List;

public class GildedRose {
    void updateQuality(List<UpdatableItem> items) {
        items.forEach(UpdatableItem::update);
    }
}
