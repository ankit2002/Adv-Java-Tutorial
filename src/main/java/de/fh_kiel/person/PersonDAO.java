package de.fh_kiel.person;

import java.util.Collection;

/**
 * Created by Ankit on 10/11/2016.
 */
public interface PersonDAO {

    /**
     *
     * @param p
     */
    public void createPerson(Person p);

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
    public void updatePerson(Person p) throws Exception;

    /**
     * deletePerson
     * @param p
     * @return
     */
    public boolean deletePerson(Person p);
}