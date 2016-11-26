package de.fh_kiel.PersonTest;

import de.fh_kiel.person.ApplicationConfig;
import de.fh_kiel.person.controller.PersonController;
import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@ContextConfiguration(classes=ApplicationConfig.class)
public class PersonControllerTest {


    private static final long id = 1L;
    private static final String first_Name = "Amit";
    private static final String last_Name = "Nagar";
    private static final LocalDate dob = LocalDate.of(1988,10,10);
    private static final Gender gender =  Gender.Male;



    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    @Test
    public void getPersonByIdTest() throws Exception {

        given(this.personService.getPersonById(id)).willReturn(Optional.ofNullable(new Person(first_Name, last_Name, dob, gender, id)));
        this.mvc.perform(get("/person/" + id).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.first_Name").value(first_Name))
                .andExpect(jsonPath("$.last_Name").value(last_Name))
                .andExpect(jsonPath("$.d_o_b").value(dob.toString()))
                .andExpect(jsonPath("$.gender").value(gender.toString()))
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }
}