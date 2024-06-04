package io.section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CalendarTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String day = "7";
        String month = "5";
        String year = "2027";
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();


//        driver.findElement(By.cssSelector(".react-calendar__year-view__months__month:nth-of-type("+Integer.parseInt(month)+")")).click();
//        String monthName = driver.findElement(By.cssSelector(".react-calendar__year-view__months__month:nth-of-type(" + Integer.parseInt(month) + ")")).getText();
//        System.out.println(monthName);
//        driver.findElement(By.xpath("(//button[@class='react-calendar__tile react-calendar__year-view__months__month'])[" + Integer.parseInt(month) + "]")).click();
//        driver.findElements(By.cssSelector("react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
//        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
        //days cannot be selected lke month above because 42 boxes are there
        //react-calendar__month-view__days__day
        //button[contains(@class,'react-calendar__tile')]
        //button[contains(@class,'month-view__days__day')]/abbr
        //(//*[contains(@class, 'react-calendar__month-view__days__day')])

//        driver.findElement(By.cssSelector("abbr[aria-label='June 3, 2027']"));
        //driver.findElement(By.cssSelector("abbr[aria-label='" + monthName + " " + day + ", " + year + "']"));

//        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();


        //sol

        String[] expectedList = {month,day,year};
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i =0; i<actualList.size();i++)
        {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
        System.out.println("param");
        driver.close();
    }
}
