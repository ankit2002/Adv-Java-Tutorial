package de.fh_kiel.person.datamodel;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by amit on 27.11.16.
 */
public class filterValues {


    /**
     * Implemented  static method in a functional way to filter, order, and return List<R>
     * @param tList
     * @param tPredicate
     * @param tComparator
     * @param trFunction
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> List<R> getfilterValues(List<T> tList, Predicate<T> tPredicate,Comparator<T> tComparator,  Function<T, R> trFunction) {
        return tList.stream().filter(t -> tPredicate.test(t)).sorted(tComparator).map(T -> trFunction.apply(T)).collect(toList());
    }
}
