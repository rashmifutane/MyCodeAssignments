package tests;

import java.util.ArrayList;
import java.util.List;

public class TuplesOf737InString {

    public static void main(String[] args) {

        String s = "773377";
        //String s = "7377";

        //final Character[] characters = s.chars().mapToObj(c -> (char) c).toArray((int len) -> new Character[len]);
        final char[] chars = s.toCharArray();
        //Map<Integer, Integer[]> mapOfSequencec =
        List<Integer> indexesOf7 = new ArrayList<>();
        List<Integer> indexesOf3 = new ArrayList<>();


        for (int i = 0; i < chars.length; i++) {
            //put all the occurances of 7 in one array of map and 3 in one array of map
            if(chars[i] == '7') {
                indexesOf7.add(i);
            } else if (chars[i] == '3') {
                indexesOf3.add(i);
            }
        } //o(n)

        int numberOfPossibleTuples = 0;
        for (int i = 0; i < indexesOf7.size(); i++) {
            for (int j = i+1; j < indexesOf7.size() ; j++) {
                final Integer first7 = indexesOf7.get(i);
                final Integer second7 = indexesOf7.get(j);
                //now we need to find out number of 3 index array elements which fall under this range
                final long count = indexesOf3.stream().filter(a -> a > first7 && a < second7).count();
                numberOfPossibleTuples+=count;
            }

        }
        System.out.println(numberOfPossibleTuples);
    }
}
