package client.test;

import java.util.Scanner;

/**
 * Created by futaner on 01/11/17.
 */
public class FlippingBits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfInputs = in.nextInt();
        long[] numbers = new long[noOfInputs];
        for (int i = 0; i < noOfInputs; i++) {
            numbers[i] = in.nextLong();
        }

        for (long number : numbers) {
            final String binaryString = Long.toBinaryString(number);
            System.out.println(binaryString);
            System.out.println(Long.toUnsignedString(~number));
        }
    }
}
