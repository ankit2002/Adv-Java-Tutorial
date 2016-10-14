package de.fh_kiel.Person;

/**
 * Created by Ankit on 10/7/2016.
 */
public class Developer extends Person {

    private float workExp;
    private double min_Salary;
    private String[] prog_lang;


    public Developer(){}


    public Developer(float workex,double min_Sal,String str[]){
        this.workExp = workex;
        this.min_Salary = min_Sal;
        this.prog_lang = str;
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

    public void setProg_lang(String str[]){
        this.prog_lang = str;
    }

    public String[] getProg_lang(){
        return this.prog_lang;
    }

}
