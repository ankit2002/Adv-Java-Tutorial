package de.fh_kiel.person.model;

import de.fh_kiel.person.Developer;
import de.fh_kiel.person.Person;
import de.fh_kiel.person.datamodel.PersonDAO;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by amit on 07.10.16.
 */
@Service
public class PersonService {

    private final PersonDAO personDAO;

    // Constructor
    @Autowired
    public PersonService( PersonDAO personDao )
    {
        this.personDAO = personDao;
    }

    /**
     * Create Person
     * @param person
     */
    public void createPerson(Person person){
        personDAO.createPerson(person);
    }

    /**
     * Get All Person
     * @return
     */
    public Collection<Person> getAllPersons(){
        return personDAO.getAllPersons();
    }

    /**
     * get Person by ID
     * @param id
     * @return
     */
    public Person getPersonById(long id){
        return null;
    }

    // Get Person Size
    public int getAllPersonsSize(){
        return personDAO.getAllPersons().size();
    }


    /**
     * Update Person
     * @param person
     * @return
     */
    public void updatePerson(Person person) {
        try{
            personDAO.updatePerson(person);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * Delete Person
     * @param person
     * @return
     */
    public boolean deletePerson(Person person){
        return personDAO.deletePerson(person);
    }



    /**
     * Sort Data
     * @return
     */
    private TreeSet<Person> sortedData(){
        TreeSet<Person> ts = new TreeSet<>();
        if(personDAO.getAllPersons()!=null){
            ts.addAll(personDAO.getAllPersons());
        }
        return ts;
    }

    /**
     * Display Sorted Data
     */
    public void showSortedData(){
        for (Person p:sortedData()) {
            System.out.println("Ankit");
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
