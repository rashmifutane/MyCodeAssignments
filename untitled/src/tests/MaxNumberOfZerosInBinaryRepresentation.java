package tests;

public class MaxNumberOfZerosInBinaryRepresentation {
    public static void main(String[] args) {
        System.out.println("max number of ones "+solution(1162));
    }

    public static int solution(int N) {
        // write your code in Java SE 8

        //while finding the binary representation find first 1 and then go on cunting 0s till u find 1 again //then mark that as max ones and always
        // check if maxones is smaller than current one
        int maxNumberOfOnes=0;
        int count=0;
        boolean oneFound=false;
        while(N>0) {
            int a = N % 2;
            System.out.print(a + " ");
            if(!oneFound && a == 1 && maxNumberOfOnes == 0){
                oneFound=true;
            } else if (oneFound && a == 0){
                count++;
            } else if(oneFound && a==1 && maxNumberOfOnes <= count){
                maxNumberOfOnes=count;
                count=0;
            }
            N=N/2;
        }
        System.out.println("sout" +( Math.floor(Math.log10(12345)) +1.0));
        return maxNumberOfOnes;

        }

}

