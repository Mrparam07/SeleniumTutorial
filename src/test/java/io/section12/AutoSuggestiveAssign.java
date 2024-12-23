package io.section12;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveAssign {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        selectCountry(driver, "ind");
    }

    private static void selectCountry(WebDriver driver, String country) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys(country);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-autocomplete")));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-autocomplete")));
        } catch (ElementNotInteractableException e) {
            System.out.println("Element is not interactable: " + e.getMessage());
        }
        //without wait
        //org.openqa.selenium.ElementNotInteractableException: element not interactable

//        List<WebElement> options = driver.findElements(By.cssSelector(".ui-autocomplete"));
//        for (WebElement op : options) {
//            if (op.getText().equalsIgnoreCase(country)) ;
//            op.click();
//        }


        //solution Rs
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        //getAttribute() jsExecutor - extract the values

        driver.quit();
    }
}
