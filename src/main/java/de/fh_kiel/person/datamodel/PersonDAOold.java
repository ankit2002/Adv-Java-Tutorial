package de.fh_kiel.person.datamodel;



import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.stubclass.Person;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Ankit on 10/11/2016.
 */
public interface PersonDAOold {

    /**
     *
     * @param p
     */
    public long createPerson(Person p);

    /**
     *
     * @return
     */
    public Collection<Person> getAllPersons();

    /**
     *
     * @param id
     * @return
     * @throws PersonNotFound
     */
    public Optional<Person> getPerson(long id);

    /**
     * updatedPerson
     * @param p
     * @return
     */
    public void updatePerson(Person p, long id) throws Exception;

    /**
     * deletePerson
     * @param id
     * @return
     */
    public void deletePerson(long id);
}
