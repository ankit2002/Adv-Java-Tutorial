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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    MockMvc mvc;

    @MockBean
    PersonService personService;

    @Test
    public void getPersonByIdTest() throws Exception {

        String dobstring = dob.toString();
        String genderstring = gender.toString();

        given(this.personService.getPersonById(id))
                .willReturn(new Person(first_Name, last_Name, dob, gender, id));
        this.mvc.perform(get("/person/" + id).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.first_Name").value(first_Name))
                .andExpect(jsonPath("$.last_Name").value(last_Name))
                .andExpect(jsonPath("$.d_o_b").value(dobstring))
                .andExpect(jsonPath("$.gender").value(genderstring))
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }
}