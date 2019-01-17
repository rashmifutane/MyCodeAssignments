package client.test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LunchyUnLuckyArray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n ; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(solution(arr));
        }

        scanner.close();
    }

    private static String solution(final int[] arr) {
        //we can put the elements and frequencies in tree map and get first elements freq if its odd then lucky or unlucky
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        if(((TreeMap<Integer, Integer>) map).firstEntry().getValue() % 2 == 1 )
            return "Lucky";
        else
            return "Unlucky";
    }


}
