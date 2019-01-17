package client.test;//package client.test;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.function.BiConsumer;
//import java.util.function.BinaryOperator;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collector;
//
//public class CustomCollectors {
//
//    @Test
//    public void shouldUseCustomCollector(){
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("2");
//        list.add("2");
//        list.add("3");
//
//        final CustomListCollector collector = new CustomListCollector();
//      //  final List<String> collect = list.stream().collect(collector);
//     //   final List<String> collect1 = list.stream().collect(new CustomSetCollector());
//       // collect1.forEach(System.out::println);
//    }
//
//    }
//
//    class  CustomListCollector<T,R> implements Collector<T, List<R>, List<T>> {
//
//    Function<R,T> fnc;
//        CustomListCollector(Function<R, T> function) {
//            this.fnc = function;
//        }
//        @Override
//        public Supplier<List<R>> supplier() {
//            return () -> new ArrayList<R>();
//        }
//
//        @Override
//        public BiConsumer<List<R>, T> accumulator() {
//            return (list, e) -> list.add((R)e);
//        }
//
//        @Override
//        public BinaryOperator<List<R>> combiner() {
//            return (l1, l2) -> {
//                for (R t:l2) {
//                    l1.add(fnc.apply(t));
//                }
//            }
//        }
//
//        @Override
//        public Function<List<R>, List<T>> finisher() {
//            return null;
//        }
//
//        @Override
//        public Set<Characteristics> characteristics() {
//            return null;
//        }
//    }
//
//
//class CustomSetCollector implements Collector<String, Set<String>, List<String>> {
//
//    @Override
//    public Supplier<Set<String>> supplier() {
//        return HashSet::new;
//    }
//
//    @Override
//    public BiConsumer<Set<String>, String> accumulator() {
//        //add element to the list
//        return (list, e) -> list.add(e);
//    }
//
//    @Override
//    public BinaryOperator<Set<String>> combiner() {
//        //combine elements of 1 and 2
//        return (l2, l3) -> {
//            l2.addAll(l3);
//            return l2;
//        };
//    }
//
//    @Override
//    public Function<Set<String>, List<String>> finisher() {
//        return ArrayList::new;
//        // if collectors input and output both are list here so function identity
//        //if it would have been set to return from the collector then will have to write a return of set
//    }
//
//    @Override
//    public Set<Characteristics> characteristics() {
//        final Set<Characteristics> objects = new HashSet<>();
//        objects.add(Characteristics.IDENTITY_FINISH);
//        return objects;
//    }
//}
//
//
