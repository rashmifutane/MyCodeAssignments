package client;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by futaner on 11/10/17.
 */
public class RepeatedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        System.out.println(getRepeatedStringLetterCount(n, s));
    }

    private static long getRepeatedStringLetterCount(long n, String s) {
        String repeatedString = "";
        while (repeatedString.length() < n) {
            if (repeatedString.length() + s.length() > n) {
                final int l = (int) n - repeatedString.length();
                repeatedString += s.substring(0, l);
            } else{
                repeatedString += s;
            }
        }

        System.out.println(repeatedString);

        final long count = repeatedString.chars().mapToObj(c -> (char) c).filter(c -> c != 'a').count();

        return count;
    }

}
