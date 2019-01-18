package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommonChild {

    static int commonChild(String s1, String s2) {

        final int childLength1 = getChildLength(s1, s2);
        final int childLength2 = getChildLength(s2, s1);

        return Math.max(childLength1, childLength2);
    }


    private static int getChildLength(final String s1, final String s2) {
        final char[] s1Chars = s1.toCharArray();
        final char[] s2Chars = s2.toCharArray();


        List<List<Character>> possibleChilds = new ArrayList<>();
        int matchIndex=0;
        for (int k = 0; k <s1Chars.length; k++) {
            List<Character> childArray = new ArrayList<>();
            for (int i = k; i < s1Chars.length; i++) {
                //s1[i] is contained in any index of j which is next to i
                for (int j = matchIndex != 0 ? matchIndex : i; j < s1Chars.length; j++) {
                    if (s1Chars[i] == s2Chars[j] && !childArray.contains(s1Chars[i])) {
                        childArray.add(s1Chars[i]);
                        matchIndex = j;
                        break;
                    }
                }
               continue;
            }
            if (childArray.size() > 0) {
                possibleChilds.add(childArray);
                matchIndex = 0;
            }
        }
        final Optional<List<Character>> max = possibleChilds.stream().max(Comparator.comparing(c1 -> c1.size()));
         if(max.isPresent())
             return max.get().size();
         else return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
