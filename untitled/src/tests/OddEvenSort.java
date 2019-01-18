package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by futaner on 15/04/18.
 */
public class OddEvenSort {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int  numberOfTestCases = Integer.parseInt(s.nextLine());

        List<String[]> inputs = new ArrayList<>();
        for (int k = 0; k < numberOfTestCases ; k++) {
            int  n = Integer.parseInt(s.nextLine());
            final String[] split = s.nextLine().split(" ");
            inputs.add(split);
        }
        for (int k = 0; k < numberOfTestCases ; k++) {
            final int[] oddEven = getOddEven(inputs.get(k).length, inputs.get(k));
            for (int i = 0; i < oddEven.length; i++) {
                System.out.print(oddEven[i]+ " ");
            }
            System.out.println();
        }
    }

    private static int[] getOddEven(final int n, final String[] split) {
        int[] arr = new int[n];
        int[] oddEvenArr = new int[n];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);
        int oddEvenArrIndex=0;
        for (int i = 0, j=n-1; i < n && j>=0 && i<j; i++, j--) {

                oddEvenArr[oddEvenArrIndex] = arr[i];
                oddEvenArrIndex++;
                oddEvenArr[oddEvenArrIndex]= arr[j];
                oddEvenArrIndex++;
        }
       return oddEvenArr;
    }
}
