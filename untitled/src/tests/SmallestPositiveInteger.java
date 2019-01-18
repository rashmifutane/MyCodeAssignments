package tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {

    // there can be negative numbers in array
    //first of all sort the array
    //case all negative then ans should be 1
    // negative positive in sequence in between missing element needs to be found
    // all in sequence then add 1 to the largest element

    public static void main(String[] args) {
      // final int[] ints = {1, 3, 6, 4, 1, 2};
        //final int[] ints = {-1,-3};
        final int[] ints = {1,2,3};
        System.out.println(solution1(ints));
    }

    public static int solution(int[] arr) {
        int smallestPositiveInt = 1;

        Arrays.sort(arr); // elements in the array will be sorted
        for (int i = 0; i < arr.length -2 ; i++) {

            while (i< arr.length-1 && arr[i+1] == arr[i] + 1 ) {
                i++;
            }
            if(i < arr.length && arr [i] > 0 ) {
                smallestPositiveInt = arr[i] + 1 ;
            }
        }

        return smallestPositiveInt;
    }
    public static int solution1(int[] arr) {
        int N = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
