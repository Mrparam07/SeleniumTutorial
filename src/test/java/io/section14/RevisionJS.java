package io.section14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RevisionJS {
    public static void main(String[] args) {

        //random
        randomTestJS();

    }

    private static void randomTestJS() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement element = driver.findElement(By.xpath("//p[text()='Number']/following-sibling::input"));
//        element.sendKeys("875785");
//        System.out.println(element.getAttribute("value")); //entered text

        // Set the value directly using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '875785';", element);

        // Verify the change
        String updatedValue = element.getAttribute("value");
        System.out.println("Updated input value: " + updatedValue); // Should print "New Value"

//
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].removeAttribute('type');", element);
//        jsExecutor.executeScript("arguments[0].setAttribute('type', 'text');", element);
//        element.sendKeys("param");

        //check if attribute is present
//        Object typeValue = jsExecutor.executeScript(
//                "return arguments[0].hasAttribute('type') ? arguments[0].getAttribute('type') : null;",
//                element
//        );
//
//        if (typeValue != null) {
//            System.out.println("Type attribute is present with value: " + typeValue);
//        } else {
//            System.out.println("Type attribute is not present.");
//        }


//        jsExecutor.executeScript("arguments[0].removeAttribute('type');", element);
//        jsExecutor.executeScript("arguments[0].setAttribute('type', 'number');", element);
//        //check if type is present and if it's value is number change it to text
//
//         Object typeValue = jsExecutor.executeScript(
//                "if (arguments[0].hasAttribute('type')) {" +
//                "   let type = arguments[0].getAttribute('type');" +
//                "   if (type === 'number') {" +
//                "       arguments[0].setAttribute('type', 'text');" +
//                "       return 'changed';" +
//                "   } else {" +
//                "       return type;" +
//                "   }" +
//                "} else {" +
//                "   return null;" +
//                "}",
//                element
//            );
//
//            // Handle the result
//            if ("changed".equals(typeValue)) {
//                System.out.println("Type attribute was 'number' and has been changed to 'text'.");
//            } else if (typeValue != null) {
//                System.out.println("Type attribute is present with value: " + typeValue);
//            } else {
//                System.out.println("Type attribute is not present.");
//            }

        // Change the type attribute from 'number' to 'text' using JavaScript
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(
//                "if (arguments[0].getAttribute('type') === 'number') {" +
//                        "   arguments[0].setAttribute('type', 'text');" +
//                        "}",
//                inputElement
//        );
//
//        // Verify the change
//        String updatedType = inputElement.getAttribute("type");
//        System.out.println("Updated input type: " + updatedType); // Should print "text" if it was changed


    }
}
