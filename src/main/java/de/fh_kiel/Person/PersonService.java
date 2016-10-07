package de.fh_kiel.Person;
import java.time.LocalDate;

/**
 * Created by amit on 07.10.16.
 */
public class PersonService {

    // Main Method
    public static void main(String args[]){
        Person person = new Person("Amit","Nagar", LocalDate.of(1980,1,01),"Male");


        Developer developer = new Developer();


        System.out.println(person.getFirst_Name() + " " +person.getLast_Name() +" "+ person.getAge() +" "+ person.getGender());
        System.out.println("tostring :" + person.toString());
        System.out.println("Hash :" + person.hashCode()+"  "+developer.getFirst_Name());
    }

}
