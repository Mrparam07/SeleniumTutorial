package io.section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        }
        driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
        Thread.sleep(2000);
        int i=0;
        while(i<5){
            i++;
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
    }
}
