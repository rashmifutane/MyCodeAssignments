package client;

import java.util.Scanner;

/**
 * Created by futaner on 14/11/16.
 */
public class ArrayLeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int newIndex = getNewIndexForElement(i, k, n);
            result[i] = a[newIndex];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }

    private static int getNewIndexForElement(int index, int k, int n) {
     return index+k < n ? index+k : (index+k)%n;
    }
}
