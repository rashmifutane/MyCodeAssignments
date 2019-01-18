package tests;

import java.util.Scanner;

public class newYearChaosTry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++)
        {
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++)
                q[q_i] = in.nextInt();

            int bribe = 0;
            boolean chaotic = false;
            for(int i = 0; i < n; i++)
            {
                if(q[i]-(i+1) > 2)
                {
                    chaotic = true;
                    break;
                }
                for (int j = Math.max(0, q[i]-1-1); j < i; j++)
                    if (q[j] > q[i])
                        bribe++;
            }
            if(chaotic)
                System.out.println("Too chaotic");
            else
                System.out.println(bribe);
        }
        checkException(); //since runtime exception is thrown explicitly then also compiler did not bother to ask u to handle it or rethrow it
    }

    private static void checkException() {
        throw new RuntimeException();
    }
}
