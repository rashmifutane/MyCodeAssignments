package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagram {

    //one string first get all the substrings of string
  //  abccda a b c c d a  number of repeated charater will be added as one pair
    //a b c c d a
    // ab ac ac ad aa


    public static void main(String[] args) {
        final int abba = sherlockAndAnagrams("cdcd");
        System.out.println(abba);

    }
    static int sherlockAndAnagrams(String s) {

        //find all the possible substrings and put it in map as key while adding only sort the array and save while saving check if already exists
        Map<String, Integer> possibleSubStrings = new HashMap<>();
        int countOfAnagrams = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length() ; j++) {
                String subStr = s.substring(i,j);
                System.out.println(subStr);
                final char[] a = subStr.toCharArray();
                if(subStr.length() > 1){
                    Arrays.sort(a);
                }
                final String key = new String(a);
                if(possibleSubStrings.containsKey(key)) {
                    possibleSubStrings.put(key, possibleSubStrings.get(key)+1);
                    countOfAnagrams++;
                } else {
                    possibleSubStrings.put(key,1);
                }
            }

        }
        //add frequencies of all
        return countOfAnagrams;
       //return possibleSubStrings.values().stream().reduce((e1, e2) -> e1+e2).get();

    }

}
