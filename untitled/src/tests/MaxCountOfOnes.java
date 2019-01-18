package tests;

public class MaxCountOfOnes {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,0,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0,0};
int maxCounter=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1) {
                int numberOfOccurances=0;
                while (arr[i]==1) {
                    numberOfOccurances++;
                    i++;
                }
                //coming out of while loop means 0 is found in array
                maxCounter=numberOfOccurances;
            }
        }
        System.out.println(maxCounter);
    }
}
