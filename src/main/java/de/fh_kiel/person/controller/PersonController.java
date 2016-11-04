package de.fh_kiel.person.controller;



import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.stubclass.Developer;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Ankit on 10/28/2016.
 */
@RestController
@RequestMapping("/person")
public class PersonController implements ErrorController {
    Logger logger = LoggerFactory.getLogger(PersonController.class);;

    /**
     * Injecting dependency for Person Service
     */
    @Autowired
    private PersonService personService;


    @Autowired
    public void createPerson(){;
        Developer developer1 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer1.setId(1L);
        developer1.setFirst_Name("temp");
        developer1.setLast_Name("Farah");
        developer1.setD_o_b(LocalDate.of(1983, 10, 10));
        developer1.setGender(Gender.Male);
        personService.createPerson(developer1);


        Developer developer2 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer2.setId(2L);
        developer2.setFirst_Name("temp");
        developer2.setLast_Name("Farah");
        developer2.setD_o_b(LocalDate.of(1983, 10, 10));
        developer2.setGender(Gender.Male);
        personService.createPerson(developer2);

        Developer developer3 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer3.setId(3L);
        developer3.setFirst_Name("temp");
        developer3.setLast_Name("Farah");
        developer3.setD_o_b(LocalDate.of(1983, 10, 10));
        developer3.setGender(Gender.Male);
        personService.createPerson(developer3);


        Developer developer4 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer4.setId(4L);
        developer4.setFirst_Name("temp");
        developer4.setLast_Name("Farah");
        developer4.setD_o_b(LocalDate.of(1983, 10, 10));
        developer4.setGender(Gender.Male);
        personService.createPerson(developer4);

        Developer developer5 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer5.setId(5L);
        developer5.setFirst_Name("temp");
        developer5.setLast_Name("Farah");
        developer5.setD_o_b(LocalDate.of(1983, 10, 10));
        developer5.setGender(Gender.Male);
        personService.createPerson(developer5);
    }

    /**
     * GET METHOD for array of persons
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> persons(){
        logger.debug("info all persons");
        return personService.getAllPersons();
    }

    /**
     * GET METHOD for a person by id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") long id){
        logger.debug("inside single person id");
        return personService.getPersonById(id);
    }
    /**
     * POST METHOD to create the Person
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createPerson(@RequestBody Person person){
        logger.debug("Inside create person");
        return personService.createPerson(person);
    }

    /**
     * GET METHOD for a person by id
     * @return
     */
    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Person deletePerson(@PathVariable("id") long id){
        logger.debug("inside single person id");
        return personService.deletePerson(id);
    }*/
    /**
     * Just to test Logger
     * @return
     */
    @RequestMapping("/logging")
    String index(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "index";
    }
    /**
     * Error Handling
     * @return
     */
    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


}
