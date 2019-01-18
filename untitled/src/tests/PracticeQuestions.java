package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class PracticeQuestions {
    public static void main(String[] args) {

        System.out.println();
       Arrays.stream(new int[]{4, 7, 10, 13}).filter(a -> a > 10).average().ifPresent(System.out::println);
        final boolean b = false ^ false;
        final boolean b1 = true ^ false;
        final boolean b2 = true ^ true;
        final boolean b3 = false ^ true;
        System.out.println("xor operator " + b +" "+b1 +" "+b2+ " "+ b3);
        List<String> list = Arrays.asList("burger", "prqw","dqre","burger");
        final HashSet<String> strings = new HashSet<>(list);
        final TreeSet<String> strings1 = new TreeSet<>(list);
        System.out.println(strings.equals(strings1));

        List<String> integers = new ArrayList<>();

      //  integers.add(5,"10");
        try {
            System.out.println("intergers " +integers);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("exception occured");
        }

        String s = "abbcdeef";
        Map<Character, Integer> map = new LinkedHashMap<>();
//        s.chars().mapToObj(c-> (char)c).
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], 1);
        }

        System.out.println("map is " +  map);


        int i=0;
        i++;
        i++;
        i++;
        i++;

        System.out.println("value of i " + i);

        List<Integer> ints = new CopyOnWriteArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        final Iterator<Integer> iterator = ints.iterator();
        ints.remove(1);
        while (iterator.hasNext())
            System.out.println(iterator.next());

        try {
            throw new RuntimeException("thrown excepion");
        }finally {
            System.out.println("executed finally");
        }






    }




}
