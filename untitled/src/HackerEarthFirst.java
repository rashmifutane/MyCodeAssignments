import java.util.Scanner;

public class HackerEarthFirst {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));
    }

    private static int solution(final int[] arr) {
        int highestCountIndex = 1;
        int highestCount = 1;
        for (int i = 0; i < arr.length; i++) {
            //for every index find out a cycle till it reaches to start
            int count = 1;
            int number = arr[i]; //3
            int nextIndex = arr[number -1];  //1

            int index=0;
            while (arr[i] != nextIndex && index < arr.length) {
                count++;
              index++;
                number = arr[index];
                nextIndex = arr[number -1];
            }
            if (highestCount < count) {
                highestCount = count;
                highestCountIndex = i + 1;
            }

        }
        return highestCountIndex;
    }


}
