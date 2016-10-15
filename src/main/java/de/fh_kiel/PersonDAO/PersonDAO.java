package de.fh_kiel.PersonDAO;
import de.fh_kiel.Exception.PersonNotFound;
import de.fh_kiel.Person.Person;

import java.util.Collection;

/**
 * Created by Ankit on 10/11/2016.
 */
public interface PersonDAO {


    // Method to create Person
    public void createPerson(Person p);

    // Method to get All Person
    public Collection<Person> getAllPersons();

    // Method to get Person
    public Person getPerson(long id) throws PersonNotFound;

    // Method to create Person
    public boolean updatedPerson(Person p);

    // Method to deletePerson
    public boolean deletePerson(Person p);
}
