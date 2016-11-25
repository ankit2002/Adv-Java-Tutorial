package de.fh_kiel.person.stubclass;
import de.fh_kiel.annotation.BoilerPlate;
import java.time.LocalDate;
import java.time.Period;
import java.io.*;

/**
 * Created by Ankit on 10/4/2016.
 */

@BoilerPlate
public class PersonStub implements Serializable {

    private String first_Name;
    private String last_Name;
    private LocalDate d_o_b;
    private Gender gender;
    private Long id;

    // Getter Method for Age
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if ((d_o_b != null) && (currentDate != null)) {
            return Period.between(d_o_b, currentDate).getYears();
        } else {
            return 0;
        }
    }

    // update personData
    public PersonStub updatePersonData(String fName, String lName, LocalDate dob, Gender gen) {
        this.first_Name = fName;
        this.last_Name = lName;
        this.d_o_b = dob;
        this.gender = gen;
        return this;
    }
}