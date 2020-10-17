package com.gildedrose;

import java.util.List;

final class GildedRose {
    void updateQuality(List<Item> items) {
        items.forEach(Item::update);
    }
}
