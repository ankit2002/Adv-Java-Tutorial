package de.fh_kiel.person.datamodel;


import org.slf4j.Logger;
import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Ankit on 10/15/2016.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);



    private final Set<Person> listPerson = new HashSet<>();

    @Override
    public boolean createPerson(Person p) {
        if(p != null) {
            listPerson.add(p);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Person> getAllPersons() {
        return new ArrayList<>(listPerson);
    }

    @Override
    public Person getPerson(long id) throws PersonNotFound  {

        for (Person p:listPerson) {
            if(p.getId()==id){
                return p;
            }
        }
        throw new PersonNotFound("Person Not Found");
    }

    @Override
    public void updatePerson(Person p) throws Exception {

        Person person = null;
        try{
            person = getPerson(p.getId());
        }catch (PersonNotFound personNotFound){
            throw new Exception(personNotFound.toString());
        }

        if( person != null )
        {
            // Updated
            person.setFirst_Name(p.getFirst_Name());
            person.setLast_Name(p.getLast_Name());
            person.setD_o_b(p.getD_o_b());
            person.setGender(p.getGender());
        }
        else
        {
            throw new Exception("Person can not updated");
        }
    }

    @Override
    public void deletePerson(Long id) {

        Person person = null;
        try{
            person = getPerson(id);
        }catch (PersonNotFound personNotFound){
            logger.warn(personNotFound.getLocalizedMessage());
        }
        if(person != null) {
            listPerson.remove(person);
        }
    }
}
