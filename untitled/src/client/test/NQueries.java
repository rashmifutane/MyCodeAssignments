package client.test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NQueries {

    //first line gives u length of the array and number or queries

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] split = str.split(" ");
        int numberOfElementsInArray = Integer.parseInt(split[0]);              // Reading input from STDIN
        final int queries = Integer.parseInt(split[1]);
        int[] arr = new int[numberOfElementsInArray];
        int[] resultArr = new int[queries];
        int resultIndex=0;
        for (int i = 0; i < queries; i++) {
            str = s.nextLine();
            split = str.split(" ");
            //for every query it can be of type 1 or type 2
            final int type = Integer.parseInt(split[0]);

            switch (type) {
                case 1:
                    final int k = Integer.parseInt(split[1]); //set the value at index k to -1 and if
                    arr[k] = -1;
                    break;
                case 2:
                    final int y = Integer.parseInt(split[1]);
                    //print the index which is greater than or equal to y whose value is -1
                    // and if no such index exists then print -1
                    boolean foundOne=false;

                    final OptionalInt present = IntStream.range( y, numberOfElementsInArray).parallel().filter(index -> arr[index] == -1).findFirst();
                    if(present.isPresent())
                        resultArr[resultIndex++] = present.getAsInt();
//                    for (int j = y; j < numberOfElementsInArray ; j++) {
//                        if (arr[j] == -1) {
//                            resultArr[resultIndex++] = j;
//                            foundOne = true;
//                            break;
//                        }
//                    }
                        if (!foundOne) {
                            resultArr[resultIndex++] = -1;
                        }

                    break;
            }

        }

        Arrays.stream(resultArr).forEach(System.out::println);

    }
}
