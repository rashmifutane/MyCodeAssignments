package tests;

import java.util.Scanner;

public class sumOfSubArraysPerfectSquare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int countOfPerfectSquares = 0;
        for (int i = 0; i < arr.length; i++) {
            int sumOfSubArr = 0;
            for (int j = i; j < arr.length; j++) {
                sumOfSubArr += arr[j];
                if(isPerfectSquare(sumOfSubArr)) {
                    System.out.println(sumOfSubArr);
                    countOfPerfectSquares++;
                }
            }

        }
        System.out.println("count of perfect squares" +countOfPerfectSquares);
    }

    private static boolean isPerfectSquare(final int sumOfSubArr) {
        final double sqrt = Math.sqrt(sumOfSubArr);
        return sqrt - Math.floor(sqrt) == 0;
    }
}
