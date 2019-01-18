package comparator;

import java.util.Comparator;

/**
 * Created by futaner on 01/08/17.
 */
public class IdNameComparator implements Comparator<Employee> {

    @Override
    public int compare(final Employee o1, final Employee o2) {

        final int nameComparisonResult = o1.getFirstName().compareTo(o2.getFirstName());
        if(nameComparisonResult == 0)
            return  Integer.compare(o1.getId(), o2.getId());
         else
            return nameComparisonResult;
    }
}
