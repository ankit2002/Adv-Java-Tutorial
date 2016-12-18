package de.fh_kiel.person.service;

//import de.fh_kiel.person.Developer;
//import de.fh_kiel.person.Person;

import de.fh_kiel.person.checkmethod.CheckNull;
import de.fh_kiel.person.datamodel.PersonDAO;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


/**
 * Created by amit on 07.10.16.
 */

@Service
public class PersonService {

    /**
     * Injecting dependency for Person DAO
     */
    Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonDAO personDAO;

    /**
     * Get All Person
     *
     * @return
     */

    @CheckNull
    public Collection<Person> getAllPersons() {
        return this.personDAO.findAll();
    }

    /**
     * get Person by ID
     *
     * @param id
     * @return
     */
    @CheckNull
    public Person getPersonById(long id) {
        return personDAO.findOne(id);
    }

    /**
     * Create Person
     *
     * @param person
     * @return
     */

    @CheckNull
    public List<Person> createPerson(Person person) {
        personDAO.save(person);
        return personDAO.findAll();
    }

    /**
     * Delete Person by id
     *
     * @param id
     * @return
     */
    @CheckNull
    public void deletePerson(long id) throws Exception {
        if (personDAO.findOne(id).getId() == id) {
            System.out.print("amitisinsidedelete: + " + id + "hellodi: " + personDAO.findOne(id));
            personDAO.delete(id);
        }
    }

//
//    /**
//     * Update a Person based on id
//     * @param person
//     */
//    @CheckNull
//    public void updatePerson(Person person) {
//        if (personDAO.findOne(person.getId()).getId() == person.getId()) {
//            System.out.print("amitisinside: + " + person);
//            personDAO.save(person);
//        }
//    }
//     /* public void updatePerson(Long id) {
//        Person p = personRepository.findOne(id);
//        p.setLast_Name("i am changed");
//        personRepository.save(p);
//    }*/
}



/*
    // Get Person Size
    @CheckNull
    public int getAllPersonsSize(){
        return personDAO.getAllPersons().size();
    }



    *//**
     * Sort Data
     * @return
     *//*
    private TreeSet<Person> sortedData(){
        TreeSet<Person> ts = new TreeSet<>();
        if(personDAO.getAllPersons()!=null){
            ts.addAll(personDAO.getAllPersons());
        }
        return ts;
    }

    *//**
     * Display Sorted Data
     *//*
    public void showSortedData(){
        for (Person p:sortedData()) {
            System.out.println("Ankit");
            System.out.println(p.toString());
        }
    }


    *//**
     * listPersons
     * Get Person By Programming Language
     * @param programmingLanguage
     * @return
     *//*
    public Collection<Person> getPersonByProgLang(final String programmingLanguage) {




        *//*final Collection<Person> result = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(final Person o1, final Person o2) {
                return new CompareToBuilder().append(o1.getLast_Name(), o2.getLast_Name()).append
                        (o1.getFirst_Name(), o2.getFirst_Name()).toComparison();
            }
        });*//*

        *//**
         * Refactored Listpersons mEthod using Lambdas and Method refrences
         *//*
       *//* final Collection<Person> result = new TreeSet<>((Person o1, Person o2)->{
           return Comparator.comparing(Person::getLast_Name)
                   .thenComparing(Person::getFirst_Name)
                   .compare(o1,o2);
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
        System.out.println("Listperson after comparing:" + result);*//*
        return null;
    }
*/

    // refactor programming