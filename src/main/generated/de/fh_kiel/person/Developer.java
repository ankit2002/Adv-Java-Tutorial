package de.fh_kiel.person;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Set;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("annotation processor")
public class Developer extends Person {
  private float workExp;

  private double min_Salary;

  private Set<String> prog_lang;

  public Developer() {
  }

  public Developer(final float workExp, final double min_Salary, final Set<String> prog_lang) {
    this.workExp = workExp;
    this.min_Salary = min_Salary;
    this.prog_lang = prog_lang;
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

  public Set<String> getProg_lang() {
    return this.prog_lang;
  }

  public void setProg_lang(final Set<String> prog_lang) {
    this.prog_lang = prog_lang;
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
