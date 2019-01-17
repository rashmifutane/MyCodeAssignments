package client;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by futaner on 01/03/17.
 */
public class Anagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    private static int numberNeeded(String a, String b) {

        Map<Character, Long> str1Content = getStringCharactersMap(a);
        Map<Character, Long> str2Content = getStringCharactersMap(b);
        final int countOfDeletions = getCountOfDeletions(str1Content, str2Content);
        return countOfDeletions;
    }

    private static int getCountOfDeletions(final Map<Character, Long> str1Content, final Map<Character, Long> str2Content) {
        int countOfDeletions = 0;
        if(str1Content.keySet().size() > str2Content.keySet().size()) {
            countOfDeletions = getCountOfDeletions(str1Content, str2Content, countOfDeletions);
        } else {
            countOfDeletions = getCountOfDeletions(str2Content, str1Content, countOfDeletions);
        }
        return countOfDeletions;
    }

    private static int getCountOfDeletions(final Map<Character, Long> str1Content, final Map<Character, Long> str2Content, int countOfDeletions) {
        for (char c: str1Content.keySet()) {
                if (str1Content.get(c) == str2Content.get(c)) {
                    str2Content.put(c, 0L); //mark the value in other map 0;
                } else if (str2Content.get(c)!=null && str1Content.get(c) != str2Content.get(c)) {
                    countOfDeletions += Math.abs(str1Content.get(c) - str2Content.get(c));
                    str2Content.put(c, 0l);
                } else {
                    countOfDeletions += str1Content.get(c);
                }
        }
        ;
        for (char c : str2Content.keySet()) {
            countOfDeletions += str2Content.get(c);
        }
        return countOfDeletions;
    }

    private static Map<Character, Long> getStringCharactersMap(final String a) {
        return a.chars().mapToObj(c1 -> (char) c1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}


