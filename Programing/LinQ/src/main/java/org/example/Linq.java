package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Linq<T> {
    private List<T> elements = new ArrayList<>();

    public static Linq of(List<? extends Object> elements){
        return new Linq(elements);
    }

    private Linq(List<T> numbers){
        for(T n:numbers){
            elements.add(n);
        }
    }


    public List<T> Where(Predicate<T> p) {
        return elements.stream().filter(p).collect(Collectors.toList());
    }

    public List<T> orderBy(Comparator<T> comparator) {
        return elements.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<T> orderBy(ToIntFunction<? super T> keyExtractor) {
        Comparator<T> comparator = (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
        return elements.stream().sorted(comparator).collect(Collectors.toList());
    }

    public <U extends Comparable<? super U>> List<T> orderBy(Function<? super T, ? extends U> keyExtractor) {
        Comparator<T> comparator = (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        return elements.stream().sorted(comparator).collect(Collectors.toList());
    }


    public <U extends Comparable<? super U>> List<T> orderByDescending(Function<? super T, ? extends U> keyExtractor) {
        Comparator<T> comparator = (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        return elements.stream().sorted(comparator.reversed()).collect(Collectors.toList());
    }



    public List<T> ofType(Class<T> className) {
        if(className == null){
            return elements.stream().filter(e -> Objects.isNull(e)).collect(Collectors.toList());
        }
        return elements.stream().filter(e -> className.isInstance(e)).collect(Collectors.toList());
    }

    public long count(Predicate<T> predicate) {
        return elements.stream().filter(predicate).count();
    }

    public long count() {
        return elements.size();
    }

    public T first(Predicate<T> predicate) {
        return elements.stream().filter(predicate).findFirst().get();
    }
}
