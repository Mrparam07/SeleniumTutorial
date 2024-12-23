package io.section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class RevisionPractice3 {
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.spicejet.com/");

        //Handle Calendar
//        handleCalendar(driver);

        //getHiddenElements
//        getHiddenElements();

        //e2e flight search
        searchFlightE2E();
    }

    private static void searchFlightE2E() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[text()='round trip']/parent::div[1]/parent::div[1]/div[1]")).click();
        //assert if return visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Return Date']")).getAttribute("style").contains("1"));

        driver.findElement(By.xpath("//div[text()='one way']/parent::div[1]/parent::div[1]/div[1]")).click();

        //select From
        String fromCity = "b";
//        driver.findElement(By.xpath("//div[text()='From']")).click();
        driver.findElement(By.xpath("//div[text()='From']/../div[2]/input")).sendKeys(fromCity);
        waitForSec(2);


        List<WebElement> allOptions = driver.findElements(By.xpath("//div[text()='Cities']/parent::div[1]/following-sibling::div[1]/div/div/div/div"));
        for (WebElement option : allOptions) {
            if (option.getText().equals("Bengaluru")) {
                option.click();
                break;
            }
        } // Getting error - stale element not found in the current frame because 'break statement was missing

        //assert if it is automatically dropped to 'TO'
//        System.out.println(driver.findElement(By.xpath("//div[text()='To']")).isSelected());

        String toCity = "va";
        driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys(toCity);
        waitForSec(1);
        driver.findElement(By.xpath("//div[text()='Varanasi']")).click();

        //select date - date should be user data
//        driver.findElement(By.xpath("//div[text()='30']")).click();
        driver.findElement(By.xpath("(//*[@opacity='.3'])[1]")).click();

        //select type by selecting preceding sibling
        driver.findElement(By.xpath("//div[text()='Students']/../preceding-sibling::div")).click();
        waitForSec(2);
//        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Students']/../preceding-sibling::div")).isSelected()); //getting error in this line

        //click on search
//        driver.findElement(By.xpath("//div[text()='Search Flight']")).click(); // getting error::"element click intercepted:cause:might" this particular element is not clickable
        //solution - click its immediate parent
        driver.findElement(By.xpath("//div[text()='Search Flight']/parent::div")).click(); // getting error::"element click intercepted:cause:might" this particular element is not clickable

        //Validate search page is loaded
//        driver.findElement(By.xpath("//div[text()='Continue']/ancestor::div[3]/div/descendant::div")).click();


    }

    private static void getHiddenElements() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); //problem
//        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        waitForSec(2);
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); //problem

        //only opacity is changing
        //check if the return date is visible or not
        String opacity = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']/parent::div")).getAttribute("style");
        System.out.println(opacity);
        if (!opacity.contains("1")) {
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        }


    }

    private static void handleCalendar(WebDriver driver) {

        //select today's date

    }

    private static void waitForSec(long wait) {
        try {
            Thread.sleep(wait * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
