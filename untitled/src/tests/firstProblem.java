package tests;

import java.io.IOException;
import java.util.Scanner;

public class firstProblem {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

       // final int abs = (int) Math.abs(3.14);
      //  System.out.println(abs);


        //create  a test case loop to scan the elements
//        int numberOfTestCases=3;
//        //inoutArray
//        for (int i = 0; i < numberOfTestCases; i++) {
//            //scan the intput
//            //put it in thr input array
//        }
//
//        //run another loop to print the result
//        for (int i = 0; i < numberOfTestCases; i++) {
//            getTheResult();
//            //print the result
//        }
        final equality equality = new equality();
        equality.x=5;
        equality.y=5;
        System.out.println(equality.isEqual());
    }


    private static void getTheResult() {


    }

    public static class equality{
        int x;
        int y;
        public boolean isEqual(){
            return x==y;
        }
    }
}
