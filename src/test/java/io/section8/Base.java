package io.section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    public static void main(String[] args) throws InterruptedException {

        //with same tag name

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        String[] product = {"Cucumber","Brocolli","Beetroot"};
        Thread.sleep(2000);
        int k=0;
        for (int i = 0; i < products.size(); i++) {
            List itemList = Arrays.asList(product);
            String item[] = products.get(i).getText().split(" - ");
//            String itemName = item.substring(0,item.indexOf(" - "));
//            String[] parts = item.split(" - ");
            String itemName = item[0].trim();
            if (itemList.contains(itemName)) {
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                //not selecting the desired product due to add to cart - added, indexing change at runtime
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                k++;
            }
                if(k==product.length)
                    break;
            driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
            driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();
////            driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
////            driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHE')]")).click();
//            //take some to get to checkOut page
////            driver.findElement(By.xpath("//div[@class='promoWrapper']/parent::div/child::div/child::input")).sendKeys("param");
            driver.findElement(By.cssSelector("input.promoCode")).sendKeys("param");
//            driver.findElement(By.xpath("//div[@class='promoWrapper']/child::button")).click();
//            Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(),"Invalid code ..!");
        }
    }
}
