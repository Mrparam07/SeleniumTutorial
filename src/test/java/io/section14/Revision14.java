package io.section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Revision14 {
    public static void main(String[] args) {

        //java Stream
//        javaStream();

        //WebTable sorting
        webTableSorting();

        //WebTable sorting using STREAM
        webTableSortingUsingStream();

        //customize path
        customizePath();

        //verify filters
        verifyFilters();

        //validate pagination in all the pages
//        validatePagination();

    }

    @Test
    private static void verifyFilters() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        //find all the element present in the table
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        //check if all the elements contains rice
        List<WebElement> filterList = veggies.stream().filter(s->s.getText().contains("Rice")).toList();
        Assert.assertEquals(veggies.size(), filterList.size());

        // Create a SoftAssert instance
        SoftAssert softAssert = new SoftAssert();
        // Find the elements that do not contain "Rice"
        List<WebElement> nonRiceVeggies = veggies.stream()
                .filter(s -> !s.getText().contains("Rice"))
                .collect(Collectors.toList());
        // Assert that all veggies contain "Rice" and log failures
        for (WebElement veggie : veggies) {
            String veggieName = veggie.getText();
            softAssert.assertTrue(veggieName.contains("Rice"),
                    "Veggie does not contain 'Rice': " + veggieName);
        }
        // Output non-compliant veggies for debugging
        if (!nonRiceVeggies.isEmpty()) {
            System.out.println("Veggies not containing 'Rice':");
            nonRiceVeggies.forEach(veggie -> System.out.println(veggie.getText()));
        }

        // Perform a final assertion to collect results
        softAssert.assertAll();
    }

    @Test
    private static void customizePath() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //get the price of rice

        List<WebElement> colmunDataList;
//        List<WebElement> colmunDataList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        //scan the name column for rice, if found get the price of it
//        String price = colmunDataList.stream().filter(s->s.getText().contains("Beans"))
//                .map(s->s.findElement(By.xpath("following-sibling::td[1]")).getText()).toList().get(0);

        //scan in all the pages
        WebElement nextBtn = driver.findElement(By.xpath("//a[@aria-label='Next']"));
        List<String> price;
        String veggie = "Beans";
        do {
            colmunDataList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            price = colmunDataList.stream().filter(s -> s.getText().contains(veggie))
                    .map(s -> priceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if (price.size() > 0)
                break;
            if (nextBtn.getAttribute("aria-disabled").equals("false")) {
                nextBtn.click();
            }
            else{
                Assert.assertTrue(false, "Vegetable is not present");
                break;
            }
        } while (price.size() < 1);
    }

    private static String priceVeggie(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    /*
    Sir Code
    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

// click on column

driver.findElement(By.xpath("//tr/th[1]")).click();



// capture all webelements into list

List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));



// capture text of all webelements into new(original) list

List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());



// sort on the original list of step 3 -> sorted list



List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

// compare original list vs sorted list

Assert.assertTrue(originalList.equals(sortedList));

List<String> price;

// scan the name column with getText ->Beans->print the price of the Rice

do

{

List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

price = rows.stream().filter(s -> s.getText().contains("Rice"))

.map(s -> getPriceVeggie(s)).collect(Collectors.toList());


price.forEach(a -> System.out.println(a));

if(price.size()<1)

{

driver.findElement(By.cssSelector("[aria-label='Next']")).click();

}

}while(price.size()<1);



}



private static String getPriceVeggie(WebElement s) {

// TODO Auto-generated method stub

String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();



return pricevalue;

}
     */

    @Test
    private static void webTableSortingUsingStream() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String columnToSort = "Price";
        int index = 2;
        //click on column
        driver.findElement(By.xpath("//span[text()='" + columnToSort + "']")).click();

        //capture all the webElements into list new (original list)
        List<WebElement> colmunDataList = driver.findElements(By.xpath("//tbody/tr/td[" + index + "]"));
        //get all the text present in the webElement
        List<String> originalList = colmunDataList.stream().map(s -> s.getText()).collect(Collectors.toList());
        //sort the list as new list
        List<String> originalListAfterSorting = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
//        Assert.assertTrue(originalList.equals(originalListAfterSorting));

        //soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(originalList.equals(originalListAfterSorting), "" +
                "Original lists are not the same: originalList=" + originalList + ", originalListAfterSorting=" + originalListAfterSorting);
        softAssert.assertAll();
    }

    @Test
    private static void webTableSorting() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String columnToSort = "Veg/fruit name";
        //click on column
//        driver.findElement(By.xpath("//span[text()='" + columnToSort + "']")).click();
        int index = 0;
        if (columnToSort == "Veg/fruit name")
            index = 1;
        //capture all the webElements into list new (original list)
        List<WebElement> colmunDataList = driver.findElements(By.xpath("//tbody/tr/td[" + index + "]"));
        //get all the text present in the webElement
        List<String> orignalList = new ArrayList<>();
        for (WebElement columnData : colmunDataList)
            orignalList.add(columnData.getText());

        //sort the list as new list
        List<String> originalListAfterSorting = new ArrayList<>(orignalList);
        Collections.sort(originalListAfterSorting);

        //compare original list vs sorted list
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < orignalList.size(); i++) {
            softAssert.assertEquals(orignalList.get(i), originalListAfterSorting.get(i));
        }
        softAssert.assertAll();
        //soft assertion method 2
