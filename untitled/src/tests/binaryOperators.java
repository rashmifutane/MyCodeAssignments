package tests;

import java.util.Scanner;

/**
 * Created by futaner on 12/04/18.
 */
public class binaryOperators {

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int testCases = Integer.parseInt(s.next());                 // Reading input from STDIN


        for (int i = 0; i < testCases ; i++) {

            int x = Integer.parseInt(s.next());

            //finding out the number of bits set in the binary representation of the number

             int count=0;
            if(x == 0) {
                System.out.println(0);
            } else {
                while ( x != 0) {
                    x = (x & (x-1));
                            count++;
                }
                System.out.println(count);
            }
        }
    }


}
