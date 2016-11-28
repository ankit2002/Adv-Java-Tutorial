package de.fh_kiel.PersonTest;

import de.fh_kiel.person.datamodel.filterValues;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by amit on 28.11.16.
 */
public class filterValuesTest {
    List<Person> inventory = new ArrayList<>();
    List<String > tempVar = new ArrayList<>();

    @Before
    public void setUp() {
        System.out.println("in before Filtervalue test");
        inventory.add(new Person("Amit", "Nagar", LocalDate.of(1988, 10, 10), Gender.Female, 5L));
        inventory.add(new Person("Rimi", "Tina", LocalDate.of(1988, 10, 10), Gender.Female, 6L));
        inventory.add(new Person("Niki", "Mili", LocalDate.of(1988, 10, 10), Gender.Female, 2L));
        inventory.add(new Person("Brian", "Kris", LocalDate.of(1988, 10, 10), Gender.Male, 4L));
        inventory.add(new Person("Mr", "Nathan", LocalDate.of(1988, 10, 10), Gender.Male, 3L));
        inventory.add(new Person("Miss", "Kat", LocalDate.of(1988, 10, 10), Gender.Female, 1L));
        tempVar.add("Miss Kat");
        tempVar.add("Niki Mili");
        tempVar.add("Amit Nagar");
        tempVar.add("Rimi Tina");
    }
    @Test
    public void testFilterValues(){
        System.out.println("Before Conversion: " + inventory);
        List<String > newUpdatedList = filterValues.getfilterValues(inventory,
                person -> Gender.Female.equals(person.getGender()),
                (Person p1, Person p2) -> p1.getId().compareTo(p2.getId()), person -> person.getFirst_Name() + " " + person.getLast_Name());
        assertEquals(tempVar, newUpdatedList);
        System.out.println("Final Converted List: " + newUpdatedList);
    }

    @After
    public void after() {
        System.out.println("in after Filter Value test");
    }
}
