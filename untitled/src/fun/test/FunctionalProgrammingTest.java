package fun.test;
import org.fun.movies.Actor;
import org.fun.movies.Movie;
import org.fun.movies.MovieClub;
import org.fun.movies.Person;
import org.fun.office.Department;
import org.fun.office.Employee;
import org.fun.office.Gender;
import org.fun.util.PrettyPrint;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by badhem on 02/03/16.
 */
public class FunctionalProgrammingTest {

    public static final Function<Employee, LocalDate> GET_DATE_OF_JOINING = Employee::getDateOfJoining;
    public static final Function<LocalDate, Month> GET_MONTH = LocalDate::getMonth;
    public static final Predicate<Employee> MALE_EMPLOYEES = employee -> employee.getGender() == Gender.MALE;

    @Test
    public void testDateOfJoining() {
        List<LocalDate> dateOfJoiningList = getListOfJoiningDates();

        PrettyPrint.list(dateOfJoiningList);
    }

    private List<LocalDate> getListOfJoiningDates() {
        List<Employee> employeeList = Employee.getEmployees();

        return employeeList.stream()
                .map(GET_DATE_OF_JOINING)
                .collect(toList());
    }

    @Test
    public void testListOfMonths() {
        List<LocalDate> dateOfJoiningList = getListOfJoiningDates();

        List<Month> monthList = dateOfJoiningList.stream()
                .map(GET_MONTH)
                .collect(toList());

        PrettyPrint.list(monthList);
    }

    @Test
    public void testReusingLambdas() {
        List<Employee> employeeList = Employee.getEmployees();

        Function<Employee, Month> getEmpployeeJoiningMonth = GET_DATE_OF_JOINING.andThen(GET_MONTH);
        List<Month> monthList = employeeList.stream()
                .map(getEmpployeeJoiningMonth)
                .collect(toList());

        PrettyPrint.list(monthList);
    }

    @Test
    public void testFilterMaleEmployees() {
        List<Employee> maleEmployeeList = empStream()
                .filter(MALE_EMPLOYEES.negate())
                .collect(toList());

        PrettyPrint.list(maleEmployeeList);
    }

    @Test
    public void testFilterEmployeesJoinedInApril(){
        List<Employee> employeesJoinedInApril = empStream()
                .filter(joinedIn(Month.APRIL))
                .collect(toList());

        PrettyPrint.list(employeesJoinedInApril);
    }

    @Test
    public void testMaleEmployeesJoinedInApril() {
        List<Employee> maleEmplJoinedInApril = empStream()
                .filter(MALE_EMPLOYEES.and(joinedIn(Month.APRIL)))
                .collect(toList());

        PrettyPrint.list(maleEmplJoinedInApril);
    }

    @Test
    public void getSortedListOfEmployeesOnName(){
        Comparator<Employee> ByfirstName = comparing(Employee::getFirstName);
        Comparator<Employee> ByLastName = comparing(Employee::getLastName);
        List<Employee> employees = empStream()
                .sorted(ByfirstName.thenComparing(ByLastName.reversed()))
                .collect(Collectors.toList());
        PrettyPrint.list(employees);

    }
    private Predicate<Employee> joinedIn(Month month) {
        return employee -> employee.getDateOfJoining().getMonth() == month;
    }

    private Stream<Employee> empStream() {
        return Employee.getEmployees().stream();
    }
    @Test
    public void testUniqueListOfDepartments(){
        Set<Department> employeeDepartments = empStream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(toSet());
        PrettyPrint.collection(employeeDepartments);
    }
    @Test
    public void testDepartmentWiseEmployees(){
        Map<Department, List<Employee>> departmentListMap = empStream()
                .collect(groupingBy(Employee::getDepartment));
        PrettyPrint.multiMap(departmentListMap);

    }

    @Test
    public void testDepartmentWithMonthOfJoiningWiseEmployees(){
        Map<Department, Map<Month, List<Employee>>> departmentDateOfJoiningEmplotyeeMap = empStream()
                .collect(groupingBy(Employee::getDepartment, groupingBy(GET_DATE_OF_JOINING.andThen(GET_MONTH))));
        PrettyPrint.nestedMultiMap(departmentDateOfJoiningEmplotyeeMap);

    }


    @Test
    public void testListAllOfMovies() {
        List<Movie> movies = getGangStream()
                .flatMap(p -> p.getMovies().stream())
                .collect(toList());

        PrettyPrint.list(movies);
    }

    @Test
    public void testListOfMoviesPerActor() {
        Map<Actor, List<Movie>> listOfMoviesPerActor = getGangStream()
                .flatMap(p -> p.getMovies().stream())
                .distinct()
                .collect(groupingBy(Movie::getActor));

        PrettyPrint.multiMap(listOfMoviesPerActor);
    }

    @Test
    public void testMoviesPerPerson () {
        Map<Person, Set<Movie>> moviesPerPerson = getGangStream()
                .collect(toMap(Function.identity(), Person::getMovies));
        PrettyPrint.multiMap(moviesPerPerson);
    }

    @Test
    public void testTotalCostOfMoviesPerPerson() {
        Map<Person, Integer> totalCostOfMoviesPerPerson = getGangStream()
                .collect(
                        toMap(
                                Function.identity(),
                                p -> p.getMovies()
                                        .stream()
                                        .mapToInt(Movie::getAmount)
                                        .sum()
                        ));

        PrettyPrint.map(totalCostOfMoviesPerPerson);

    }

    private Stream<Person> getGangStream() {
        return MovieClub.gang().stream();
    }

}
