package client;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by futaner on 09/11/16.
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean[] resultsOfTestCases = new boolean[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            resultsOfTestCases[a0] = checkIfClassIsCancelled(a, k);
        }
        printResults(resultsOfTestCases);
    }

    private static boolean checkIfClassIsCancelled(int[] arr, int minReqStudents) {
        int onTimeStudents = 0;

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] <= 0) {
                onTimeStudents++;
            }
        }
        return onTimeStudents >= minReqStudents ? false : true;
    }

    private static void printResults(boolean[] resultOfTestCases) {
        for (boolean result : resultOfTestCases
             ) {
            System.out.println( result ? "YES" : "NO" );
        }
        //IntStream.range(0, resultOfTestCases.length).forEach(i -> resultOfTestCases[i]  ? System.out.println("YES") : System.out.println("NO"));
    }
}
