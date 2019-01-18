package tests;

/**
 * Created by futaner on 03/09/16.
 */
public class StairCase {

    @Test
    public void shouldNotAcceptCounterLessThan1(){

//        IntStream.ra(6, 0).forEach(index -> {
//            System.out.println();
//            IntStream.range(index, 0).forEach(in->{
//                System.out.print(" #");
//            });
//
//        });

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" #");
                System.out.println("");
            }
            System.out.println();
        }
    }


}
