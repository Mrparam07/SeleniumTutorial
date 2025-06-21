package io.section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Revision8 {
    public static void main(String[] args) {

        //code formatting
        //camelCase
        //debugging technique

        //eCommerce application
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //adding item by following siblings
//        addToCartByProductName(driver);

        String items[] = {"Brocolli", "Cucumber", "Beetroot"};
        addToCartByIterating(driver, items);
    }

    private static void addToCartByProductName(WebDriver driver) {
//        String product = "Cucumber";
//        //dynamic xpath
//        driver.findElement(By.xpath("//h4[contains(.,'" + product + "')]/following-sibling::div[2]/button")).click();

        //select multiple products
        String products[] = {"Brocolli", "Brinjal", "Tomato"};
        for (int i = 0; i < products.length; i++) {
            driver.findElement(By.xpath("//h4[contains(.,'" + products[i] + "')]/following-sibling::div[2]/button")).click();
        }
    }

    private static void addToCartByIterating(WebDriver driver, String[] items) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        //instead of using two loops we can use ArrayList
        List itemsToAdd = Arrays.asList(items);
        int count = 0;
//        for (String item : items) {
        for (int i = 0; i < products.size(); i++) {
            String veggie = products.get(i).getText().split("-")[0].trim();

            if (itemsToAdd.contains(veggie)) {
                System.out.println(products.get(i).getText());
//                addToCart.get(i).click();

                //or directly we can do add to cart for the selected product
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //it will select different product as the locator is dynamic in nature
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();


//                    break; //when will 2 loops

                count++;
            }
            if (count == 3)
                break;

            //it is adding different item to the cart why? locator is changing and index of add to cart is also getting updated
            //fix avoid text locator of 'ADD TO CART'
        }
//        }

    }
}

/*
import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class base {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub


System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");



WebDriver driver=new ChromeDriver();





String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};





driver.get("https://rahulshettyacademy.com/seleniumPractise/");

Thread.sleep(3000);

addItems(driver,itemsNeeded);


}



public static  void addItems(WebDriver driver,String[] itemsNeeded)

{

int j=0;

List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));


for(int i=0;i<products.size();i++)


{


//Brocolli - 1 Kg

//Brocolli,    1 kg

String[] name=products.get(i).getText().split("-");

String formattedName=name[0].trim();


//format it to get actual vegetable name

//convert array into array list for easy search

//  check whether name you extracted is present in arrayList or not-


List itemsNeededList = Arrays.asList(itemsNeeded);



if(itemsNeededList.contains(formattedName))

{


j++;

//click on Add to cart

driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();


if(j==itemsNeeded.length)

{

break;

}





}

}

}




}


 */
