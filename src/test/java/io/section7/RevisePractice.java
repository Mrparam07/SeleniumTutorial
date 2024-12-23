package io.section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static org.apache.commons.io.FileUtils.waitFor;

public class RevisePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        long wait = 0;

        //get all the options
//        getAllOptions(driver);

        //directly select
//        selectValueinStaticDropDown(driver, "INR");

        //click first and then get the collection of the elements and then click on the desired element
//        selectByClickingOPtions(driver);

        //select Passenger
//        selectPassenger(driver);

        //Dynamic DropDown
//        dynamicDropdown(driver);

        //Dynamic DropDown
//        autoSuggestiveDropdown(driver);

        //random Practice
//        randomPractice(driver);


//        driver.quit();
    }


    private static void autoSuggestiveDropdown(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);

        //select by clicking the option //this is not the correct way to select the correct options bcz we need to go through all the options and then verify if it is present in the list.
//        driver.findElement(By.xpath("//a[text()='India']")).click(); ////a[text()='India']

        //select in all
        List<WebElement> allVisibleOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //.ui-menu-item a
        for (WebElement option : allVisibleOptions) {
            System.out.println(option.getText());
            if(option.getText().equals("India"))
                option.click();
        }


    }

    private static void dynamicDropdown(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[@value='MAA']")).click(); //element not interactable :: two matching elements
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //not the correct way to get the element

        //parent-child
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

    }

    private static void randomPractice(WebDriver driver) {
        WebElement element = driver.findElement(By.cssSelector(".staticHomeContentFullpage.position-relative"));
        //inside element
        String inside = element.findElement(By.xpath("//label[contains(text(),'PASSENGERS')]")).getText();
        System.out.println(inside);

        //outside element - it will not work because it is out of scope
//        element.findElement(By.id("FlashPage"));
    }

    private static void selectPassenger(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        int passengerCount = 5, i = 1;
        while (i < passengerCount) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), String.valueOf(passengerCount) + " Adult");

    }

    private static void selectByClickingOPtions(WebDriver driver) {
        driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
        WebElement el = driver.findElement(By.xpath("//option[text()='AED']"));
        System.out.println(el.getText());
        el.click();;
        driver.findElement(By.xpath("//*[contains(@value,'AED')]")).click();
    }

    private static void getAllOptions(WebDriver driver) {
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']/option"));
        System.out.println(allOptions.size());
        for (WebElement element : allOptions) {
            System.out.println(element.getText());
        }
    }

    private static void selectValueinStaticDropDown(WebDriver driver, String value) {
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select select = new Select(staticDropDown);
        select.selectByVisibleText(value);
        select.selectByIndex(3);

        select.selectByValue("AED");
        System.out.println(select.getFirstSelectedOption().getText());
//
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        // Print the text of each selected option
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
    }

    private static void waitForSec(long wait) {
        try{
            Thread.sleep(wait*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}