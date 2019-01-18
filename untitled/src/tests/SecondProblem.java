package tests;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SecondProblem {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        int arr[] = { 7 ,1, 2, 4, 6, 5, 3, 8, 9, 10  };
        int size = arr.length;
        int ans = calculateMaxSumLength(arr, size);
        System.out.println("Max Length :: " + ans);
    }


    static int calculateMaxSumLength(int arr[], int n) {
        final int length=0;

int[] arr1 = arr;
    findSmallestElementInArray(arr);
        final int start = arr1[0];
        Set<Integer> set= new HashSet<>();
        set.add(arr1[0]);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==start) {//start from here{}
                for (int j = i; j < arr.length; j++) {
                    if(arr[j]>start && checkIfGreaterThanAll(set, arr[j])) {
                        set.add(arr[j]);
                    }
                }
            }
                else
                    continue;
        }

int cnt=0;
        for (int i=0; i<n; i++)
        {
            // Pick ending point
            for (int j=i+1; j<n; j++)
            {
                if (arr[j] > arr[j-1])
                    cnt++;

                    // If subarray arr[i..j] is not strictly
                    // increasing, then subarrays after it , i.e.,
                    // arr[i..j+1], arr[i..j+2], .... cannot
                    // be strictly increasing
                else
                    break;
            }
        }

      //  return set.size();
return cnt;
    }

    private static void findSmallestElementInArray(final int[] arr) {

    }

    private static boolean checkIfGreaterThanAll(final Set<Integer> set, final int i) {
        final Iterator<Integer> iterator = set.iterator();
        boolean greater=true;
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            if(next>i){
                greater=false;
            }
        }
        return greater;
    }
//        int ans = 0; // final sum of lengths
//
//        // number of elements in current subarray
//        int count = 0;
//
//        // variable for checking if k appeared in subarray
//        int flag = 0;
//
//        for (int i = 0; i < n;) {
//            count = 0;
//            flag = 0;
//
//            // count the number of elements which are
//            // less than equal to k
//            while (i < n && arr[i] <= k) {
//                count++;
//                if (arr[i] == k)
//                    flag = 1;
//                i++;
//            }
//
//            // if current element appeared in current
//            // subarray add count to sumLength
//            if (flag == 1)
//                ans += count;
//
//            // skip the array elements which are
//            // greater than k
//            while (i < n && arr[i] > k)
//                i++;
//        }
//        return ans;
//    }
}
