package de.fh_kiel.Person;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Ankit on 10/4/2016.
 */
public class Person {

    private String first_Name;
    private String last_Name;
    private LocalDate d_o_b;
    private  String gender;

    // Constructor
    public Person(String fName,String lName,LocalDate dob,String gen){
        first_Name = fName;
        last_Name = lName;
        d_o_b = dob;
        gender = gen;
    }


    // Getter Method for First Name
    public String getFirst_Name(){
        return this.first_Name;
    }

    // Getter Method for Last Name
    public String getLast_Name(){
        return this.last_Name;
    }

    // Getter Method for Last Name
    public String getGender(){
        return this.gender;
    }



    // Getter Method for Age
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if ((d_o_b != null) && (currentDate != null)) {
            return Period.between(d_o_b, currentDate).getYears();
        } else {
            return 0;
        }
    }


    public static void main(String args[]){
        Person person = new Person("Amit","Nagar", LocalDate.of(1988,2,05),"Male");

        System.out.println(person.getFirst_Name() + " " +person.getLast_Name() +" "+ person.getAge() +" "+ person.getGender());
    }
}
