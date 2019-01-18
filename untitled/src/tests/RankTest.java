package tests;


import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class RankTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));
            System.out.println(result[i]);
        }

        scanner.close();
        System.out.println("[kajsndk]".replace("\\[|\\]", ""));
    }

    private static int[] climbingLeaderboard(final int[] scores, final int[] alice) {

        TreeSet<Integer> scoreRanks = new TreeSet<>(Collections.reverseOrder());
        //index in the set of the element will be the rank
        for (int i = 0; i < scores.length; i++) {
            scoreRanks.add(scores[i]);
        }

        final int[] aliceRanks = new int[alice.length];
        int aliceRankIndex = 0;
        for (int i = 0; i < alice.length; i++) {
            scoreRanks.add(alice[i]);
            aliceRanks[aliceRankIndex++] = scoreRanks.headSet(alice[i]).size()+1;
            scoreRanks.remove(alice[i]);
        }

        return aliceRanks;
    }

}
