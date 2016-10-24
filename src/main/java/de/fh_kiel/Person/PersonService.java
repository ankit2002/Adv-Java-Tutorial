package de.fh_kiel.Person;

import java.util.*;


/**
 * Created by amit on 07.10.16.
 */

public class PersonService {

    private final PersonDAO personDAO;

    // Constructor
    public PersonService( PersonDAO personDao )
    {
        this.personDAO = personDao;
    }

    // Create Person
    public void createPerson(Person person){
        personDAO.createPerson(person);
    }

    // Get Person
    public Collection<Person> getAllPersons(){
        return personDAO.getAllPersons();
    }

    // Get Person Size
    public int getAllPersonsSize(){
        return personDAO.getAllPersons().size();
    }


    // Update Person
    public boolean updatePerson(Person person) {
       return personDAO.updatedPerson(person);
    }

    // Delete Person
    public boolean deletePerson(Person person){
        return personDAO.deletePerson(person);
    }
}
