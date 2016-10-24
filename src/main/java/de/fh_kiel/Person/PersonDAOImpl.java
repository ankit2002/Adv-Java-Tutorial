package de.fh_kiel.Person;

import java.time.LocalDate;
import java.util.*;


/**
 * Created by Ankit on 10/15/2016.
 */
public class PersonDAOImpl implements PersonDAO {


//    ArrayList<Person> listPerson = new ArrayList<>();
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
    public boolean updatedPerson(Person p) {

        Person person = null;
        try{
            person = getPerson(p.getId());
        }catch (PersonNotFound personNotFound){
            System.out.println("Person not Found");
        }

        if( person != null )
        {
           // person.updatePersonData(p.getFirst_Name(),p.getLast_Name(),p.getD_o_b(),p.getGender());
            return true;
        }
        else
        {
            System.out.println("Cant not update");
            return false;
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




    // Searching Method
    public void searchPerson(String fname,String lname,String gender,LocalDate age){
        TreeSet<Person> ts = sortedData();
        Person p = new Person();
        p.setFirst_Name(fname);
        p.setLast_Name(lname);
        p.setD_o_b(age);
        p.setGender(gender);

        if(ts.contains(p)){
            System.out.println("Person Found" + p.toString());
        }
        else {
            System.out.println("Person Not Found");
        }
    }


    // Sorted Data
    private TreeSet<Person> sortedData(){
        TreeSet<Person> ts = new TreeSet<>();
        if(this.listPerson!=null){
            ts.addAll(this.listPerson);
        }
        return ts;
    }
    // Display Sorted Data
    public void showSortedData(){
        for (Person p:sortedData()) {
            System.out.println(p.toString());
        }
    }
}
