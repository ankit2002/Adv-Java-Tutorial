package de.fh_kiel.person.stubclass;

import de.fh_kiel.person.worklog.WorklogDayEntry;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Generated("annotation processor")
public class Person implements Serializable {
  private String first_Name;

  private String last_Name;

  private LocalDate d_o_b;

  private Gender gender;

  private Long id;

  Collection<WorklogDayEntry> worklogs;

  public Person() {
  }

  public Person(final String first_Name, final String last_Name, final LocalDate d_o_b, final Gender gender, final Long id) {
    this.first_Name = first_Name;
    this.last_Name = last_Name;
    this.d_o_b = d_o_b;
    this.gender = gender;
    this.id = id;
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
}
