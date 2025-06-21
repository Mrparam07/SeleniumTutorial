package io.section17;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up before each test method in PS class.");
    }
    public void printMessage() {
        System.out.println("This is a method in the PS class.");
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down after each test method in PS class.");
    }
}
