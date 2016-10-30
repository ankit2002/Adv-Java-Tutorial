package de.fh_kiel.PersonTest;

import de.fh_kiel.person.*;
import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.stubclass.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.*;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Ankit on 10/8/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {


    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonDAO mockPersonDAO;

    private Developer developer1, developer2, developer3;
    private ProjectManager projectManager;


    @Before
    public void setup() {
        developer1 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer1.setId(1L);
        developer1.setFirst_Name("Free");
        developer1.setLast_Name("Farah");
        developer1.setD_o_b(LocalDate.of(1983, 10, 10));
        developer1.setGender(Gender.Male);

        developer2 = new Developer(5, 43000, new HashSet<>(Collections.singleton("F#")));
        developer2.setId(2L);
        developer2.setFirst_Name("Kevin");
        developer2.setLast_Name("Volland");
        developer2.setD_o_b(LocalDate.of(1987, 5, 22));
        developer2.setGender(Gender.Male);

        developer3 = new Developer(7, 79919, new HashSet<>(Arrays.asList("F#", "C#")));
        developer3.setId(3L);
        developer3.setFirst_Name("Steven");
        developer3.setLast_Name("Gerrad");
        developer3.setD_o_b(LocalDate.of(2005, 8, 9));
        developer3.setGender(Gender.Male);

        projectManager= new ProjectManager(3);
        projectManager.setId(4L);
        projectManager.setFirst_Name("Birgit");
        projectManager.setLast_Name("Prinz");
        projectManager.setD_o_b(LocalDate.of(1989, 11, 8));
        projectManager.setGender(Gender.Female);
        projectManager.setPmExp(10);
        projectManager.setMin_Salary(60000);
        projectManager.setProg_lang(new HashSet<>(Arrays.asList("Javascript","VBa","C#")));
    }


    @Test
    public void listPersons() {

        when(mockPersonDAO.getAllPersons()).thenReturn(Arrays.asList(developer1, developer2,
                developer3, projectManager));

        final List<Person> list = new ArrayList<>(personService.getAllPersons());
        assertThat("list shouldn't be null", list, notNullValue());
        assertThat("list should have 4 entries", list, hasSize(4));
        assertThat("wrong order of developers in result", list, contains(developer1, developer2,
                developer3, projectManager));

        verify(mockPersonDAO, times(1)).getAllPersons();
    }


    @Test
    public void listPersonsProgrammingLanguage() {

        when(mockPersonDAO.getAllPersons()).thenReturn(Arrays.asList(developer1, developer2,
                developer3, projectManager));

        List<Person> list = new ArrayList<>(personService.getPersonByProgLang(null));
        assertThat("list shouldn't be null", list, notNullValue());
        assertThat("list should have 0 entries", list, empty());

        list = new ArrayList<>(personService.getPersonByProgLang("Java"));
        assertThat("list shouldn't be null", list, notNullValue());
        assertThat("list should have 1 entries", list, hasSize(1));
        assertThat("list should have correct order", list, contains(developer1));

        list = new ArrayList<>(personService.getPersonByProgLang("F#"));
        assertThat("list shouldn't be null", list, notNullValue());
        assertThat("list should have 2 entries", list, hasSize(2));
        assertThat("list should have correct order", list, contains(developer3, developer2));

        verify(mockPersonDAO, times(3)).getAllPersons();
    }
}
