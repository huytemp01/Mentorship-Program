package org.example;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Linq<T,E> {
    private List<T> elements = new ArrayList<>();
    private Map<Object,List<T>> map = new TreeMap<>();

    private  List<E> rightList = new ArrayList<>();

    private  List<T> leftList = new ArrayList<>();

    private Map<T,List<E>> joinResult = new HashMap<>();

    public static <T,E> Linq<T,E> from(List<T> elements){
        return new Linq<>(elements);
    }
    private Linq(){}

    private Linq(List<T> numbers){
        for(T n:numbers){
            elements.add(n);
        }
    }

    private Linq(List<T> elements, Map<Object,List<T>> map){
        this.map = map;
        this.elements = elements;
    }


    public Linq<T,E> Where(Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e:elements){
            if(p.test(e)){
                result.add(e);
            }
        }
        return new Linq<T,E>(result);
    }

    public List<T> toList(){
        return this.elements;
    }

    public <U extends Comparable<? super U>> Linq<T,E> orderBy(Function<? super T, ? extends U> keyExtractor) {
        Comparator<T> comparator = (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        List<T> result = new ArrayList<>(elements);
        result.sort(comparator);
        for(T e:elements){
            if(map.get(keyExtractor.apply(e)) == null){
                Object value = keyExtractor.apply(e);
                List<T> list = new ArrayList<>();
                list.add(e);
                map.put(value,list);
            }
            else{
                List<T> list = map.get(keyExtractor.apply(e));
                list.add(e);
            }
        }
        return new Linq<>(result,map);
    }



    public <U extends Comparable<? super U>> Linq<T,E> orderByDescending(Function<? super T, ? extends U> keyExtractor) {
        Comparator<T> comparator = (c2, c1) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        List<T> result = new ArrayList<>(elements);
        result.sort(comparator);
        return new Linq<>(result);

    }


    public Linq<T,E> ofType(Class<T> className) {
        List<T> result = new ArrayList<>();
        if(className == null){
            for(T e:elements){
                if(Objects.isNull(e)){
                    result.add(e);
                }
            }
            return new Linq<>(result);
        }
       else {
            for(T e:elements){
                if(className.isInstance(e)){
                    result.add(e);
                }
            }
            return new Linq<>(result);
        }

    }


    public long count(Predicate<T> predicate){
        long count = 0;
        for(T e:elements){
            if(predicate.test(e)){
                count++;
            }
        }

        return count;
    }

    public long count() {
        return elements.size();
    }

    public T first(Predicate<T> predicate) {
        for(T e:elements){
            if(predicate.test(e)){
                return e;
            }
        }

        throw new NoSuchElementException();
    }

    public <U extends Comparable<? super U>> Linq<T,E> thenBy(Function<? super T, ? extends U> keyExtractor) {
        List<T> result = new ArrayList<>();
        Comparator<T> comparator = (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        for(Object key: map.keySet()){
            map.get(key).sort(comparator);
            result.addAll(map.get(key));
        }
        return new Linq<>(result);
    }

    public <U> Map<U, List<T>> groupBy(Function<T,U> functions) {
        Map<U, List<T>> result = new HashMap<>();
        for(T e:elements){
            U key = functions.apply(e);
            if(result.get(key) == null){
                List<T> values = new ArrayList<>();
                values.add(e);
                result.put(key,values);
            }
            else {
                List<T> values = result.get(key);
                values.add(e);
            }
        }

        return result;
    }

    public static <T,E>  Linq<T,E> innerJoin(List<T> left, List<E> right) {
        Linq<T,E> linq = new Linq<>();
        for (T l:left){
            linq.leftList.add(l);
        }

        for(E r:right){
            linq.rightList.add(r);
        }

        return linq;
    }


    public Map<T, List<E>> on(BiFunction<T,E,Boolean> function) {
        for(T l:leftList){
            for(E r:rightList){
                if(function.apply(l,r)){
                    if(joinResult.get(l) == null){
                        List<E> values = new ArrayList<>();
                        values.add(r);
                        joinResult.put(l, values);
                    }
                    else {
                        List<E> values = joinResult.get(l);
                        values.add(r);
                    }
                }
            }


        }
        return joinResult;
    }

    public static <T,E>  Linq<T,E> leftJoin(List<T> left, List<E> right) {
        Linq<T,E> linq = new Linq<>();
        for (T l:left){
            linq.leftList.add(l);
            List<E> list = new ArrayList<>();
            linq.joinResult.put(l, list);
        }

        for(E r:right){
            linq.rightList.add(r);
        }

        return linq;
    }
}
