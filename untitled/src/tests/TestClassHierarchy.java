package tests;

public class TestClassHierarchy {


    public static void main(String[] args) {
       final A c = new C();
       final B b = new C();

        c.run(c);
        b.run(b);
    }
}
