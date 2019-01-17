package client;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * Created by futaner on 02/09/17.
 */
public class ExecuteAroundPatternExample {

    @Test
    public void executeAround() {

        System.out.println(calculate((a,b) -> a+b));
        System.out.println(calculate((a,b) -> a/b));
        System.out.println(calculate((a,b) -> a-b));
        System.out.println(calculate((a,b) -> a*b));

    }

    @Test
    public void lambdaPractice() {

        final List<Apple> inventory = getInventory();

        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getType));

    }

    private List<Apple> getInventory() {
        List<Apple> inventory = new ArrayList<>();

        final Function<Integer, Apple> appleCreator = Apple::new;
        inventory.add( appleCreator.apply(10));
        inventory.add( appleCreator.apply(20));
        inventory.add( appleCreator.apply(5));
        inventory.add( appleCreator.apply(12));
        return inventory;
    }

    private int calculate( Calculator c) {

         return c.process(2,3);
    }

}
