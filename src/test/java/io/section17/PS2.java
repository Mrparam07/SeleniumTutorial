package io.section17;

public class PS2 extends PS3 {

    int a; //class variable
    public PS2(int a) { //instance variable
//        this.a = a; //this refers current class variables, method or ?
        super(a); // Call the constructor of the parent class PS3 (duty is to invoke the super class constructor) and only used when inheriting from another class
        this.a = a; // Assigning the value to the instance variable of PS2
    }

    public int increment() {
        return ++a;
    }

    public int decrement() {
        return --a;
    }
}
