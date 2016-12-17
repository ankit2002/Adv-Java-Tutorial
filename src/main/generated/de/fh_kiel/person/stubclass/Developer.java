package de.fh_kiel.person.stubclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

//@Generated("annotation processor")
@Entity
public class Developer extends Person {

  @Column(name = "DEV_WORK_EXP")
  private float workExp;

  @Column(name = "DEV_MIN_SALARY")
  private double min_Salary;

  @ManyToMany(mappedBy = "developerlist")
  //@JsonBackReference
  @JsonIgnore
  private Collection<ProgLanguage> proglanglist = new ArrayList<>();

  public Developer() {
  }

  public Developer(final float workExp, final double min_Salary, Collection<ProgLanguage> proglanglist) {
    this.workExp = workExp;
    this.min_Salary = min_Salary;
    this.proglanglist = proglanglist;
  }

  public float getWorkExp() {
    return this.workExp;
  }

  public void setWorkExp(final float workExp) {
    this.workExp = workExp;
  }

  public double getMin_Salary() {
    return this.min_Salary;
  }

  public void setMin_Salary(final double min_Salary) {
    this.min_Salary = min_Salary;
  }

  public Collection<ProgLanguage> getProglanglist() {
    return proglanglist;
  }

  public void setProglanglist(Collection<ProgLanguage> proglanglist) {
    this.proglanglist = proglanglist;
  }

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Developer)) {
      return false;
    }
    final Developer objCurr = (Developer) o;
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
