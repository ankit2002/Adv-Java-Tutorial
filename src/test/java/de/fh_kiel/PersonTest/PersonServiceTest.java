package de.fh_kiel.PersonTest;
import de.fh_kiel.Exception.PersonNotFound;
import de.fh_kiel.Person.Developer;
import de.fh_kiel.Person.Person;
import de.fh_kiel.Person.PersonService;
import de.fh_kiel.PersonDAO.PersonDAO;
import de.fh_kiel.PersonDAO.PersonDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Ankit on 10/8/2016.
 */

public class PersonServiceTest {

    @Mock
    private PersonDAO personDAO;



    private PersonService personService;
    HashSet<Person> all = new HashSet<>();

    @Before
    public void setUp(){
        personDAO = new PersonDAOImpl();
        personService = new PersonService(personDAO);


        Developer developer1 = new Developer("Mo", "Farah", LocalDate.of(1983, 10, 10), "Male", 1,1, 100000);
        developer1.addProgrammingLanguage("Java");

        Developer developer2 = new Developer("Mofdsa", "test", LocalDate.of(1989, 10, 02), "Female", 2,1, 100000);
        developer2.addProgrammingLanguage("CPP");

        all.add(developer1);
        all.add(developer2);

        personService.createPerson(developer1);
        personService.createPerson(developer2);
    }


    @Test
    public void shouldUpdatePerson(){
        Developer developer2 = new Developer("test", "test", LocalDate.of(1989, 10, 02), "Female", 2,1, 100000);
        boolean updated = personService.updatePerson(developer2);
        Assert.assertTrue(updated);
    }


    @Test(expected=IndexOutOfBoundsException.class)
    public void shouldNotUpdatePerson(){
        Developer developer2 = new Developer("test", "test", LocalDate.of(1989, 10, 02), "Female", 3,1, 100000);
        boolean updated = personService.updatePerson(developer2);
        Assert.assertTrue(updated);
    }

    @Test
    public void testGetAll() {
        //  create mock
        PersonService a = mock(PersonService.class);
        //MOCK ALERT: return mocked result set on find
        when(a.getAllPersons()).thenReturn(all);

        //call the main method you want to test
        Collection result = a.getAllPersons();

        //MOCK ALERT: verify the method was called
        verify(a).getAllPersons();
    }

    @Test
    public void test1()  {
        //  create mock
        PersonService test = Mockito.mock(PersonService.class);
        // define return value for method getUniqueId()
        when(test.getAllPersonsSize()).thenReturn(2);
        // use mock in test....
        assertEquals(test.getAllPersonsSize(), 2);
    }


}