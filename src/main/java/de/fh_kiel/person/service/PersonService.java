package de.fh_kiel.person.service;

//import de.fh_kiel.person.Developer;
//import de.fh_kiel.person.Person;

import de.fh_kiel.person.checkmethod.CheckNull;
import de.fh_kiel.person.datamodel.PersonDAO;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


/**
 * Created by amit on 07.10.16.
 */

@Service
public class PersonService {

    /**
     * Injecting dependency for Person DAO
     */
    Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonDAO personDAO;

    /**
     * Get All Person
     *
     * @return
     */

    @CheckNull
    public Collection<Person> getAllPersons() {
        return this.personDAO.findAll();
    }

    /**
     * get Person by ID
     *
     * @param id
     * @return
     */
    @CheckNull
    public Person getPersonById(long id) {
        return personDAO.findOne(id);
    }

    /**
     * Create Person
     *
     * @param person
     * @return
     */

    @CheckNull
    public List<Person> createPerson(Person person) {
        personDAO.save(person);
        return personDAO.findAll();
    }

    /**
     * Delete Person by id
     *
     * @param id
     * @return
     */
    @CheckNull
    @Transactional(propagation = Propagation.REQUIRED)
    public void deletePerson(long id) throws Exception {
        if (personDAO.findOne(id).getId() == id) {
            System.out.print("amitisinsidedelete: + " + id + "hellodi: " + personDAO.findOne(id));
            personDAO.delete(id);
        }
    }


    /**
     * Update a Person based on id
     * @param person
     */
    @CheckNull
    public void updatePerson(Person person) {
        if (personDAO.findOne(person.getId()).getId() == person.getId()) {
            System.out.print("amitisinside: + " + person);
            personDAO.save(person);
        }
    }
}