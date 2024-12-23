package io.section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class RevisePractice2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com");

        //CheckBox //spiceJet
//        handleRadioBoxTry(driver);

        //handle Radio
//        checkAgainRadio(driver);

        //handle CheckBox
        checkRadio(driver);

//        driver.quit();
    }

    private static void checkRadio(WebDriver driver) {
        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        waitForSec(3);
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //total count of the radio buttons
        int size = driver.findElements(By.xpath("//div[@id='discount-checkbox']//input[@type='checkbox']")).size();
        System.out.println("Total count of the radio buttons :: " + size);

    }

    private static void checkAgainRadio(WebDriver driver) {
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

        driver.findElement(By.id("checkBoxOption1")).isSelected();

        //get the total count
//        List<WebElement> total = driver.findElements(By.xpath("//legend[text()='Checkbox Example']/following-sibling::label"));
        List<WebElement> totalbyCss = driver.findElements(By.cssSelector("#checkbox-example label")); //css:#checkbox-example fieldset label
        for(WebElement el : totalbyCss) {
            System.out.println(el.getText());
        }
    }

    private static void handleRadioBoxTry(WebDriver driver) {
        waitForSec(1);
        String checkBoxToSelect = "Family & Friends";
        System.out.println("Check box is selected: "
                + driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]/parent::div/preceding-sibling::div[1]")).isSelected()); //ToDO

        driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]/parent::div/preceding-sibling::div[1]")).click();

        waitForSec(3);
        System.out.println("Check box is selected: "
                + driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]/parent::div/preceding-sibling::div[1]")).isSelected()); //ToDO

        //total count of the checkbox


        //create dynamic xpath
//        String textToSearch = "//div[contains(text(),'" + checkBoxToSelect + "')]/parent::div/preceding-sibling::div[1]";
//        driver.findElement(By.xpath(textToSearch)).click();
        //or by using string.format
//        String textToSearch2 = "Your Desired Text"; // Replace with your text
//        String dynamicXPath = String.format("//div[contains(text(),'%s')]/parent::div/preceding-sibling::div[1]", textToSearch2);
//        driver.findElement(By.xpath(dynamicXPath)).click();


    }


    private static void waitForSec(long wait) {
        try{
            Thread.sleep(wait * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
