package de.fh_kiel.Person;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;
import java.time.Period;
import java.io.*;
import java.util.UUID;

/**
 * Created by Ankit on 10/4/2016.
 */


public class Person implements Comparable<Person> , Serializable {

    private String first_Name;
    private String last_Name;
    private LocalDate d_o_b;
    private String gender;
    private static final long serialVersionUID = 1L;
    private long id;

//    public Person(){}

    /*// Constructor
    public Person(String fName,String lName,LocalDate dob,String gen){
        first_Name = fName;
        last_Name = lName;
        d_o_b = dob;
        gender = gen;
    }*/

    @Override
    public int compareTo(Person o) {
        return this.getFirst_Name().compareTo(o.getFirst_Name());
    }


    public void setFirst_Name(String fName){
        first_Name = fName;
    }

    public void setLast_Name(String lName){
        last_Name = lName;
    }

    public void setD_o_b(LocalDate dob){
        d_o_b = dob;
    }

    public void setGender(String gen){
        gender = gen;
    }

    //public void setUniqueId(long id){
      //  this.id = id;
    //}

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
    //getter for unique id
    public long getUniqueId(long id){
        this.id = id;
        System.out.println ("id : " + this.id);

        return this.id;
    }

    public String toString() {
        return new ToStringBuilder(this).
                append("Firstname", getFirst_Name()).
                append("LastName", getLast_Name()).
                append("Age", getAge()).
                append("Gender",getGender()).
                append("Id" ,id).
                toString();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(this.getFirst_Name())
                .append(this.getLast_Name())
                .append(this.getAge())
                .append(this.getGender())
                .append(this.id)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Person otherObject = (Person) obj;

        return new EqualsBuilder()
                .append(this.getFirst_Name(), otherObject.getFirst_Name())
                .append(this.getLast_Name(), otherObject.getLast_Name())
                .append(this.getAge(), otherObject.getAge())
                .append(this.getGender(),otherObject.getGender())
                .append(this.id,otherObject.id)
                .isEquals();
    }


}