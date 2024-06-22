package io.section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SortingWithStream {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
//        driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name']")).click();
//        driver.findElement(By.xpath("//table[@class='table table-bordered']/thead/tr/th[1]")).click();
        List<WebElement> deals = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));

        List<String> dealsText = deals.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = dealsText.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(dealsText.equals(sortedList));

        //get price of each vegetable
        List<String> priceList;
        do{
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            priceList = rows.stream().filter(s->s.getText().contains("Chocolate")).map(s->getPrice(s)).collect(Collectors.toList());
            priceList.forEach(a-> System.out.println(a));
            if(priceList.size()<1){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while (priceList.size()<1);
//        String vegetable = "Rice";
//        String price = findPrice(vegetable, driver, deals);
//        System.out.println(price);
        driver.quit();
    }

    public static String getPrice(WebElement element){
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    private static String findPrice(String vegetable, WebDriver driver, List<WebElement> deals) {
        int i=0;
        while(i<deals.size()){
            if(deals.get(i).getText() == vegetable){
                return deals.get(i).findElement(By.xpath("following-sibling::td[1]")).getText();
            }
            i++;
        }
        return null;
    }
}
