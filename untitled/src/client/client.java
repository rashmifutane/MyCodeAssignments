package client;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by futaner on 07/12/16.
 */
public class client {

    public static void main(String args[]) {
           String s= "one Two Three TEN";
        Map<String,Integer> mapOfNumbers = new HashMap<>();
        int sum=0;
        mapOfNumbers.put("one",1);
        mapOfNumbers.put("two",2);
        mapOfNumbers.put("three",3);
        mapOfNumbers.put("four",4);
        mapOfNumbers.put("five",5);
        mapOfNumbers.put("six",6);
        mapOfNumbers.put("seven",7);
        mapOfNumbers.put("eight",8);
        mapOfNumbers.put("nine",9);
        mapOfNumbers.put("ten",10);

        String[] array = s.split(" ");

        for (String str: array
             ) {
            sum += mapOfNumbers.get(str.toLowerCase());
        }

        System.out.println(sum);

        final List<Integer> integers1 = Arrays.asList(1, 2, 3);
        final List<Integer> integers2 = Arrays.asList( 4, 5);

        integers1.stream().flatMap(a -> integers2.stream().filter(b-> (a+b)%3==0).map(b -> new int[]{a,b}))
                .collect(Collectors.toList());


        integers1.stream().map(a -> a * a).distinct().collect(Collectors.toList());
        //intStream.collect(Collectors.toCollection(ArrayList::new));

    }

}
