package client.test;

import sort.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class MaxCounterCodility {


    public static void main(String[] args) {
        solution(5, new int[]{3,4,4,6,1,4,4});
    }

    public static int[] solution(int N, int[] arr) {
        int[] result = new int[N];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= N) {
                result[arr[i]-1]+= 1;
            } else {
                final int maxCount = Arrays.stream(result).parallel().max().getAsInt();
                Arrays.fill(result, maxCount);
            }

            System.out.println();
            Arrays.stream(result).forEach(System.out::print);
        }

        return result;
    }
}
