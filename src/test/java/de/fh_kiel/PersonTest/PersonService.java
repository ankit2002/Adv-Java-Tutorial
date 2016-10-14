package de.fh_kiel.PersonTest;
import com.sun.org.apache.xpath.internal.operations.Equals;
import de.fh_kiel.Person.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.TreeSet;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Ankit on 10/8/2016.
 */
public class PersonService {

    public static void main(String args[]){


        de.fh_kiel.Person.PersonService ps = new de.fh_kiel.Person.PersonService();

        Person p = ps.createDev("Alex","thor", LocalDate.of(1980,2,2),"male",2,5000,new String[]{"java","c++"});
        ps.createDev("Amit","Nagar",LocalDate.of(1970,5,1),"male",2,4000,new String[]{"js","python"});
        ps.createDev("tarun","sharma",LocalDate.of(1967,3,5),"mae",2,3000,new String[]{"c","asp.net"});
        ps.createPM("Faiz","khan",LocalDate.of(1960,6,7),"mae",2,2000,new String[]{"ruby","asp"},5);
        ps.createPM("Veer","Jaara",LocalDate.of(1970,2,9),"mae",2,1500,new String[]{"perl","c++"},2);

        ps.showShortedData();
        ps.searchPerson("Rahu","Raa","mae",LocalDate.of(1980,2,2));

        // Object Check
        assertEquals(ps.createDev("Alex","thor", LocalDate.of(1980,2,2),"male",2,5000,new String[]{"java","c++"}),p);
    }

}
