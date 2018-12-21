import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DNAImpactFactor {

    public static void main(String[] args) {
        final int[] cagcctas = solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
        Arrays.stream(cagcctas).forEach(System.out::println);
    }


    public static int[] solution(String s, int[] p, int[] q) {
        int[] result = new int[p.length];

        Map<Character, Integer> mapOfImpactValues = new HashMap();
        mapOfImpactValues.put('A', 1);
        mapOfImpactValues.put('C', 2);
        mapOfImpactValues.put('G', 3);
        mapOfImpactValues.put('T', 4);

        //need to get substring of s from p[i] to q[i] and find value of impact factor
        for (int i = 0; i < p.length; i++) {
            final String substring = s.substring(p[i], q[i]+1);

             result[i]  = getInteger(mapOfImpactValues, substring);
        }
        return result;
    }

    private static Integer getInteger(final Map<Character, Integer> mapOfImpactValues, final String substring) {

      //  Map<Character, Integer> charValues = new HashMap<>();
        return substring.chars().mapToObj(c -> (char)c).parallel().map(c -> mapOfImpactValues.get(c)).min(Integer::compareTo).get();
    }
}