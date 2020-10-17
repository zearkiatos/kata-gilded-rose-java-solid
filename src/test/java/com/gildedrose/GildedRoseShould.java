package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GildedRoseShould {
    private List<Item> listOf(Item item) {
        return new ArrayList<Item>() {
            {
                add(item);
            }
        };
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = ItemFactory.basedOn("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemSellIn expectedSellIn = new ItemSellIn(9);
        assertEquals(expectedSellIn, whateverItem.sellIn());
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = ItemFactory.basedOn("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemQuality expectedQuality = new ItemQuality(9);
        assertEquals(expectedQuality, whateverItem.quality());
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = ItemFactory.basedOn("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(expectedQuality, whateverItem.quality());
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = ItemFactory.basedOn("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(expectedQuality, whateverItem.quality());
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = ItemFactory.basedOn("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        ItemQuality expectedQuality = new ItemQuality(2);
        assertEquals(expectedQuality, agedBrie.quality());
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = ItemFactory.basedOn("Aged Brie", 5, 50);
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
