package de.fh_kiel.Person;

import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("annotation processor")
public class Person implements Serializable {
  private String first_Name;

  private String last_Name;

  private LocalDate d_o_b;

  private String gender;

  private long id;

  public Person() {
  }

  public Person(final String first_Name, final String last_Name, final LocalDate d_o_b, final String gender, final long id) {
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
  }

  public String getLast_Name() {
    return this.last_Name;
  }

  public void setLast_Name(final String last_Name) {
  }

  public LocalDate getD_o_b() {
    return this.d_o_b;
  }

  public void setD_o_b(final LocalDate d_o_b) {
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(final String gender) {
  }

  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
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
