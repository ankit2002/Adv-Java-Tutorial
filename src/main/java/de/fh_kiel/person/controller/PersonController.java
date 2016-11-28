package de.fh_kiel.person.controller;

import de.fh_kiel.person.datamodel.filterValues;
import de.fh_kiel.person.exception.EntityMalformedException;
import de.fh_kiel.person.service.PersonService;
import de.fh_kiel.person.stubclass.Gender;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ankit on 10/28/2016.
 */

@RestController
@RequestMapping("/person")
public class PersonController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    static final List<Person> inventory = new ArrayList<>();
    static {
        inventory.add(new Person("Amit", "Nagar", LocalDate.of(1988, 10, 10), Gender.Female, 5L));
        inventory.add(new Person("Rimi", "Tina", LocalDate.of(1988, 10, 10), Gender.Female, 6L));
        inventory.add(new Person("Niki", "Mili", LocalDate.of(1988, 10, 10), Gender.Female, 2L));
        inventory.add(new Person("Brian", "Kris", LocalDate.of(1988, 10, 10), Gender.Male, 4L));
        inventory.add(new Person("Mr", "Nathan", LocalDate.of(1988, 10, 10), Gender.Male, 3L));
        inventory.add(new Person("Miss", "Kat", LocalDate.of(1988, 10, 10), Gender.Female, 1L));
    }

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

        Optional<Person> p = personService.getPersonById(id);
        if (p.isPresent()){
            logger.debug("Object is not Null");
            response.setStatus( HttpServletResponse.SC_OK);
            return p.get();
        }
        else{
            logger.error("Object is NULLABLE, Default object set to : " + (new Person("Default", "User", LocalDate.of(1900,1,1), Gender.Male, 0L)));
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
            return p.orElse(new Person("Default", "User", LocalDate.of(1900,1,1), Gender.Male, 0L));
        }
    }

    /**
     * Create Person
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(@RequestBody final Person person, HttpServletRequest request, HttpServletResponse response){

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


    /**
     *To handle the Static method for implementing the Standard functional Interfaces using lambdas
     *
     * @return
     */
    @RequestMapping(value = "/filter")
    public List<String> getfilterValuescont(HttpServletRequest request, HttpServletResponse response) {
        List<String > newUpdatedList = filterValues.getfilterValues(inventory,
                person -> Gender.Female.equals(person.getGender()),
                (Person p1, Person p2) -> p1.getId().compareTo(p2.getId()), person -> person.getFirst_Name() + " " + person.getLast_Name());
        response.setStatus( HttpServletResponse.SC_OK);
        logger.debug("Converted List");
        return newUpdatedList;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


}
