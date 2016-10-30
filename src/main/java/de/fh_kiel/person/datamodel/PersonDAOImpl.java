package de.fh_kiel.person.datamodel;

//import de.fh_kiel.person.Person;

import de.fh_kiel.person.exception.PersonNotFound;
import de.fh_kiel.person.stubclass.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;


/**
 * Created by Ankit on 10/15/2016.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {


    private final HashSet<Person> listPerson = new HashSet<>();

    @Override
    public void createPerson(Person p) {
        listPerson.add(p);
    }

    @Override
    public Collection<Person> getAllPersons() {
        return listPerson;
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
    public boolean deletePerson(Person p) {

        Person person = null;
        try{
            person = getPerson(p.getId());
        }catch (PersonNotFound personNotFound){
            System.out.println("Person not Found");
        }
        if(person != null) {
            listPerson.remove(person);
            return true;
        }
        else {
            return false;
        }
    }
}
