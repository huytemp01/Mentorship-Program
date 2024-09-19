package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Linq<T> {
    private List<T> elements = new ArrayList<>();

    public static <T> Linq<T> of(List<T> elements){
        return new Linq<>(elements);
    }

    private Linq(List<T> numbers){
        for(T n:numbers){
            elements.add(n);
        }
    }

    public Linq<T> Where(Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e:elements){
            if(p.test(e)){
                result.add(e);
            }
        }
        return new Linq<T>(result);
    }

    public List<T> toList(){
        return this.elements;
    }

    public <U extends Comparable<? super U>> Linq<T> orderBy(Function<? super T, ? extends U> keyExtractor) {
        Comparator<T> comparator = (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        List<T> result = new ArrayList<>(elements);
        result.sort(comparator);
        return new Linq<>(result);
    }


    public <U extends Comparable<? super U>> Linq<T> orderByDescending(Function<? super T, ? extends U> keyExtractor) {
        Comparator<T> comparator = (c2, c1) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        List<T> result = new ArrayList<>(elements);
        result.sort(comparator);
        return new Linq<>(result);

    }


    public Linq<T> ofType(Class<T> className) {
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

}
