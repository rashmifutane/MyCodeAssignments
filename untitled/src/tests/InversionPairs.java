package tests;

public class InversionPairs {
    public static void main(String[] args) {
        final int[] ints = {-1, 6,3,4,7,4};
        // final int[] ints = {-1,-3};
        // final int[] ints = {1,2,3};
        System.out.println(solution(ints));
    }

    private static int solution(final int[] arr) {
        int countOfInversions = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                   // System.out.println("pair is (" + i + "," +j +")" );
                    countOfInversions++;
                    if (countOfInversions == 1000000000) {
                        countOfInversions = -1;
                        return countOfInversions;
                    }
                }
            }
        }
        return countOfInversions;
    }
}
