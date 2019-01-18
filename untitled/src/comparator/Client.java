package comparator;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by futaner on 05/11/17.
 */
public class Client {

    @Test
    public void testHashSetFunctionality() {
        Set<Employee> employees = new HashSet<>();
        Map<Employee, Integer> employeeIntegerMap = new HashMap<>();

        final Employee e1 = new Employee();
        e1.setFirstName("abc");
        employees.add(e1);
        employeeIntegerMap.put(e1,1);

        final Employee e2 = new Employee();
        e2.setFirstName("xyz");
        employees.add(e2);
        employeeIntegerMap.put(e2,1);

        final Employee e3 = new Employee();
        e3.setFirstName("jklm");
        employees.add(e3);
        employeeIntegerMap.put(e3,1);

        System.out.println(employees.toString());
        System.out.println(employeeIntegerMap.toString());

    }


}
