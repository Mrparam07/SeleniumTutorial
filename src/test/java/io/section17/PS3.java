package io.section17;

public class PS3 {
    int a;

    public PS3(int a) {
        this.a = a; // 'this' refers to the current instance variable
    }
    public int multiplyTwo() {
        return a*2;
    }
    public int multiplyThree() {
        return a*3;
    }
}
