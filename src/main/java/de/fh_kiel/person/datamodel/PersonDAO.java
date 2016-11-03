package de.fh_kiel.person.datamodel;



import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.stubclass.Person;

import java.util.Collection;

/**
 * Created by Ankit on 10/11/2016.
 */
public interface PersonDAO {

    /**
     *
     * @param p
     */
    public boolean createPerson(Person p);

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
    public Person getPerson(long id) throws PersonNotFound;

    /**
     * updatedPerson
     * @param p
     * @return
     */
    public boolean updatePerson(Person p) throws Exception;

    /**
     * deletePerson
     * @param p
     * @return
     */
    public boolean deletePerson(Person p);
}
