package client.test;

import sort.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleProblem {

    public static void main(String[] args) {
        System.out.println("max number of ones "+ solution(new int[]{10,2,5,1,8,20}));

        List<Employee> ints = new ArrayList<>(1);
        final Employee abc = new Employee("abc");
        final Employee xyz = new Employee("xyz");
        ints.add(abc);
        System.out.println(ints.toString());
        System.out.println(abc.hashCode());
        ints.add(xyz);
        System.out.println(ints.toString());
        System.out.println(xyz.hashCode());

    }

        public static int solution(int[] arr) {
            int result=0;
            Arrays.sort(arr);
            for (int i = 0; i < arr.length-2; i++) {
              if(arr[i]+arr[i+1] > arr[3])
                  result=1;
            }
            return result;
        }
}
