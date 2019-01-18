package tests;

public class C extends B{

    public static void main(String[] args) {
        System.out.println("before");
        C c = new C();
        System.out.println("after");

    }
        public void run(final C c) {
            System.out.println("in C method");
        }
}
