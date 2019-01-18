package comparator;

import org.fun.movies.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * Created by futaner on 01/08/17.
 */
public class EmployeeClient {

    public static void main(String args[]) {
        List employees = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setAge(300);
        employee.setId(3);
        employees.add(employee);

        employee = new Employee();
        employee.setAge(10);
        employee.setId(1);
        employees.add(employee);


        employee = new Employee();
        employee.setAge(20);
        employee.setId(2);
        employees.add(employee);

        Collections.sort(employees, Collections.reverseOrder(new IdComparator()));


        Comparator<Employee> comparator =
                comparingInt(Employee::getAge).thenComparing(Employee::getFirstName);


        System.out.println(employees);


    }
}
