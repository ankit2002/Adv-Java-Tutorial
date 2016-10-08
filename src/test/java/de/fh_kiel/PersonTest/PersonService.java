package de.fh_kiel.PersonTest;
import com.sun.org.apache.xpath.internal.operations.Equals;
import de.fh_kiel.Person.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.TreeSet;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ankit on 10/8/2016.
 */
public class PersonService {

    public static void main(String args[]){


        de.fh_kiel.Person.PersonService ps = new de.fh_kiel.Person.PersonService();

        Person p = ps.createDev("Ankit","Rra", LocalDate.of(1980,2,2),"mae",2,50000,new String[]{"java","c++","asp"});
        ps.createDev("Rahu","Raa",LocalDate.of(1980,2,2),"mae",2,50000,new String[]{"java","c++","asp"});
        ps.createDev("sud","Raas",LocalDate.of(1980,2,2),"mae",2,50000,new String[]{"java","c++","asp"});
        ps.createPM("mkit","Rasa",LocalDate.of(1980,2,2),"mae",2,50000,new String[]{"java","c++","asp"},5);
        ps.createPM("tnkit","Raf",LocalDate.of(1980,2,2),"mae",2,50000,new String[]{"java","c++","asp"},2);


        System.out.println("Result");
        ps.showShortedData();
        ps.searchPerson("Rahu","Raa","mae",LocalDate.of(1980,2,2));
        assertEquals("fasdfasd",ps.createDev("Ankit","Rra", LocalDate.of(1980,2,2),"mae",2,50000,new String[]{"java","c++","asp"}),p);

    }

}
