package io.section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) {
        //Parent Child locators. parent - child - parent //only possible in xpath not in cssSelector
        /*
        Absolute xPath - from root  /html/body/header
        Relative xPath - middle of somewhere in the dom "//" indicated relative xpath, most used
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        //header/div/button[1]/parent::div/parent::header/a
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

//        <input class="button_r4wideprimary" type="submit" id="LoginIdwideprimary" name="Login">
        //xpath
        //input[contains(@class,'wideprimary')]
        //*[contains(@id,'LoginIdwide')]

     /*
        <div id=”name_12”>
        <ul>
        <li name=”item1”>Xpath</li>
        <li name=”item2”>Css</li>
        <li name=”item3”>Partial Text</li>
        </ul>
        </div>
        //li[@name='item1']/following-sibling::li
      */
    }
}
