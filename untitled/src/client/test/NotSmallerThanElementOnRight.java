package client.test;

import java.io.IOException;
import java.util.Scanner;

public class NotSmallerThanElementOnRight {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = scanner.nextInt();
        }

        solution(arr);
        //final int[] solution = solution(arr);
        //Arrays.stream(solution).forEach(System.out::print);

        scanner.close();
    }

    private static void solution(final int[] arr) {
        for (int i = 0; i < arr.length  ; i++) {
            //print the result in here only so that we avoid one loop
            boolean greater = true;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    greater = false;
                    break;
                }
            }
            System.out.print(greater ? arr[i]+ " " : "");

        }


    }
}
