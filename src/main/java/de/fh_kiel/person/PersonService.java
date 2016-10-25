package de.fh_kiel.person;

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

    /**
     * Create Person
     * @param person
     */
    public void createPerson(Person person){
        personDAO.createPerson(person);
    }

    /**
     * Get All Person
     * @return
     */
    public Collection<Person> getAllPersons(){
        return personDAO.getAllPersons();
    }

    /**
     * get Person by ID
     * @param id
     * @return
     */
    public Person getPersonById(long id){
        return null;
    }

    // Get Person Size
    public int getAllPersonsSize(){
        return personDAO.getAllPersons().size();
    }


    /**
     * Update Person
     * @param person
     * @return
     */
    public void updatePerson(Person person) {
        try{
            personDAO.updatePerson(person);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


    // Delete Person

    /**
     * Delete Person
     * @param person
     * @return
     */
    public boolean deletePerson(Person person){
        return personDAO.deletePerson(person);
    }

}
