import java.util.Scanner;

public class KJumps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int k = sc.nextInt();
        final int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, k));
    }

    private static int solution(final int[] arr, final int k) {
       int longestSequenceOfJumps = 1;
       //need to find out j where a[j]-a[i]>=k a[j]>=a[i]+k
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(  k <= arr[j] - arr[i] && j>i) {
                    //System.out.println(arr[i]);
                   // System.out.println(arr[j]);
                    i = j;
                    longestSequenceOfJumps++;
                }
            }

        }
        return longestSequenceOfJumps;
    }


}
