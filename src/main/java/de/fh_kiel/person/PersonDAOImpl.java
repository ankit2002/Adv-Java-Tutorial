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


    /**
     * // Search Person using First Name & Last Name
     * @param fname
     * @param lname
     *
     */
    public void searchPerson(String fname,String lname){
        TreeSet<Person> ts = sortedData();
        Person p = new Person();
        p.setFirst_Name(fname);
        p.setLast_Name(lname);

        if(ts.contains(p)){
            System.out.println("Person Found" + p.toString());
        }
        else {
            System.out.println("Person Not Found");
        }
    }


    /**
     * Sort Data
     * @return
     */
    private TreeSet<Person> sortedData(){
        TreeSet<Person> ts = new TreeSet<>();
        if(this.listPerson!=null){
            ts.addAll(this.listPerson);
        }
        return ts;
    }

    /**
     * Display Sorted Data
     */
    public void showSortedData(){
        for (Person p:sortedData()) {
            System.out.println(p.toString());
        }
    }


    /**
     * Get Person By Programming Language
     * @param programmingLanguage
     * @return
     */
    public Collection<Person> getPersonByProgLang(final String programmingLanguage) {
        final Collection<Person> result = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(final Person o1, final Person o2) {
                return new CompareToBuilder().append(o1.getLast_Name(), o2.getLast_Name()).append
                        (o1.getFirst_Name(), o2.getFirst_Name()).toComparison();
            }
        });

        for (final Person person : getAllPersons()) {
            if (!(person instanceof Developer)) {
                continue;
            }

            final Developer developer = (Developer) person;
            for (final String currProgrammingLanguage : developer.getProg_lang()) {
                if (currProgrammingLanguage.equals(programmingLanguage)) {
                    result.add(developer);
                    break;
                }
            }
        }
        return result;
    }

}
