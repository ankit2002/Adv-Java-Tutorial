package de.fh_kiel.Person;
import java.time.LocalDate;

/**
 * Created by amit on 07.10.16.
 */
public class PersonService {


    public void showAllDev(){

    }

    public void showAllPM(){

    }

    public void searchPM(){

    }

    public void searchDev(){

    }




    // Main Method
    public static void main(String args[]){

        ProjectManager[] projectManagers = new ProjectManager[5];

        for (int i=0;i<5;i++){
            ProjectManager pm = new ProjectManager();
            pm.setFirst_Name("Amit"+i);
            pm.setD_o_b(LocalDate.of(1980,i+1,2));
            pm.setGender("Male");
            pm.setLast_Name("Nagar");
            pm.setWorkExp(3);
            pm.setMin_Salary(220000);
            String[] arr = {"java","jsp","loda","c++"};
            pm.setProg_lang(arr);
            pm.setPmExp(2);
            projectManagers[i] = pm;
        }


        for (ProjectManager pm:projectManagers){
            System.out.println(pm.toString());
        }


    }

}
