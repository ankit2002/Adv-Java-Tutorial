package de.fh_kiel.person.controller;

import de.fh_kiel.person.service.PersonService;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ankit on 10/28/2016.
 */

@RestController
@RequestMapping("/person")
public class PersonController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

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



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response){

        Person p  = personService.getPersonById(id);
        if (p !=null) {
            logger.debug("Get person by id");
            response.setStatus( HttpServletResponse.SC_OK);
        }
        else {
            logger.error("No object found with this id");
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return p;
    }


    /**
     * Create Person
     * @param person
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> createPerson(@RequestBody final Person person, HttpServletRequest request, HttpServletResponse response){

        if(person != null){
            logger.debug("Person Created");
            response.setStatus( HttpServletResponse.SC_OK);
        }
        else {
        logger.error("Person was null and cant be created");
        response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return this.personService.createPerson(person);
    }

    /**
     * Delete a person based on the ID
     * @param id
     * @param request
     * @param response
     */

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void  deletePerson(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("To delete a person by id");
        try{
            personService.deletePerson(id);
            response.setStatus( HttpServletResponse.SC_OK);
        }catch (Exception e){
            logger.error("Exception during delete: " + e);
        }
    }


    /**
     * Update person by id
     * @param id
     * @param person
     * @param request
     * @param response
     */

    @RequestMapping(value ="update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable("id") long id,@RequestBody Person person, HttpServletRequest request, HttpServletResponse response){
        System.out.println("personupdateamit id:" + id);
        System.out.println("personupdateamit person:" + person.getId());
        if(person.getId() == id){
            logger.error("To update a person");
            response.setStatus( HttpServletResponse.SC_OK);
            personService.updatePerson(person);

        }else {
            logger.error("Person's ID is not same for updation");
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }

    }



    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**

    *
     * Create Person
     * @return

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

    *
     * Updation Method
     * @param id
     * @param person

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

    *
     * Delete Person
     * @param id

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus( HttpServletResponse.SC_OK);
        logger.debug("To delete a person by id");
        personService.deletePerson(id);
    }*/


    /**
     * Error Handling
     * @return
     */


     /*static final List<Person> inventory = new ArrayList<>();
    static {
        inventory.add(new Person("Amit", "Nagar", LocalDate.of(1988, 10, 10), Gender.Female, 5L));
        inventory.add(new Person("Rimi", "Tina", LocalDate.of(1988, 10, 10), Gender.Female, 6L));
        inventory.add(new Person("Niki", "Mili", LocalDate.of(1988, 10, 10), Gender.Female, 2L));
        inventory.add(new Person("Brian", "Kris", LocalDate.of(1988, 10, 10), Gender.Male, 4L));
        inventory.add(new Person("Mr", "Nathan", LocalDate.of(1988, 10, 10), Gender.Male, 3L));
        inventory.add(new Person("Miss", "Kat", LocalDate.of(1988, 10, 10), Gender.Female, 1L));
    }
*/

    /**
     *To handle the Static method for implementing the Standard functional Interfaces using lambdas
     *
     * @return
     */
   /* @RequestMapping(value = "/filter")
    public List<String> getfilterValuescont(HttpServletRequest request, HttpServletResponse response) {
        List<String > newUpdatedList = filterValues.getfilterValues(inventory,
                person -> Gender.Female.equals(person.getGender()),
                (Person p1, Person p2) -> p1.getId().compareTo(p2.getId()), person -> person.getFirst_Name() + " " + person.getLast_Name());
        response.setStatus( HttpServletResponse.SC_OK);
        logger.debug("Converted List");
        return newUpdatedList;
    }*/


}
