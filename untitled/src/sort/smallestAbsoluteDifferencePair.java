package sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class smallestAbsoluteDifferencePair {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");



        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[arrItems.length];
        for (int i = 0; i < arrItems.length; i++) {
            if(arrItems[i] != "" || arrItems[i] != null){
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }

    static int[] closestNumbers(int[] arr) {
        int[] result = new int[arr.length*2];
        Arrays.sort(arr);
        int resultIndex=0;
        int smallestDiff = arr[1]-arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]-arr[i] < smallestDiff) {
                result = new int[arr.length];
                resultIndex=0;
                smallestDiff = arr[i+1]-arr[i];
                result[resultIndex++] = arr[i];
                result[resultIndex++] = arr[i+1];
            } else if(smallestDiff ==  arr[i+1]-arr[i]){
                result[resultIndex++] = arr[i];
                result[resultIndex++] = arr[i+1];
            }
        }

        return removeZeroElements(result);
    }

    private static int[] removeZeroElements(final int[] result) {

        return Arrays.stream(result).filter(val->val!=0).toArray();
    }

}