//        softAssert.assertTrue(orignalList.equals(originalListAfterSorting),
//                "The lists are not equal: originalList=" + orignalList + ", sortedList=" + originalListAfterSorting);
//        softAssert.assertAll();
    }

    @Test
    private static void javaStream() {

        //count total names which start with 'A/a'
        List<String> names = new ArrayList<String>();
        names.add("param");
        names.add("yash");
        names.add("nikhil");
        names.add("rishabh");
        names.add("ankit");
        names.add("aditya");
        int counter = 0;
        for (String name : names) {
            if (name.startsWith("a") || name.startsWith("A"))
                counter++;
        }
        System.out.println(counter);
    }

    @Test
    public void streamFilter() {
        List<String> names = new ArrayList<String>();
        names.add("param");
        names.add("yash");
        names.add("nikhil");
        names.add("rishabh");
        names.add("ankit");
        names.add("aditya");
        String arr[] = {"param", "rishabh", "yash", "aditya", "bharath"};
        List<String> li = Arrays.asList(arr);
//        List<String> li = Arrays.asList("param", "rishabh", "yash", "aditya", "bharath");

        Stream<String> st1 = names.stream(); //list to stream
        Stream<String> st2 = li.stream(); //string array to list and then to stream
        Stream<String> st3 = Stream.of("a", "b", "c"); //string directly into stream
        Stream<String> st4 = Arrays.asList(arr).stream(); // string array into stream

//        count total which starts with 'a || A'
        //method 1
//        int count = (int)names.stream().filter(s -> s.startsWith("a") || s.startsWith("A")).count();
//        System.out.println(count);

        //method 2 TODO
        long count = names.stream().filter(s -> {
            s.startsWith("a");
            return true;
        }).count();
        System.out.println(count);

        //print all the names having length greater than 4
        long count2 = names.stream().filter(s -> s.length() > 4).count();
        System.out.println(count2);
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        //get only the first result
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    //map implementations
    @Test
    public void mapInStream() {
        //map :: use for modifications
        String arr[] = {"param", "rishabh", "yash", "aditya", "bharath"};
        Stream<String> st = Arrays.asList(arr).stream();

        //print names which have last letter 'a'
//        st.filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //print all in UPPERCASE
//        st.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //sort stream
//        st.sorted().forEach(s -> System.out.println(s));

        //print starts with a and sorted
//        st.filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //merge two stream
        String arr1[] = {"aparam", "brishabh", "cyash", "daditya", "ebharath"};
        Stream<String> newSt = Stream.concat(st, Arrays.asList(arr1).stream());
//         newSt.sorted().forEach(s -> System.out.println(s));

        //match method
//        System.out.println(newSt.anyMatch(s -> s.equalsIgnoreCase("param")));

        //collect method :: converts stream into list
        //list-stream-operations-new list
        //direct
//        List<String> upperCaseList = new ArrayList<>();
//        st.map(s -> s.toUpperCase()).forEach(s -> upperCaseList.add(s));
        //using collect
        List<String> upperCaseList = newSt.filter(s -> s.length() > 4).sorted().map(s -> s.toUpperCase()).collect(Collectors.toList());

    }

    @Test
    public void printUnique() {
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 5);
        //print all the unique numbers and sort the array

        //using stream
        Stream<Integer> st = li.stream();
//        st.distinct().sorted().forEach(s-> System.out.println(s));
        //get 3rd index
//        List<Integer> sortedList = st.distinct().sorted().toList();
//        List<Integer> sortedList = st.distinct().sorted().collect(Collectors.toList());
//        System.out.println(sortedList.get(2));
        System.out.println(st.distinct().sorted().toList().get(2));


        /*
        // Step 1: Sort the array
        Arrays.sort(array);

        // Step 2: Print unique numbers
        System.out.print("Unique Numbers (Sorted): ");
        for (int i = 0; i < array.length; i++) {
            // Print the current number only if it's the first occurrence
            // or different from the previous number
            if (i == 0 || array[i] != array[i - 1]) {
                System.out.print(array[i] + " ");
            }
        }

        //using set
        int[] array = {5, 3, 8, 3, 1, 8, 7, 2, 5};
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : array) {
            uniqueNumbers.add(num);
        }
        List<Integer> sortedList = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedList);

        // Print unique and sorted numbers
        System.out.println("Unique Numbers (Sorted): " + uniqueNumbers);

        //using TreeSet
         Set<Integer> uniqueNumbers = new TreeSet<>();
        for (int num : array) {
            uniqueNumbers.add(num);
        }

        // Print unique and sorted numbers
        System.out.println("Unique Numbers (Sorted): " + uniqueNumbers);
         */

    }
}
