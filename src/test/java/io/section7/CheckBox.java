package io.section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
//        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//        int count=driver.findElements(By.cssSelector("input[type='checkbox']")).size();
//
//        System.out.println(count);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[id$='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id$='checkBoxOption1']")).isSelected());
        driver.findElement(By.cssSelector("input[id$='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id$='checkBoxOption1']")).isSelected());

        int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

    }
}
