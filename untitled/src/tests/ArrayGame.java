package tests;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class ArrayGame {

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        String numbers = s.nextLine();
        final String[] split = numbers.split(" ");
        final int m = Integer.parseInt(split[0]);
        final int n = Integer.parseInt(split[1]);

        //  final int m = 6;
       // final int n = 4;

        String arrayAString = s.nextLine();
        Integer[] arrayA=new Integer[m];

        final String[] split1 = arrayAString.split(" ");
        for(int i=0; i< split1.length;i++) {
            arrayA[i]=Integer.parseInt(split1[i]);
        }

        String arrayBString = s.nextLine();
        Integer[] arrayB=new Integer[n];
        final String[] split2 = arrayBString.split(" ");
        for(int i=0; i< split2.length;i++) {
            arrayB[i]=Integer.parseInt(split2[i]);
        }


        //Collections.sort(Arrays.asList(arrayA)); //uses merge sort internally
        //Collections.sort(Arrays.asList(arrayB)); //uses merge sort internally

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int min=0;
        for(int i=0,j=n-1;i<m&&j>=0;i++,j--){
            if(arrayA[i]<arrayB[j]){
                min+=abs(arrayA[i]-arrayB[j]);
            }
        }

        System.out.println(min);

    }
}
