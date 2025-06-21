package io.section9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Revision9 {
    public static void main(String[] args) {

//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000)); //getting applied for each line
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //eCommerce application
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//
//        String items[] = {"Brocolli", "Cucumber", "Beetroot"};
//        addItemToTheCart(driver, items);
//
//        //place the order
//        placeOrder(driver);

        //fluent wait implementation
        fluentWait();
    }

    private static void fluentWait() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        try{
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement yehKisliye = fluentWait.until(new Function<WebDriver, WebElement>() {

                @Override
                public WebElement apply(WebDriver driver) {
                    if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()){
                        return driver.findElement(By.cssSelector("div[id='finish'] h4"));
                    }
                    else
                        return null;
                }
            });
            System.out.println(driver.findElement(By.cssSelector("#finish h4")).isDisplayed());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void placeOrder(WebDriver driver) {
        driver.findElement(By.cssSelector(".cart-icon img")).click();
        driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();


        //taking few seconds to apply the coupon - EXPLICIT WAIT
        WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Wait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy"); //failed at this step bcz of wait to prevent add implicit wait
        driver.findElement(By.className("promoBtn")).click();

//        driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

    }

    private static void addItemToTheCart(WebDriver driver, String[] items) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        List itemsToAdd = Arrays.asList(items);
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            String veggie = products.get(i).getText().split("-")[0].trim();
            if (itemsToAdd.contains(veggie)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                count++;
            }
            if (count == 3)
                break;
        }
    }

}
