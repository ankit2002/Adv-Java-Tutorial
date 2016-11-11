package de.fh_kiel.PersonTest;

import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.controller.*;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ankit on 10/30/2016.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
//@SpringBootTest(classes=PersonController.class)
public class PersonControllerTest {


    private static final long id = 1L;
    private static final String first_Name = "Amit";

    private static final String last_Name = "Nagar";

    private static final LocalDate d_o_b = LocalDate.of(1988,10,10);

    private static final Gender gender = Gender.Male;



    @Autowired
    MockMvc mvc;

    @MockBean
    PersonService personService;

    @Test
    public void getPersonByIdTest() throws Exception {
        given(personService.getPersonById(id))
                .willReturn(new Person(first_Name, last_Name, d_o_b, gender, id));
        this.mvc.perform(get("/person/" + id)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value(first_Name))
                .andExpect(jsonPath("$.lastname").value(last_Name))
                .andExpect(jsonPath("$.age").value(d_o_b))
                .andExpect(jsonPath("$.gender").value(gender))
                .andExpect(jsonPath("$.id").value(id));


    }
}