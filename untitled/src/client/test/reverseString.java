package client.test;

import sort.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class reverseString {

        public static void main(String[] args) {
            String s="string";
            for(int i=s.length()-1;i>=0;i--){
                s+=s.charAt(i);
            }
            s=s.substring(s.length()/2, s.length());
            System.out.println(s);

            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(300);
            list.add(4);
            list.add(5);
            list.add(100);
            list.add(-5);
            System.out.println(list);
            for (int i = 0; i < 3; i++) {
                list.remove(i);
            }
            //final List<Integer> collect = list.stream().sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList());
            //System.out.println(collect.get(1));
            System.out.println(list);


            //sorting the map by values of the object not by keys
            Employee e1 = new Employee("abc");
            Employee e2 = new Employee("xyz");
            Employee e3 = new Employee("pqr");
            Map<Integer, Employee> map = new HashMap<>();

            map.put(1,e1);
            map.put(2,e2);
            map.put(3,e3);

            System.out.println( getCollect(map));

        }

    private static Map<Object, Object> getCollect(final Map<Integer, Employee> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
                .collect(Collectors.toMap(e -> e.getKey(), e->e.getValue(),(x,y) -> x, LinkedHashMap::new));
        //merger function for duplicate keys means multiple values mapping to same key
    }



}
