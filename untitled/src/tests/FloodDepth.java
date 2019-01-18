package tests;

public class FloodDepth {

    public static void main(String args[]) {
        System.out.println(solution(new int[]{1,3,2,1,2,1,5,3,3,4,2}));
    }

    public static int solution(int[] arr) {
        int maxDepth=0;
        // write your code in Java SE 8

        for (int i = 0; i < arr.length-2 ; i++) {
            if(arr[i] == arr[i+2] && maxDepth <  arr[i+1]) {
                maxDepth = arr[i+1];
            }
        }
        return maxDepth;
    }
}
