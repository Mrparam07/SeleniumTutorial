package io.section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Revision11 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        //scope
//        scope(driver);

        //assignment
//        assignment(driver);

        //calendar UI
        handleCalendar(driver);
    }

    private static void handleCalendar(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String day = "7", month = "5", year = "2030";
        driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label span")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label span")).click();
        driver.findElement(By.xpath("//button[.='"+year+"']")).click();

//        driver.findElement(By.xpath("//button[.='"+month+"']")).click(); //month = "May"
        //get month using no
//        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(month)-1).click();

        driver.findElement(By.xpath("//button[.='"+day+"']")).click();

        //get the text of selected value for assertions but as this is not text field then we need to extract the value from the attributes
        List<WebElement> dayMonthYear = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        String[] expList = {month, day, year};
        for(int i = 0; i < dayMonthYear.size(); i++){
            String actualValue = dayMonthYear.get(i).getAttribute("value");
            Assert.assertEquals(actualValue, expList[i]);
        }
    }

    private static void assignment(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        /*
        1-qaclickacademy
        2-select any checkbox and grab the label for the selected text
        3-dropdown, select the same that is selected as checkbox
        4-enter the step 2 grabbed label text into editbox
        5-click on alert and verify text grabbed from step 2 is present in the pop message
         */

        Random rand = new Random();
        int option = rand.nextInt(3) + 1;
        WebElement checkBox = driver.findElement(By.xpath("//*[.='Checkbox Example']/following-sibling::label["+option+"]"));
        if(!checkBox.findElement(By.cssSelector("input")).isSelected()) //checking for input tags only within WebElement checkBox
            checkBox.findElement(By.cssSelector("input")).click();
        String selectOption = checkBox.getText();
        System.out.println(selectOption);

        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByVisibleText(selectOption);

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(selectOption);
        driver.findElement(By.id("confirmbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText().split(",")[0].split(" ")[1],selectOption);
        driver.switchTo().alert().accept();
        System.out.println("Completed");
    }

    private static void scope(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //get all the links in the page
//        int size = driver.findElements(By.cssSelector("a")).size();
        int size = driver.findElements(By.tagName("a")).size();
        System.out.println(size);

        //get all the links in footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //create a driver subset
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //get all the links of first column in footer section
        WebElement footerFirstColumn = driver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]//ul"));
        System.out.println(footerFirstColumn.findElements(By.tagName("a")).size());

        //open all the links on 2 column
        WebElement footerSecondColumn = driver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]//ul"));
        List<WebElement> secCol = footerSecondColumn.findElements(By.tagName("a"));
        //cannot do directly click on new links because it will be navigated to the other link
        //solution 1-click and go back, 2-click using CTRL key

        //solution 1
//        clickByBack(driver, footerSecondColumn, secCol);

        //solution 2
        clickByCtrl(secCol);

        //get the titles of all the pages
        Set<String> win = driver.getWindowHandles();
        Iterator<String> iterator = win.iterator();
        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
    }

    private static void clickByCtrl(List<WebElement> secCol) throws InterruptedException {


//        solution 2 //first link is also getting opened
//        for (WebElement secColElement : secCol) {
//            String colLinkTable = Keys.chord(Keys.CONTROL, Keys.ENTER);
//            Thread.sleep(3000);
//            secColElement.sendKeys(colLinkTable);
//        }
        for (int i = 1; i < secCol.size(); i++) {
            String colLinkTable = Keys.chord(Keys.CONTROL, Keys.ENTER);
            Thread.sleep(3000);
            secCol.get(i).sendKeys(colLinkTable);
        }
    }

    private static void clickByBack(WebDriver driver, WebElement footerSecondColumn, List<WebElement> secCol) {
        for (int i = 0; i < secCol.size(); i++) {
            footerSecondColumn = driver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]//ul"));
            secCol = footerSecondColumn.findElements(By.tagName("a"));

            /*
            Re-fetching Elements:

            Inside the loop, after navigating back, re-locate the footerSecondColumn and the links (secCol) to ensure fresh references to the elements.
            This avoids stale element exceptions as the DOM structure is rebuilt after navigation.
             */

            // Click on the current link
            WebElement link = secCol.get(i);
            String linkText = link.getText(); // Optional: Get link text for logging
            link.click();

            // Print the current page title
            System.out.println("Opened Page Title: " + driver.getTitle());

            // Navigate back
            driver.navigate().back();
        }

    }
}
