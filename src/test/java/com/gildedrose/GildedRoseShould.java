package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GildedRoseShould {
    private List<UpdatableItem> listOf(UpdatableItem item) {
        return new ArrayList<UpdatableItem>() {
            {
                add(item);
            }
        };
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = new Item("whatever", 10, 0);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(whateverItem.sellIn, 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = new Item("whatever", 1, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(whateverItem.quality, 9);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = new Item("whatever", 0, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(whateverItem.quality, 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = new Item("whatever", 0, 0);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(whateverItem.quality, 0);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new Item("Aged Brie", 5, 1);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(agedBrie);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(agedBrie.quality, 2);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(agedBrie);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(sulfuras);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(sulfuras.quality, 25);
        assertEquals(sulfuras.sellIn, 0);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePasses.quality, 21);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePasses.quality, 22);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePasses.quality, 23);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePasses.quality, 0);
    }
}
