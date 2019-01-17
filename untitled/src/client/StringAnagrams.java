package client;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringAnagrams {

    public static int numberNeeded(String first, String second) {
        int minNumOfDeletions = 0;
        //strings can be of different lengths so iteration should be done on larger string
        if (first.length() == second.length()){
            for (int i = 0; i < first.length() ; i++) {
                if (!second.contains(""+first.charAt(i))){
                    minNumOfDeletions+=getCountOfChar(first.charAt(i), first);
                }
            }
        }
        else if (first.length() > second.length()) {
                for (int i = 0; i < second.length() ; i++) {
                    if (!first.contains(""+second.charAt(i))){
                        //get the count of character in second
                        minNumOfDeletions+=getCountOfChar(first.charAt(i), first);
                    }
                }
           // minNumOfDeletions+=first.length()-second.length();
        }else{
            for (int i = 0; i < first.length() ; i++) {
                if (!second.contains(""+first.charAt(i))){
                    minNumOfDeletions+=getCountOfChar(first.charAt(i), first);
                }
            }
            //minNumOfDeletions+=second.length()-first.length();
        }

        return minNumOfDeletions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    private static int getCountOfChar(char character, String first) {
        int countOfCharacters=0;
        for (char firstChar: first.toCharArray()
             ) {
            if(firstChar == character)
            countOfCharacters++;
        }
        return countOfCharacters;
    }

//    private static String findLargestString(String first, String second) {
//        if (first.length() == second.length())
//            return first;
//        else if (first.length() > second.length())
//            return first;
//        else
//            return second;
//    }
}