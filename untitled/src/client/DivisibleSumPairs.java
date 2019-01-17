package client;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by futaner on 05/10/16.
 */
public class DivisibleSumPairs {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int countOfDivisibleSumPairs =0;
            for(int i=0; i<n; i++){
                for(int j=i+1;j<n;j++){
                    if(isDivisibleByK(a[i]+a[j],k)) {
                        countOfDivisibleSumPairs++;
                    }
                }
            }
            System.out.printf("count Of Divisible Sum Pairs" + countOfDivisibleSumPairs);
        }

    /**
     * method to check if number is divisible by 3
     * @param num
     * @return
     */
    private static boolean isDivisibleByK(int num,int k){
        if(num % k == 0) {
            return true;
        }
        return false;
    }

}
