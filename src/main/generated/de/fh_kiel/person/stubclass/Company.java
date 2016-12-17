package de.fh_kiel.person.stubclass;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Generated("annotation processor")
@Entity
public class Company implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column(name = "COMPANY_ID")
  private long companyid;

  @Column(name = "COMPANY_NAME")
  private String companyName;

  @OneToMany(mappedBy = "company")
  @JsonBackReference
  private List<Person> companyEmpList = new ArrayList<>();

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
