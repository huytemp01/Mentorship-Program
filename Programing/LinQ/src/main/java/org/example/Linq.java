package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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
}
