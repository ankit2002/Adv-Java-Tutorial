package de.fh_kiel.Person;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ankit on 10/7/2016.
 */
public class Developer extends Person {

    private float workExp;
    private double min_Salary;
//    private String[] prog_lang;
    private final Set<String> prog_lang = new HashSet<>();


    public Developer(){}

    public Developer(final String fName,final  String lName, final LocalDate dob, final String gen, final long id,final float workex, final double min_Sal){
        super(fName, lName, dob, gen,id);
        this.workExp = workex;
        this.min_Salary = min_Sal;
    }

    /*
    * getter and Setter Method of the class Variables
    */

    public void setWorkExp(float workex){
        this.workExp = workex;
    }

    public float getWorkExp(){
        return this.workExp;
    }

    public void setMin_Salary(double min_Sal){
        this.min_Salary = min_Sal;
    }

    public double getMin_Salary(){
        return this.min_Salary;
    }

    /*public void setProg_lang(String str[]){
        this.prog_lang = str;
    }*/

    public Set<String> getProg_lang(){
        return this.prog_lang;
    }

    public void removeProgrammingLanguage(String programmingLanguage) {
        prog_lang.remove(programmingLanguage);
    }

    public void addProgrammingLanguage(final String programmingLanguage) {
        this.prog_lang.add(programmingLanguage);
    }

}