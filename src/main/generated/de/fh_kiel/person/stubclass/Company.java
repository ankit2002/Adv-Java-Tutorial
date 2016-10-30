package de.fh_kiel.person.stubclass;

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
  private long companyid;

  private String companyName;

  private List<Person> companyEmpList;

  public Company() {
  }

  public Company(final long companyid, final String companyName, final List<Person> companyEmpList) {
    this.companyid = companyid;
    this.companyName = companyName;
    this.companyEmpList = companyEmpList;
  }

  public long getCompanyid() {
    return this.companyid;
  }

  public void setCompanyid(final long companyid) {
    this.companyid = companyid;
  }

  public String getCompanyName() {
    return this.companyName;
  }

  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
  }

  public List<Person> getCompanyEmpList() {
    return this.companyEmpList;
  }

  public void setCompanyEmpList(final List<Person> companyEmpList) {
    this.companyEmpList = companyEmpList;
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
