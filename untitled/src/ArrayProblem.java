import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by futaner on 04/11/17.
 */
public class ArrayProblem {

    @Test
    public void shouldGetCommonIntegersInArrayInSortedOrder() {

        int[] array1 = new int[]{5, 2, 1, 107, 20,93, 88, 100};
        int[] array2 = new int[]{100, 65, 12, 34, 5, 2, 99, 100, 107};
        int[] result = new int[10];
        int k=0;
        for (int i = 0; i <array1.length ; i++) {
            for (int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) {
                    result[k]=array1[i];
                    k++;
                }
            }
        }
        Arrays.sort(result);

        for (int i = 0; i < result.length ; i++) {
            System.out.print(result[i] != 0 ? result[i]+",":"" );
        }
        System.out.println(result.toString());
    }
}
