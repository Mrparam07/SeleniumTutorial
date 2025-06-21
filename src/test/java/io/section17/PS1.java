package io.section17;

import org.testng.annotations.Test;

public class PS1 extends PS {

    @Test
    public void thisIsATest() {
        System.out.println("This is a test method in PS1 class.");
        printMessage(); // Calling the method from the parent class PS
        PS2 ps2 = new PS2(2);
        System.out.println(ps2.increment()); // Calling the method from PS2 class
//        System.out.println(ps2.decrement()); // Calling the method from PS2 class
//        System.out.println(ps2.multiplyTwo());
    }
}
