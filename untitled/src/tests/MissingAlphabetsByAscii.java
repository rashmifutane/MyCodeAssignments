package tests;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingAlphabetsByAscii {

    public static void main(String[] args) {

           int MIN_ASCII = 97;
           int MAX_ASCII = 122;

       String sentence = "i am rashmi";
       // String sentence = "I AM RASHMI";
        final Set<Character> existingAlphabets = sentence.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        final Set<Character> missingAlphabets = new HashSet<>();
        if(existingAlphabets.size() == 27) {
            System.out.println("all are present");
            return;
        }
        for (int i = MIN_ASCII; i <= MAX_ASCII ; i++) {

            if(! existingAlphabets.contains((char)i)) {
                missingAlphabets.add((char)i);
            }
        }
        existingAlphabets.stream().forEach(System.out::print);
        System.out.println();
        missingAlphabets.stream().forEach(System.out::print);
    }
}
