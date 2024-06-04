package io.section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> cBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Random ran = new Random();
        int ranCbox = ran.nextInt(cBoxes.size())+1;

        //1
        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'][1])"+"["+ranCbox+"]"));
        String checkBoxText = "Option"+ranCbox;
        System.out.println(checkBoxText);
        checkBox.click();

        //2
        WebElement dropDownButton = driver.findElement(By.name("dropdown-class-example"));
        Select dropDown = new Select(dropDownButton);
        dropDown.selectByVisibleText(checkBoxText);

        //3
        driver.findElement(By.cssSelector("input[placeholder*='Your Name']")).sendKeys(checkBoxText);
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        String alertText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1].trim();
        Assert.assertEquals(alertText,checkBoxText);
        driver.switchTo().alert().accept();
    }
}

/*
1-qaclickacademy
2-select any checkbox and grab the label for the selected text
3-dropdown, select the same that is selected as checkbox
4-enter the step 2 grabbed label text into editbox
5-click on alert and verify text grabbed from step 2 is present in the pop message
 */
