package de.fh_kiel.person;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("annotation processor")
public class Company {
  private long cid;

  private String cName;

  private List<Person> cemp;

  public Company() {
  }

  public Company(final long cid, final String cName, final List<Person> cemp) {
    this.cid = cid;
    this.cName = cName;
    this.cemp = cemp;
  }

  public long getCid() {
    return this.cid;
  }

  public void setCid(final long cid) {
    this.cid = cid;
  }

  public String getCName() {
    return this.cName;
  }

  public void setCName(final String cName) {
    this.cName = cName;
  }

  public List<Person> getCemp() {
    return this.cemp;
  }

  public void setCemp(final List<Person> cemp) {
    this.cemp = cemp;
  }

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Company)) {
      return false;
    }
    final Company objCurr = (Company) o;
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
