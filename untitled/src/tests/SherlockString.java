package tests;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SherlockString {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        //preapare a map of every character and freq if all are same print yes and if there is a diff of one in only one then ptint yes

        String s = scanner.nextLine();
        String result = isValid(s);
        System.out.println(result);

        scanner.close();
    }

    static String isValid(String s) {


            final Stream<Character> characterStream = s.chars().mapToObj(c1 -> (char) c1);
            final Map<Character, Long> mapOfFreq = characterStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //now check if all the frequencies are matching
        final List<Long> distinct = mapOfFreq.values().stream().distinct().collect(Collectors.toList());
        if (distinct.size() > 2 ) {
            return "NO";
        } else if (distinct.size() == 2) {
            final int noOfOccurancesOf1 = getNoOfOccurancesOf(distinct.get(0), mapOfFreq);
            final int noOfOccurancesOf2 = getNoOfOccurancesOf(distinct.get(1), mapOfFreq);

            long minFreq=distinct.get(0);
            long maxFreq=distinct.get(1);
            int noOfOccurancesOfMinFreq = noOfOccurancesOf1;
            if(noOfOccurancesOf2 < noOfOccurancesOf1) {
                minFreq=distinct.get(1);
                maxFreq=distinct.get(0);
                noOfOccurancesOfMinFreq = noOfOccurancesOf2;
            }
            if(noOfOccurancesOf1 == noOfOccurancesOf2  ) { //both the frequencies are there equal no of times that means its not possible to delete one character and make it perferct string
                return "NO";
            } else if(Math.abs(maxFreq-minFreq) == 1 && noOfOccurancesOfMinFreq == 1) {
                return "YES"; }
                else if(noOfOccurancesOfMinFreq ==1 && minFreq == 1){
                  return "YES";
            } else {
                return "NO";
            }

        } else {
            return "YES";
        }
    }

    private static int getNoOfOccurancesOf(final long integer, final Map mapOdFreq) {
        return Collections.frequency(mapOdFreq.values(), integer);
    }
}
