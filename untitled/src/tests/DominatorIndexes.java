package tests;

import java.util.HashMap;
import java.util.Map;

public class DominatorIndexes {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,4,3,6,3,3}));
    }
    public static int solution(int[] arr) {

        int indexOfDominator = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                final int value = map.get(arr[i]) + 1;
                map.put(arr[i], value);
                if (value > arr.length / 2) {
                    indexOfDominator = i;
                }

            } else {
                map.put(arr[i], 1);
            }
        }

        return indexOfDominator;
    }


}
