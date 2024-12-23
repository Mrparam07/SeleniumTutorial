package io.section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class StreamAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        assign(driver);
    }

    public static void assign(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //open topDeals
        driver.findElement(By.partialLinkText("Top Deals")).click();
        //switch the window
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        //sort the table
        driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name']")).click();
        //assert the sorted table
        List<WebElement> tableDataElement = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> tableData = tableDataElement.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortedTableData = tableData.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(tableData.equals(sortedTableData));

        //assert in all the pages

        //get the price
        String item = "Apple";
        String price = getPrice(item, tableDataElement);
        System.out.println("Price is "+price);

        //get all price using stream
        List<String> priceAnother = tableDataElement.stream().filter(s->s.getText().contains(item)).map(s->findPrice(s)).collect(Collectors.toList());
        priceAnother.forEach(a-> System.out.println(a));

        //in all the pages
        

        driver.quit();
    }

    private static String findPrice(WebElement element) {
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    private static String getPrice(String veg, List<WebElement> tableDataElement) {
        for(WebElement element : tableDataElement){
            if(element.getText().equals(veg)){
                return element.findElement(By.xpath("following-sibling::td[1]")).getText();
            }
        }
        return null;
    }
}
/*
using stream
1 - sort the table and check with the order if it is sorted - using stream
2 - check the sorted rows in all the pages
3 - find the price for respective veg
 */
