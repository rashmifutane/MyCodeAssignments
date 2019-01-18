package tests;

import org.fun.office.Employee;
import org.fun.office.Gender;
import org.fun.util.PrettyPrint;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by futaner on 02/12/16.
 */
public class StreamsTest {

    private static Stream<Employee> employeeStream() {return Employee.getEmployees().stream();}
    @Test
    public void test1(){

        final Function<Employee, LocalDate> getDateOfJoining = Employee::getDateOfJoining;
        List<LocalDate> dateOfJoining = employeeStream()
                .map(getDateOfJoining)
                .collect(Collectors.toList());

        PrettyPrint.list(dateOfJoining);


        final Function<LocalDate, Month> localDateMonthFunction = LocalDate::getMonth;

        final Function<Employee, Month> employeeMonthFunction = getDateOfJoining.andThen(localDateMonthFunction);

        final List<Month> monthList = employeeStream()
                .map(employeeMonthFunction)
                .collect(Collectors.toList());

        PrettyPrint.list(monthList);

    }

    @Test
    public void testEmployees() {
        final Predicate<Employee> employeePredicate = e -> e.getGender() == Gender.MALE;
        final List<Employee> maleEmployees = employeeStream().filter(employeePredicate).collect(Collectors.toList());
        PrettyPrint.list(maleEmployees);

        final Predicate<Employee> employeePredicate1 = e -> e.getDateOfJoining().getMonth() == Month.APRIL;

        final List<Employee> employeesInApril = employeeStream().filter(employeePredicate1).collect(Collectors.toList());

        final List<Employee> maleEmployeesJoinedInApril = employeeStream().filter(employeePredicate).filter(employeePredicate1).collect(Collectors.toList());

        PrettyPrint.list(maleEmployeesJoinedInApril);



    }
}
