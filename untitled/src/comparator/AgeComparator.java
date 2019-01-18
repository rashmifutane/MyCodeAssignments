package comparator;

import java8Streams.entity.Trader;

import java.util.Comparator;

/**
 * Created by futaner on 01/08/17.
 */
public class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(final Employee o1, final Employee o2) {
        if (o1.getAge() < o2.getAge())
                return -1;
        else if (o1.getAge() > o2.getAge())
            return 1;
        else return 0;
    }
}
