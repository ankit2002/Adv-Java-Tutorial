package de.fh_kiel.person.datamodel;


import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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



    private static final Set<Person> listPerson = new HashSet<>();
    static {
        listPerson.add(new Person("Amit", "Nagar", LocalDate.of(1988,10,10), Gender.Male, 1));
        listPerson.add(new Person("A", "Nagar1", LocalDate.of(1988,10,10), Gender.Male, 2));
        listPerson.add(new Person("m", "Nagar2", LocalDate.of(1988,10,10), Gender.Male, 3));
        listPerson.add(new Person("it", "Nagar3", LocalDate.of(1988,10,10), Gender.Male, 4));
    }

    @Override
    public long createPerson(Person p) {
        if(p.getId() != 0L && p != null) {
            listPerson.add(p);
            return p.getId();
        }
        logger.error("Person is null cannot be created");
        return 0L;
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
