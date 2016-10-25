package de.fh_kiel.person;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.*;


/**
 * Created by amit on 07.10.16.
 */

public class PersonService {

    private final PersonDAO personDAO;

    // Constructor
    public PersonService( PersonDAO personDao )
    {
        this.personDAO = personDao;
    }

    // Create Person
    public void createPerson(Person person){
        personDAO.createPerson(person);
    }

    // Get Person
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


    // Update Person
    public boolean updatePerson(Person person) {
       return personDAO.updatedPerson(person);
    }


    // Delete Person
    public boolean deletePerson(Person person){
        return personDAO.deletePerson(person);
    }


    public Collection<Person> getPersonByProgLang(final String programmingLanguage) {
        final Collection<Person> result = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(final Person o1, final Person o2) {
                return new CompareToBuilder().append(o1.getLast_Name(), o2.getLast_Name()).append
                        (o1.getFirst_Name(), o2.getFirst_Name()).toComparison();
            }
        });

        for (final Person person : personDAO.getAllPersons()) {
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
