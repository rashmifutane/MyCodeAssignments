package tests;

public class RandomTests {


}

class Test implements Runnable
{
   public void run()
   {
       System.out.println("r1 ");
       System.out.println("r2 ");
       notifyAll();
   }

   public static void main( String[] args )
   {
       Thread t = new Thread(new Test());
       t.start();
       System.out.println("m1 ");
       //t.join();

       System.out.println("m2 ");
   }
}


class access{
    public int x;
    private int y;
    void cal(int a, int b){
        x =  a + 1;
        y =  b;
    }
}

class access_specifier {
    public static void main(String args[])
    {
        access obj = new access();
        obj.cal(2, 3);
    //    System.out.println(obj.x + " " + obj.y);
    }
}
