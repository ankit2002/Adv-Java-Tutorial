package de.fh_kiel.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.Predicate;


/**
 * Created by amit on 07.10.16.
 */
public class PersonService {

    ArrayList<Person> listPerson = new ArrayList<>();

    public void searchPerson(String fname,String lname,String gender,LocalDate age){

        long uniqueId;
        TreeSet<Person> ts = shortedData();
        Person p = new Person();
        p.setFirst_Name(fname);
        p.setLast_Name(lname);
        p.setD_o_b(age);
        p.setGender(gender);
        // Added call to generate unique random id
        uniqueId = UUID.randomUUID().getMostSignificantBits();
        p.getUniqueId(uniqueId);
        System.out.println("main : " + p.getUniqueId(uniqueId));

        if(ts.contains(p)){
            System.out.println("Person Found");
            System.out.println(p.toString());
        }
        else {
            System.out.println("Person Not Found");
        }
    }


    private TreeSet<Person> shortedData(){
        TreeSet<Person> ts = new TreeSet<>();
        if(listPerson!=null){
            ts.addAll(listPerson);
        }
        return ts;
    }

    public void showShortedData(){
        for (Person p:shortedData()) {
            System.out.println(p.toString());
        }
    }

    public Person createDev(String fname, String lname, LocalDate dte, String gender, float workex, double min_Sal, String arr[]){
        Developer obj = new Developer();
//        obj.setFirst_Name(fname);
        obj.firstName(fname);
        obj.setD_o_b(dte);
        obj.setGender(gender);
        obj.setLast_Name(lname);
        obj.setWorkExp(workex);
        obj.setMin_Salary(min_Sal);
        obj.setProg_lang(arr);
        listPerson.add(obj);
        return obj;
    }


    public Person createPM(String fname,String lname,LocalDate dte,String gender,float workex,double min_Sal,String arr[],float pmExp){

        if(pmExp<=workex){
            ProjectManager obj = new ProjectManager();
//            obj.setFirst_Name(fname);
            obj.firstName(fname);
            obj.setD_o_b(dte);
            obj.setGender(gender);
            obj.setLast_Name(lname);
            obj.setWorkExp(workex);
            obj.setMin_Salary(min_Sal);
            obj.setProg_lang(arr);
            obj.setPmExp(pmExp);
            listPerson.add(obj);
            return obj;
        }else {
            System.out.println("Exp is Greater");
        }

        return null;
    }



    public ArrayList<Person> getAllPersons(){
        return listPerson;
    }

}
