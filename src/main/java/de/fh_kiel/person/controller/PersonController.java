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


    /**
     * GET METHOD for array of persons
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> persons(){
        return personService.getAllPersons();
    }

    /**
     * GET METHOD for a person by id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") long id){
        return personService.getPersonById(id);
    }

    /**
     * Create Person
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public long createPerson(@RequestBody Person person){
        long id = personService.createPerson(person);
        if(id == 0L){
            throw new IllegalArgumentException("Person ID should not be 0");
        }else {
            return id;
        }
    }

    /**
     * Updation Method
     * @param id
     * @param person
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable("id") long id,@RequestBody Person person){
        if(person.getId() == id){
            personService.updatePerson(person);
        }else {
            logger.error("Person's ID is not same for updation");
        }

    }

    /**
     * Delete Person
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") long id){
        personService.deletePerson(id);
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
