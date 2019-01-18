package tests;

public class B extends A{


    static {
        System.out.println("in static block of B");
    }

    public B() {
        System.out.println("in constructor of B");
    }

        public void run(final B b) {
            System.out.println("in B method");
        }

}
