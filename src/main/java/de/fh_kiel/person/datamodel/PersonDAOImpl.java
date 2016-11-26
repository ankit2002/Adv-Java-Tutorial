package de.fh_kiel.person.datamodel;


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
    static {
        listPerson.put(1L,new Person("Amit", "Nagar", LocalDate.of(1988,10,10), Gender.Male, 1L));
    }

    /**
     * createPerson
     * @param p
     * @return
     */
    @Override
    public long createPerson(Person p) {


        if (p.getId() != null) {
            throw new IllegalArgumentException("Passed person is not new");
        }

        final Long maxId = listPerson.isEmpty() ? 0L : Collections.max(listPerson.keySet(), (o1, o2) ->
                new CompareToBuilder().append(o1, o2).toComparison());

        // saving data
        p.setId(maxId + 1L);
        listPerson.put(p.getId(),p);
        return maxId;
    }

    /**
     * getAllPersons
     * @return
     */
    @Override
    public Collection<Person> getAllPersons() {
        return new ArrayList<>(listPerson.values());
    }

    /**
     * getPerson by id
     * @param id
     * @return
     */
    @Override
    public Optional<Person> getPerson(long id) {
        Person p = listPerson.get(id);
        return Optional.ofNullable(p); // can be null; used for debugging
    }

    /**
     * updatePerson
     * @param p
     * @param id
     * @throws Exception
     */
    @Override
    public void updatePerson(Person p, long id) throws Exception {

        Optional<Person> person;
        person = getPerson(id);
        if(person.isPresent()){
            this.deletePerson(id);
            listPerson.put(id,p);
        }
    }

    /**
     * Delete Person
     * @param id
     */
    @Override
    public void deletePerson(long id) {

        Optional<Person> person;
        person = getPerson(id);
        if(person.isPresent()) {
            listPerson.remove(id);
        }
    }
}
