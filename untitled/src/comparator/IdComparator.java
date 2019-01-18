package comparator;

import java.util.Comparator;

/**
 * Created by futaner on 01/08/17.
 */
public class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(final Employee o1, final Employee o2) {
        if (o1.getId() < o2.getId())
            return -1;
        else if (o1.getId() > o2.getId())
            return 1;
        else return 0;
    }
}
