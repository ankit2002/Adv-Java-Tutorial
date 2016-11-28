package de.fh_kiel.person.datamodel;

import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public static void main(String... args) {
        List<Person> inventory = new ArrayList<>();
        inventory.add(new Person("Amit", "Nagar", LocalDate.of(1988, 10, 10), Gender.Female, 5L));
        inventory.add(new Person("Rimi", "Tina", LocalDate.of(1988, 10, 10), Gender.Female, 6L));
        inventory.add(new Person("Niki", "Mili", LocalDate.of(1988, 10, 10), Gender.Female, 2L));
        inventory.add(new Person("Brian", "Kris", LocalDate.of(1988, 10, 10), Gender.Male, 4L));
        inventory.add(new Person("Mr", "Nathan", LocalDate.of(1988, 10, 10), Gender.Male, 3L));
        inventory.add(new Person("Miss", "Kat", LocalDate.of(1988, 10, 10), Gender.Female, 1L));
        System.out.println(inventory);
        List<String> newUpdatedList = filterValues.getfilterValues(inventory,
                person -> Gender.Female.equals(person.getGender()),
                (Person p1, Person p2) -> p1.getId().compareTo(p2.getId()), person -> person.getLast_Name());
        System.out.println("list details :" + newUpdatedList);

    }
}
