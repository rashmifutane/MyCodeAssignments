package tests;

import java.util.Scanner;

public class NewYearChaos {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

    static void minimumBribes(int[] q) {
        //first of all find out if the total chaotic situation is there and if so then stop right there
        for (int i = 0; i <q.length ; i++) {
            int expectedIndex = q[i]-1;
            int actualIndex = i;
            if(Math.abs(actualIndex - expectedIndex ) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int noOfSwaps=0;
        for (int i = 0; i <q.length ; i++) {
            int expectedIndex = q[i]-1;
            int actualIndex = i;
            if(expectedIndex != actualIndex) {
                noOfSwaps += Math.abs(actualIndex-expectedIndex);
            }
        }

        System.out.println(noOfSwaps / 2);
    }
}
