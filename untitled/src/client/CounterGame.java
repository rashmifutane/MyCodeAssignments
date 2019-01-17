package client;

/**
 * Created by futaner on 03/09/16.
 */
public class CounterGame {

//    public String getWinnerOfTheCounterGame(Unsigned long cnt){
//
//        while(cnt > 1){
//            //if counter a power of two then reduce it to half
//            if(cnt & (cnt-1) == 0){
//                cnt = cnt/2;
//            } else {  // substract highest power of 2 less than counter from counter
//                while()
//            }
//        }
//        return null;
//
//    }
static String s="sds";

    public static void main(String[] args) {
        String s="sdswedwe";
        System.out.println(s);
        System.out.println(testMethod());
        foo f = new foo();
        String f1="foo";
        //System.out.println(f1 instanceof foo);
        for (int i = 0; i <3 ; i++) {
            switch (i){
                case 0:break;
                case 1:
                    System.out.println("one");
                case 2:
                    System.out.println("two");
                case 3:
                    System.out.println("three");
            }

        }

        //bar b = f.new bar();

    }
    public static void main(int args[]){
        System.out.println("in int method");
    }

    static class foo{

        void method(){
            String s="wdew";
        }
        class bar{}
    }
    private static int testMethod(){
        try{
            throw new RuntimeException();
        }catch (Exception e) {
            return 1;
        }finally {
            return 2;
        }
    }

}
