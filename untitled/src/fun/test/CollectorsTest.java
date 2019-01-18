package fun.test;

import fun.movies.Movie;
import fun.movies.MovieClub;
import fun.movies.Person;
import fun.office.Employee;

import fun.util.PrettyPrint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by agrawaas on 04/03/16.
 */
public class CollectorsTest {

    @Test
    public void testCustomCollector() {

        Employee.getEmployees().stream()
                .collect(getMyListCollector())
                .forEach(System.out::println);

    }

    private MyListCollector<Employee> getMyListCollector() {
        return new MyListCollector<Employee>();
    }
    @Test
    public void testToMap(){
        Employee.getEmployees().stream()
                .collect(toMyMap(Employee::getFirstName, Employee::getDepartment))
                .forEach((k,v) -> System.out.println(k+" "+v));
    }

    private static<T,K,V> MyMapCollector<T,K,V> toMyMap(Function<T, K> keyMapper, Function<T,V> valueMapper) {
        return new MyMapCollector<>(keyMapper, valueMapper);
    }


    @Test
    public void testMyMultimapCollector() {
        Map<String, List<Employee>> myMultiMap = Employee.getEmployees().stream()
                .collect(new MyMultimapCollector<>(Employee::getFirstName));

        PrettyPrint.multiMap(myMultiMap);
    }


    @Test
    public void testInvertedCollector() {
        Map<Movie, List<Person>> invertedMovieMap = MovieClub.gang().stream()
                .collect(new InvertedCollector<Person, Movie>(Person::getMoviesList));

        PrettyPrint.multiMap(invertedMovieMap);
    }

}



class MyListCollector<T> implements Collector<T, List<T>, List<T>> {

    public static final Set<Characteristics> CH_ID
            = Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, e) -> list.add(e);
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) ->   {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return CH_ID;
    }
}

class MyMapCollector<T,K,V> implements Collector<T, Map<K,V>, Map<K,V>> {

    private final Function<T, K> keyMapper;
    private final Function<T, V> valueMapper;

    public MyMapCollector(Function<T,K> keyMapper, Function<T,V> valueMapper) {

        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
    }

    @Override
    public Supplier<Map<K, V>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, V>, T> accumulator() {
        return (m,e) -> m.put(keyMapper.apply(e),valueMapper.apply(e));
    }

    @Override
    public BinaryOperator<Map<K, V>> combiner() {
        return (m1,m2) -> {
            m1.putAll(m2);
            return  m1;
        };
    }

    @Override
    public Function<Map<K, V>, Map<K, V>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return MyListCollector.CH_ID;
    }
}

class MyMultimapCollector<T,K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private Function<T, K> classifier;

    public MyMultimapCollector(Function<T, K> classifier) {

        this.classifier = classifier;
    }


    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, element) -> {

            K key = classifier.apply(element);
            if (map.containsKey(key)) {
                (map.get(key)).add(element);
            } else {
                List list = new ArrayList<T>();
                list.add(element);
                map.put(key, list);
            }
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (map1, map2) -> {
            map2.forEach(
                    (key, list) -> {
                        if (map1.containsKey(key)) {
                            map1.get(key).addAll(list);
                        } else {
                            map1.put(key, list);
                        }
                    }
            );
            return map1;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return MyListCollector.CH_ID;
    }
}



abstract class DefaultCollector<T,A> implements Collector<T,A,A> {




    @Override
    public Function<A, A> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return MyListCollector.CH_ID;
    }
}

class InvertedCollector<T, K> extends DefaultCollector<T, Map<K, List<T>>> {


    private Function<T, List<K>> keylistExtractor;

    public InvertedCollector(Function<T, List<K>> keylistExtractor) {

        this.keylistExtractor = keylistExtractor;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, e) -> {
            keylistExtractor.apply(e).forEach(
                    (k) -> {
                        if (map.containsKey(k)) {
                            map.get(k).add(e);
                        }
                        else {
                            ArrayList<T> l = new ArrayList();
                            l.add(e);
                            map.put(k, l);
                        }
                    }
            );
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (map1, map2) -> {
            map2.forEach(
                    (key, list) -> {
                        if (map1.containsKey(key)) {
                            map1.get(key).addAll(list);
                        } else {
                            map1.put(key, list);
                        }
                    }
            );
            return map1;
        };
    }

}