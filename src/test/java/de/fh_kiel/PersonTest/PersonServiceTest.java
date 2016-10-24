package de.fh_kiel.PersonTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Ankit on 10/8/2016.
 */

public class PersonServiceTest {

    /*@Mock
    private PersonDAO personDAO;



    private PersonService personService;
    HashSet<PersonStub> all = new HashSet<>();

    @Before
    public void setUp(){
        personDAO = new PersonDAOImpl();
        personService = new PersonService(personDAO);



        DeveloperStub developer1 = new DeveloperStub("Mo", "Farah", LocalDate.of(1983, 10, 10), "Male", 1,1, 100000);
        developer1.addProgrammingLanguage("Java");

        personService.createPerson(developer1);
    }


    *//*@Test
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
    }*//*

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
    }*/


}
