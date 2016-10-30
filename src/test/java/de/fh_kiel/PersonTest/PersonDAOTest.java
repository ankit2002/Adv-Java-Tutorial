package de.fh_kiel.PersonTest;

import de.fh_kiel.person.datamodel.PersonDAO;
import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.stubclass.Developer;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Ankit on 10/30/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonDAOTest {


    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonDAO mockPersonDAO;

    private Developer dev,dev2;

    @Before
    public void setup(){
        dev = new Developer(1, 100000, new HashSet<>(Arrays.asList("Objective C","Java","C++","C",".net","Swift")));
        dev.setId(1L);
        dev.setFirst_Name("Ankit");
        dev.setLast_Name("Mishra");
        dev.setD_o_b(LocalDate.of(1991, 02, 20));
        dev.setGender(Gender.Male);


        dev2 = new Developer(2, 100000, new HashSet<>(Arrays.asList("C++","C",".net","Swift")));
        dev2.setId(2L);
        dev2.setFirst_Name("Vipul");
        dev2.setLast_Name("Gupta");
        dev2.setD_o_b(LocalDate.of(1990, 10, 13));
        dev2.setGender(Gender.Male);
    }


    @Test
    public void CheckPersonInfo(){

        when(mockPersonDAO.getAllPersons()).thenReturn(Arrays.asList(dev));
        final List<Person> list = new ArrayList<>(personService.getAllPersons());
        Assert.assertEquals(dev.getFirst_Name(), list.get(0).getFirst_Name());
        verify(mockPersonDAO, times(1)).getAllPersons();
    }


    @Test
    public void getPersons(){

        when(mockPersonDAO.getAllPersons()).thenReturn(Arrays.asList(dev,dev2));
        final List<Person> list = new ArrayList<>(personService.getAllPersons());
        assertThat("list shouldn't be null", list, notNullValue());
        assertThat("list should have 2 entries", list, hasSize(2));
        assertThat("wrong order of developers in result", list, contains(dev, dev2));
    }

    @Test
    public void testUpdatePerson(){

        try {
            when(mockPersonDAO.updatePerson(dev)).thenReturn(true);
            mockPersonDAO.updatePerson(dev);
            assertEquals(dev.getId(), 1L);

        }catch (Exception e){
           System.out.println("Error in update");
        }
    }


    @Test
    public void testAddPerson(){
        when(mockPersonDAO.createPerson(dev)).thenReturn(true);
        mockPersonDAO.createPerson(dev);
        assertEquals(dev.getFirst_Name(), "Ankit");
    }



    @Test
    public void testDeletePerson(){
        when(mockPersonDAO.deletePerson(dev2)).thenReturn(true);
        mockPersonDAO.deletePerson(dev2);
        assertEquals(dev2.getId(), 2L);
    }

}
