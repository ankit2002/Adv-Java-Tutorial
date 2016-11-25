package de.fh_kiel.person.controller;

import de.fh_kiel.person.exception.EntityMalformedException;
import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.model.PersonService;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collection;

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
    public Collection<Person> persons(HttpServletRequest request, HttpServletResponse response){
        if (personService.getAllPersons() !=null) {
            logger.debug("To get all persons");
            response.setStatus( HttpServletResponse.SC_OK);
        }
        else {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return personService.getAllPersons();
    }

    /**
     * GET METHOD for a person by id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response){
        if (personService.getPersonById(id) !=null) {
            logger.debug("To get person by id");
            response.setStatus( HttpServletResponse.SC_OK);
        }
        else {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return personService.getPersonById(id);
    }

    /**
     * Create Person
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(@RequestBody final Person person, HttpServletRequest request, HttpServletResponse response){
//        long id = personService.createPerson(person);
//        if(id == 0L){
//            throw new IllegalArgumentException("Person ID should not be 0");
//        }else {
//            response.setStatus( HttpServletResponse.SC_OK);
//            logger.debug("To create a person");
//            return id;
//        }

        try {
            this.personService.createPerson(person);
            final URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(person.getId())
                    .toUri();
            return ResponseEntity.created(location).body(person);
        } catch (IllegalArgumentException e) {
            throw new EntityMalformedException("Person could not be created", e);
        }

    }

    /**
     * Updation Method
     * @param id
     * @param person
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable("id") long id,@RequestBody Person person, HttpServletRequest request, HttpServletResponse response){
        if(person.getId() == id){
            response.setStatus( HttpServletResponse.SC_OK);
            personService.updatePerson(person, id);
            logger.debug("To update a person");
        }else {
            logger.error("Person's ID is not same for updation");
        }

    }

    /**
     * Delete Person
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus( HttpServletResponse.SC_OK);
        logger.debug("To delete a person by id");
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
