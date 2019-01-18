package tests;

import java.io.IOException;
import java.util.Scanner;

public class PairTest {


    static int pairs(int k, int[] arr) {

        int numberOfPairs=0;
        for (int i = 0; i < arr.length; i++) {
            //every element of the array needs to be compared to every other element of array
            for (int j = i+1; j < arr.length; j++) { // here the pair counted once should not be repeated
                if(Math.abs(arr[i] - arr[j]) == k) {
                    numberOfPairs++;
                }
            }
        }

//        Arrays.stream(arr).parallel().forEach(e -> {
//            for (int j = i+1; j < arr.length; j++) { // here the pair counted once should not be repeated
//                if(Math.abs(e - arr[j]) == k) {
//                    numberOfPairs++;
//                }
//            }
//        });

        return numberOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        final String s = "[kajsndk]".replaceAll("\\[|\\]", "");
        System.out.println("string replacement"+ s);
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
