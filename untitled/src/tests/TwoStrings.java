package tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwoStrings {

    public static void main(String[] args) throws IOException {

       // create  a test case loop to scan the elements
        Scanner s = new Scanner(System.in);
        int numberOfTestCases = s.nextInt();

        //inoutArray
        for (int i = 0; i < numberOfTestCases; i++) {
            String s1 =  s.next();
            String s2 =  s.next();
                System.out.println(getTheResult(s1, s2) == true ? "YES" : "NO");
        }


    }

    private static boolean getTheResult(String s1, String s2)  {

        final char[] a = s1.toCharArray();
        Arrays.sort(a);
        final char[] a1 = s2.toCharArray();
        Arrays.sort(a1);
        return Arrays.equals(a,a1);
    }

}
