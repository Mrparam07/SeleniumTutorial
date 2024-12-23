package io.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableAssign {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1
        //one way to count the no of rows present
        WebElement rows = driver.findElement(By.xpath("(//table[@id='product'])[1]"));
        System.out.println(rows.findElements(By.tagName("tr")).size());

        //second way
        List<WebElement> noOfRows = driver.findElements(By.cssSelector(".table-display tr"));
        System.out.println(noOfRows.size());

        //2
        //total column
        //.table-display tr:nth-child(1) th - getting by checking the first column
        List<WebElement> noOfCol = driver.findElements(By.cssSelector(".table-display tr th"));
        System.out.println(noOfCol.size());

        //3
        //second row content
        List<WebElement> secondRowContent = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
//        for(WebElement element : secondRowContent){
//            System.out.println(element.getText());
//            System.out.println();
//        }
        for(int i=0;i<secondRowContent.size();i++){
            System.out.println(secondRowContent.get(i).getText());
        }

        driver.quit();
    }
}
/*
1-count the no of rows in the table
2-total column
3-print the second row content
 */

