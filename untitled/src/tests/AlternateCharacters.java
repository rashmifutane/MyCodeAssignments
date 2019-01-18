package tests;

import java.io.IOException;
import java.util.Scanner;

public class AlternateCharacters {


    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int minimumNoOfDeletions = 0;
        final char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(i+1 < chars.length && chars[i] == chars [i+1]) {
                minimumNoOfDeletions++;
            }
        }
        return minimumNoOfDeletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
