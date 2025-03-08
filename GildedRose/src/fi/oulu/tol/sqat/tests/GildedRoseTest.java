package fi.oulu.tol.sqat.tests; 
   import static org.junit.Assert.*;

import java.util.List;
   import org.junit.Test;
   import fi.oulu.tol.sqat.GildedRose;
   import fi.oulu.tol.sqat.Item;

   public class GildedRoseTest {

       @Test
       public void testTheTruth() {
           assertTrue(true);
       }

       @Test
       public void testExample() {         
           GildedRose inn = new GildedRose();          
           Item item = new Item("+5 Dexterity Vest", 10, 20);           
           inn.setItem(item);           
           inn.oneDay();
           List<Item> items = inn.getItems();           
           int quality = items.get(0).getQuality();
           assertEquals(19, quality);
       }

       @Test
       public void test_name () {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("testi123", 10, 20));
           assertNotNull(inn.getItems().get(0).getName());
       }

       @Test
       public void test_sell () {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("testi123", 10, 20));
           assertNotNull(inn.getItems().get(0).getSellIn());
       }

       @Test
       public void test_quality () {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("testi123", 10, 20));
           assertNotNull(inn.getItems().get(0).getQuality());
       }

       @Test
       public void test_Sell_Decreases() {       
           GildedRose inn = new GildedRose();            
           Item item = new Item("+5 Dexterity Vest", 10, 20);           
           inn.setItem(item);
           inn.oneDay();            
           int sellIn = inn.getItems().get(0).getSellIn();          
           assertEquals(9, sellIn);
       }

       @Test
       public void test_Quality() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("testi123", 1, 10));
           inn.oneDay();
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(7, quality);
       }

       @Test
       public void test_QualityNeverNegative() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("testi123", 1, 5));
           inn.oneDay();
           inn.oneDay();
           inn.oneDay();
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(0, quality);
       }

       @Test
       public void test_AgedBrieQuality() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Aged Brie", -1, 50));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(50, quality);
       }

       @Test
       public void test_AgedBrie() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Aged Brie", -5, 5));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(7, quality);
       }

       @Test
       public void test_Quality1() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Aged Brie", 5, 50));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(50, quality);
       }

       @Test
       public void test_Legendary1 () {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int sellIn = items.get(0).getSellIn();
           assertEquals(0, sellIn);
       }

       @Test
       public void test_Legendary2 () {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(80, quality);
       }

       @Test
       public void test_BackstagePassesQuality1() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(21, quality);
       }

       @Test
       public void test_BackstagePassesQuality2() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(22, quality);
       }

       @Test
       public void test_BackstagePassesQuality3() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(21, quality);
       }

       @Test
       public void test_BackstagePassesQuality4() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(23, quality);
       }

       @Test
       public void test_BackstagePassesQuality5() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(22, quality);
       }

       @Test
       public void test_BackstagePassesQuality6() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(0, quality);
       }

       @Test
       public void test_BackstagePassesQuality7() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(50, quality);
       }

       @Test
       public void test_BackstagePassesQuality8() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(50, quality);
       }

       @Test
       public void test_LegendaryQuality() {
           GildedRose inn = new GildedRose();
           inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
           inn.oneDay();
           List<Item> items = inn.getItems();
           int quality = items.get(0).getQuality();
           assertEquals(80, quality);
       }
       
       @Test
   	public void testMain() {
   		GildedRose.main(new String[0]);
   	}     
   }
