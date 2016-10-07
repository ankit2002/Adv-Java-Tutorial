package de.fh_kiel.Person;

/**
 * Created by Ankit on 10/7/2016.
 */
public class Developer extends Person {

    private float workExp;
    private double min_Salary;
    private String[] prog_lang;

    public void setWorkExp(float workex){
        workExp = workex;
    }

    public void setMin_Salary(double min_Sal){
        min_Salary = min_Sal;
    }

    public void setProg_lang(String str[]){
        prog_lang = str;
    }

    public float getWorkExp(){
        return workExp;
    }

    public double getMin_Salary(){
        return min_Salary;
    }

    public String[] getProg_lang(){
        String str[] = {"1","2"};
        return str;
    }

}
