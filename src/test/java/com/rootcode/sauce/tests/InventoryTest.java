package com.rootcode.sauce.tests;

import com.rootcode.sauce.Item;
import com.rootcode.sauce.SauceDataProvider;
import com.rootcode.sauce.TestBase;
import com.rootcode.sauce.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class InventoryTest extends TestBase {

    @Test
    public void testItemCount() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertEquals(inventoryPage.getProductCount(), 6);
    }

    @Test
    public void testSearchProductName() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertTrue(inventoryPage.searchProduct("Sauce Labs Bike Light"));
    }


    @Test
    public void testSearchProductNameNotExists() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertFalse(inventoryPage.searchProduct("Sauce Labs Bike Light NEW"));
    }


    @Test(dataProvider = "product-names", dataProviderClass = SauceDataProvider.class)
    public void testSearchProductNameList(String productNae) {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertTrue(inventoryPage.searchProduct(productNae));
    }

    @Test
    public void testMaxItemPrice() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        List<Item> itemList = inventoryPage.getItemList();
        OptionalDouble maxPrice = itemList.stream().mapToDouble(Item::price).max();
    }


    @Test
    public void testTotalOfAllProducts() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        List<Item> itemList = inventoryPage.getItemList();
        long sauceProducts = itemList.stream().filter(item -> item.itemName().contains("Sauce Labs")).count();
        Assert.assertEquals(sauceProducts, 5);
    }

    @Test
    public void testIfProductNamesAreSortedA2Z() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        List<Item> itemList = inventoryPage.getItemList();
        List<String> originalList = itemList.stream().map(Item::itemName).collect(Collectors.toList());
        List<String> sortedList = itemList.stream().map(Item::itemName).sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList);
    }


    @Test
    public void testIfProductNamesAreSortedZ2A() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.sortZ2A();
        List<Item> itemList = inventoryPage.getItemList();
        List<String> originalList = itemList.stream().map(Item::itemName).collect(Collectors.toList());
        List<String> sortedList = itemList.stream().map(Item::itemName).sorted().collect(Collectors.toList());
        Collections.reverse(sortedList);
        Assert.assertEquals(originalList, sortedList);
    }

    @Test
    public void testIfProductNamesAreSortedByPriceLowToHigh() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.sortPriceLowToHigh();
        List<Item> itemList = inventoryPage.getItemList();
        double[] original = itemList.stream().mapToDouble(Item::price).toArray();
        double[] sorted = itemList.stream().mapToDouble(Item::price).sorted().toArray();
        Assert.assertEquals(original, sorted);
    }


    @Test
    public void testIfProductNamesAreSortedByPriceHighToLow() {
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.sortPriceHighToLow();
        List<Item> itemList = inventoryPage.getItemList();
        List<Double> original = itemList.stream().map(Item::price).collect(Collectors.toList());
        List<Double> sorted = itemList.stream().map(Item::price).sorted().collect(Collectors.toList());
        System.out.println("Before " + sorted);
        Collections.reverse(sorted);
        System.out.println("Reversed " + sorted);
        Assert.assertEquals(original, sorted);
    }

}
