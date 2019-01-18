package java8Streams.test;

import java8Streams.entity.Trader;
import java8Streams.entity.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by futaner on 30/09/17.
 */
public class StreamTest {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950)
    );

    @Test
    public void shouldGellTransactionsIn2011InSortedOrder() {
        transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    @Test
    public void shouldReturnUniqueCities() {
        transactions.stream().map(t -> t.getTrader().getCity()).distinct()
                .forEach(System.out::println);
    }

    @Test
    public void shouldReturnSortedTradersNamesFromCambridge() {
        transactions.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).distinct()
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
    }

    @Test
    public void shouldReturnTraderNamesAsOneStringSortedAlphabetically() {
        System.out.println(transactions.stream().map(t -> t.getTrader().getName()).sorted().reduce("", (n1, n2) -> n1 + n2));
        String s1= new String("hello");
        s1.intern();
        String s2="hello";
        System.out.println(s1==s2);


    }

    @Test
    public void shouldCheckIfAnyTraderBasedInMila() {
        System.out.println(transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equals("Milan")));
        System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
    }

    @Test
    public void shouldReturnTransactionValuesOfTradersInCambridge() {
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).forEach(System.out::println);
    }

    @Test
    public void shouldReturnHighestValueOfTransaction() {
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max));
        System.out.println(transactions.stream().max(Comparator.comparing(Transaction::getValue)));
    }

    @Test
    public void shouldReturnSmallestValueOfTransaction() {
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::min));
        System.out.println(transactions.stream().min(Comparator.comparing(Transaction::getValue)).get().getValue());
    }

}