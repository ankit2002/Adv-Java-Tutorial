package de.fh_kiel.PersonTest;

import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.stubclass.Developer;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.ProjectManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Ankit on 10/30/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    private Developer developer1, developer2, developer3;
    private ProjectManager projectManager;

    @Autowired
    PersonService personService;


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
    public void testController(){

    }

}
