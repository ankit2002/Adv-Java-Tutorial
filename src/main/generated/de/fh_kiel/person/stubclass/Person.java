package de.fh_kiel.person.stubclass;

import de.fh_kiel.person.worklog.WorklogDayEntry;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

//@Generated("annotation processor")
@Entity(name = "PERSON_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  @Column(name ="FIRST_NAME")
  private String first_Name;

  @Column(name ="LAST_NAME")
  private String last_Name;

  @Column(name ="DATE_OF_BIRTH")
  private LocalDate d_o_b;

  @Column(name ="GENDER")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @OneToMany(mappedBy = "person")
  Collection<WorklogDayEntry> worklogs = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "COMPANY_ID")
  private Company company;

  public Person() {
  }

  public Person(final String first_Name, final String last_Name, final LocalDate d_o_b, final Gender gender, final Long id) {
    this.first_Name = first_Name;
    this.last_Name = last_Name;
    this.d_o_b = d_o_b;
    this.gender = gender;
    this.id = id;
  }

  public Collection<WorklogDayEntry> getWorklogs() {
    return worklogs;
  }

  public void setWorklogs(Collection<WorklogDayEntry> worklogs) {
    this.worklogs = worklogs;
  }

  public String getFirst_Name() {
    return this.first_Name;
  }

  public void setFirst_Name(final String first_Name) {
    this.first_Name = first_Name;
  }

  public String getLast_Name() {
    return this.last_Name;
  }

  public void setLast_Name(final String last_Name) {
    this.last_Name = last_Name;
  }

  public LocalDate getD_o_b() {
    return this.d_o_b;
  }

  public void setD_o_b(final LocalDate d_o_b) {
    this.d_o_b = d_o_b;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setGender(final Gender gender) {
    this.gender = gender;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

/* public void addWorkLog(LocalDate day, List<WorklogTimeEntry> entry){
        if(worklogs == null){
            worklogs = new ArrayList<>();
        }

      WorklogDayEntry worklogDayEntry = new WorklogDayEntry();
      worklogDayEntry.setDay(day);
      worklogDayEntry.setEntries(entry);

      worklogs.add(worklogDayEntry);
  }*/


  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Person)) {
      return false;
    }
    final Person objCurr = (Person) o;
    return EqualsBuilder.reflectionEquals(this, objCurr);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
