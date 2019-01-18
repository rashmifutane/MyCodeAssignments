package sort;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by futaner on 07/12/17.
 */
public class SortNumbers {


        public static void main(String[] args) {
          //  Scanner in = new Scanner(System.in);
         //   int n = in.nextInt();
//            String[] unsorted = new String[n];
//            for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
//                unsorted[unsorted_i] = in.next();
//            }
            System.out.println(3.25+"5,4");


          //  final List<String> strings = Arrays.asList(unsorted);

       //     final List<BigInteger> bigIntegers = strings.parallelStream().map(number -> new BigInteger(number)).sorted().collect(Collectors.toList());
           /// Collections.sort(bigIntegers);

     //       bigIntegers.parallelStream().forEach(number -> System.out.println(number));

          //  Arrays.stream(unsorted).parallel().map(number -> new BigInteger(number)).sorted().forEach(num -> System.out.println(num));


            Set<Employee>  employees = new HashSet<>();
            Employee e1=new Employee("abc");
            Employee e2=new Employee("abc");
            Employee e3=new Employee("abc");
            employees.add(e1);
            employees.add(e2);
            employees.add(e3);
            employees.stream().forEach(System.out::println);


        }
}
