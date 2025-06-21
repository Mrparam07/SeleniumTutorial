package io.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;


public class Revision12 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        //scrolling
        jsExecutor(driver);

        //table Grid
//        tableGrid(driver);

        //assignment
//        assignment(driver);

        //assignment autoSuggestive
//        assignmentAutoSuggestiveDropDown(driver);
    }

    private static void assignmentAutoSuggestiveDropDown(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("unit");
        Wait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-menu.ui-widget li")));
        List<WebElement> allVisibleOption = driver.findElements(By.cssSelector(".ui-menu.ui-widget li"));
        for (WebElement option : allVisibleOption) {
            if((option.findElement(By.cssSelector("div")).getText()).equalsIgnoreCase("United States (USA)")) {
                option.click();
                break;
            }
        }

        /*
        @Test
public void assignment4() {

    driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    WebElement countriesSearch = driver.findElement(By.id("autocomplete"));
    countriesSearch.click();
    countriesSearch.sendKeys("Ind");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
    List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
    String expectedText = list.get(1).getText();
    list.get(1).click();
    String actualText = countriesSearch.getAttribute("value");

    try {
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Success!");
    } catch (AssertionError e) {
        System.out.println(e.getMessage());
        throw e;
    }
}
         */
    }

    private static void assignment(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //no of total rows
        System.out.println("Total no rows:: " + driver.findElements(By.cssSelector("#product:first-child tr")).size());

        //no of columns
        System.out.println("Total no of columns:: " + driver.findElements(By.xpath("(//table[@id='product'])[1]//th")).size());

        //print second row
        List<WebElement> secondRow = driver.findElements(By.xpath("(//table[@id='product'])[1]//tr[3]/td")); //cssSelector::fieldset:first-of-type #product tr:nth-of-type(3)
//        for (WebElement row : secondRow) {
//            System.out.println(row.getText());
//        }
        for(int i = 0; i<secondRow.size();i++) {
            String rowText = secondRow.get(i).getText();
            System.out.println(rowText);
        }
    }

    private static void tableGrid(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //get header name
        List<WebElement> thName = driver.findElements(By.cssSelector(".tableFixHead table th")); //.tableFixHead table thead tr th
        String amountColumnIndex = null;
        int count = 0;
        for(WebElement th : thName) {
            System.out.println(th.getText());
            count++;
            if(th.getText().equalsIgnoreCase("Amount")) {
                break;
            }
        }
        System.out.println(count);
        amountColumnIndex = Integer.toString(count);
        //get the sum of element present in the amount column
        List<WebElement> amountValue = driver.findElements(By.xpath("//div[contains(@class,'tableFixHead')]//td["+amountColumnIndex+"]"));
        int sumOfAmount = 0;
        for(WebElement amount : amountValue) {
            sumOfAmount += Integer.parseInt(amount.getText());
        }
        System.out.println("Total amount :: " + sumOfAmount);

        //assert with total value
        String totalValueDisplayed = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
        Assert.assertEquals(String.valueOf(totalValueDisplayed), totalValueDisplayed);
    }

    private static void jsExecutor(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll page to bottom
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //scroll to co-ordinates
//        js.executeScript("window.scrollBy(0,500)");
        //scroll left
//        js.executeScript("window.screenLeft");
        //scroll page to any specific element
//        js.executeScript("document.querySelector('#gf-BIG').scrollIntoView(true)");

        // Scroll to the element using JavaScriptExecutor
//        WebElement targetElement = driver.findElement(By.xpath("//*[.='iFrame Example']"));
//        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);

        //scroll in any specific element
//        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        // Find the field (for example, an input field)
//        driver.findElement(By.id("name")).sendKeys("param");
//        String fieldValue = (String)((JavascriptExecutor) driver).executeScript(
//                "return document.getElementById('name').value;"
//        );
//        System.out.println(fieldValue);
//
//        //method 2
//        String val = "return document.getElementById('name').value;";
//        String txt = (String)((JavascriptExecutor) driver).executeScript(val);
//        System.out.println(txt);

        //Imp UseCases
        //2. Clicking on Hidden Elements
//        WebElement element = driver.findElement(By.id("hiddenElementId"));
//        js.executeScript("arguments[0].click();", element);  // Click on the hidden element

        //3. Changing CSS Properties
//        WebElement element = driver.findElement(By.id("elementId"));
//        js.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);  // Change background color

        //4. Extracting Text from an Element
//        WebElement element = driver.findElement(By.id("elementId"));
//        String text = (String) js.executeScript("return arguments[0].innerText;", element);
//        System.out.println("Extracted Text: " + text);  // Output the extracted text

        //5. Alert Handling
//        js.executeScript("alert('This is an alert');");  // Trigger a JavaScript alert

        //6. Refreshing the Page
//        js.executeScript("location.reload();");  // Reload the page

        //7. Simulating Keyboard and Mouse Events
//        WebElement element = driver.findElement(By.id("inputFieldId"));
//        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {key: 'Enter'}));", element);  // Simulate 'Enter' key press

        //8. Executing Custom JavaScript Code
//        String pageTitle = (String) js.executeScript("return document.title;");
//        System.out.println("Page Title: " + pageTitle);  // Output the page title

        //9. Disabling Browser’s Cache
//        js.executeScript("window.localStorage.clear();");  // Clear local storage

        //10. Handling Frames and Iframes
//        js.executeScript("window.frames['frameName'].document.body.scrollIntoView(true);");  // Scroll inside the iframe

        //11. Setting Values in Read-Only or Disabled Fields
        //method 1
        // Locate the read-only or disabled element
//        WebElement element = driver.findElement(By.id("readOnlyField"));
//        js.executeScript("arguments[0].value = 'New Value';", element);
        //method 2
//        js.executeScript("document.getElementById('inputFieldId').value='Test Value';");  // Set value in a read-only field
//
        //remove attribute
//        js.executeScript("arguments[0].removeAttribute('class');", driver.findElement(By.id("gf-BIG")));  // Set value in a read-only field

//        if (element.getAttribute("class") != null) {
//            String classValue = element.getAttribute("class");
//            System.out.println("Class attribute value: " + classValue);
//        } else {
//            System.out.println("The 'class' attribute is not present in the tag.");
//        }

        //12. Executing Asynchronous Code (Promises)
//        Object result = js.executeAsyncScript(
//                "var callback = arguments[arguments.length - 1];" +
//                        "setTimeout(function() { callback('Async result'); }, 2000);"  // Returns 'Async result' after 2 seconds
//        );
//        System.out.println(result);  // Output will be 'Async result' after 2 seconds


        //13. Wait for JavaScript to Complete
//        Boolean isPageLoaded = (Boolean) js.executeScript("return document.readyState == 'complete';");
//        if (isPageLoaded) {
//            System.out.println("Page has finished loading.");
//        } else {
//            System.out.println("Page is still loading.");
//        }

        //14. Print all the attributes of the WebElement
        try {

            // Locate the element
            WebElement element = driver.findElement(By.id("gf-BIG"));
            String script = "var items = arguments[0].attributes; " +
                    "var result = ''; " +
                    "for (var i = 0; i < items.length; i++) { " +
                    "    result += items[i].name + '=\"' + items[i].value + '\"\\n'; " +
                    "} " +
                    "return result;";

            String attributes = (String) js.executeScript(script, element);

            // Print the attributes and their values
            System.out.println("Attributes and values of the element:");
            System.out.println(attributes);

            //Store in map
            // Split the attributes and store in a map
//            Map<String, String> attributesMap = new HashMap<>();
//            String[] pairs = attributes.split(";");
//            for (String pair : pairs) {
//                if (!pair.isEmpty()) {
//                    String[] keyValue = pair.split("=", 2);
//                    attributesMap.put(keyValue[0], keyValue[1]);
//                }
//            }
//
//            // Print the attributes map
//            System.out.println("Attributes of the element:");
//            for (Map.Entry<String, String> entry : attributesMap.entrySet()) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
//            }
        } catch (Exception e){
            // Close the browser
            System.out.println(e);
        }
    }
}
