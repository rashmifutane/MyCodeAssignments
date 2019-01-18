package tests;

import java.util.Scanner;

public class hackerearthProblem {

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int testCases = Integer.parseInt(s.next());

        for (int i = 0; i < testCases ; i++) {
            int x = Integer.parseInt(s.next());

        }

//        int countOfMaxIndex=10;
//        int[] arr = {1,1,30,40,90,1,-8, 10,100000, 200};
//        int[] arr1 = arr.clone();
//
//        Map arrMap = new HashMap();
//        arrMap
//
//        Arrays.sort(arr);
//        arr[0] arr[arr.length-1]

        int countOfMaxIndex=0;
        int[] arr = {1,1,30,40,90,1,-8, 10,100000, 200};
        for(int i=0; i<arr.length ;i++){
            for(int j=arr.length-1; j>i; j--) {

                if(arr[i] < arr[j] && i<j) {
                    if(countOfMaxIndex < j-i+1) {
                        countOfMaxIndex = j;
                    }
                }
            }
        }
        System.out.println(countOfMaxIndex);
    }




}
