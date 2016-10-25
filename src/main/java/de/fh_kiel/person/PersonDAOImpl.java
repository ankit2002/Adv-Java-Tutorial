package de.fh_kiel.person;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.time.LocalDate;
import java.util.*;


/**
 * Created by Ankit on 10/15/2016.
 */
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
            listPerson.remove(p);
            return true;
        }
        else {
            return false;
        }
    }
}
