package io.section8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmzQs {
    private static void addProduct(String[] item, WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int count = 0;
        for(int i=0;i<products.size();i++){
            String items[] = products.get(i).getText().split("-",0);
            List itemList = Arrays.asList(item);
            if(itemList.contains(items[0].trim())){
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                count++;
            }
            if(count == item.length)
                break;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        String[] item = {"Cucumber","Brocolli","Beetroot"};
        addProduct(item,driver);
    }
}
