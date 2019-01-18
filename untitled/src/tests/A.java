package tests;

public class A {

    static {
        System.out.println("in static block of A");
    }

    public A() {
        System.out.println("in constructor of A");
    }

    public void run(final A a) {
            System.out.println("in A method");
    }
}

