package de.fh_kiel.person.stubclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Generated("annotation processor")
@Entity
public class ProjectManager extends Developer {
  @Column(name = "PROJ_MANAGER_EXP")
  public float pmExp;

  public ProjectManager() {
  }

  public ProjectManager(final float pmExp) {
    this.pmExp = pmExp;
  }

  public float getPmExp() {
    return this.pmExp;
  }

  public void setPmExp(final float pmExp) {
    this.pmExp = pmExp;
  }

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof ProjectManager)) {
      return false;
    }
    final ProjectManager objCurr = (ProjectManager) o;
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
