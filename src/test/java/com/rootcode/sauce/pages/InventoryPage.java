package com.rootcode.sauce.pages;

import com.rootcode.sauce.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private final WebDriver driver;

    @FindBy(className = "title")
    private WebElement eleTitle;

    @FindBy(css = ".inventory_item")
    private List<WebElement> eleItems;

    @FindBy(css = ".product_sort_container")
    private WebElement eleSort;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getTitle() {
        return eleTitle.getText().strip();
    }

    public int getProductCount() {
        return eleItems.size();
    }

    public boolean searchProduct(String productName) {
        List<Item> itemList = getItemList();
        return itemList.stream().anyMatch(item -> item.itemName().equals(productName));

        //USE JAVA STREAMS TO SIMPLIFY THE PROCESS
//        for (WebElement eleItem : eleItems
//        ) {
//            String itemName = eleItem.findElement(By.cssSelector(".inventory_item_name")).getText().strip();
//            if (itemName.equals(productName)) {
//                return true;
//            }
//        }
//        return false;
    }

    public List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();

        eleItems.stream().forEach(eleItem -> {
                    String itemName = eleItem.findElement(By.className("inventory_item_name")).getText().strip();
                    String itemDescription = eleItem.findElement(By.className("inventory_item_desc")).getText().strip();
                    double itemPrice = Double.parseDouble(eleItem.findElement(By.className("inventory_item_price")).getText().replace("$", "").strip());
                    Item item = new Item(itemName, itemDescription, itemPrice);
                    itemList.add(item);
                }
        );

        //USE JAVA STREAMS TO SIMPLIFY THE PROCESS
//
//        for (WebElement eleItem : eleItems
//        ) {
//            String itemName = eleItem.findElement(By.className("inventory_item_name")).getText().strip();
//            String itemDescription = eleItem.findElement(By.className("inventory_item_desc")).getText().strip();
//            double itemPrice = Double.parseDouble(eleItem.findElement(By.className("inventory_item_price")).getText().replace("$", "").strip());
//            Item item = new Item(itemName, itemDescription, itemPrice);
//            itemList.add(item);
//        }

        return itemList;
    }

    public void sortZ2A() {
        Select selSort = new Select(eleSort);
        selSort.selectByVisibleText("Name (Z to A)");
    }

    public void sortPriceLowToHigh() {
        Select selSort = new Select(eleSort);
        selSort.selectByVisibleText("Price (low to high)");
    }

    public void sortPriceHighToLow() {
        Select selSort = new Select(eleSort);
        selSort.selectByVisibleText("Price (high to low)");
    }
}
