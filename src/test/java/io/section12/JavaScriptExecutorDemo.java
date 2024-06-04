package io.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //jsExecutor
        //Identify objects which has hidden elements

        //scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by a specific amount (e.g., 1000 pixels)
        js.executeScript("window.scrollBy(0, 700)");

        //using actions
        //Actions actions = new Actions(driver);

        // Scroll down by a specific amount (e.g., 1000 pixels)
        //actions.moveToElement(driver.findElement(By.tagName("table")), 0, 1000).perform();

        //scroll in a table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for(int i=0;i<values.size();i++){
            sum+=Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        int totalValue = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1].trim());
        Assert.assertEquals(totalValue, sum);
        driver.quit();
    }
}
