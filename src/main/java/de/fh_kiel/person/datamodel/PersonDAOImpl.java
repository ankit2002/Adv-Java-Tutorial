package de.fh_kiel.person.datamodel;


import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;


/**
 * Created by Ankit on 10/15/2016.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);


    // changing Set to Map
    private static final Map<Long, Person> listPerson = new HashMap<>();

    @Override
    public long createPerson(Person p) {

        if (p.getId() != null) {
            throw new IllegalArgumentException("Passed person is not new");
        }

        final Long maxId = listPerson.isEmpty() ? 0L : Collections.max(listPerson.keySet(), (o1, o2) ->
                new CompareToBuilder().append(o1, o2).toComparison()
        );

        // saving data
        p.setId(maxId);
        listPerson.put(maxId,p);
        return maxId;
    }

    @Override
    public Collection<Person> getAllPersons() {
        return new ArrayList<>(listPerson.values());
    }

    @Override
    public Person getPerson(long id) throws PersonNotFound  {

        Person p = listPerson.get(id);
        if (p == null)
            throw new PersonNotFound("Person Not Found with id - " + id);
        return p;
    }

    @Override
    public void updatePerson(Person p, long id) throws Exception {

        Person person = null;
        try{
            person = getPerson(id);
        }catch (PersonNotFound personNotFound){
            throw new Exception(personNotFound.toString());
        }

        if( person != null ) {
            /**
             * having problem in deletion after updation.
             */
            /*person.setFirst_Name(p.getFirst_Name());
            person.setLast_Name(p.getLast_Name());
            person.setD_o_b(p.getD_o_b());
            person.setGender(p.getGender());*/
            this.deletePerson(id);
            this.createPerson(p);
        }
    }

    @Override
    public void deletePerson(long id) {
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
