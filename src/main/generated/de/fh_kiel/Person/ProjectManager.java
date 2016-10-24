package de.fh_kiel.Person;

import de.fh_kiel.Person;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("annotation processor")
public class ProjectManager extends Person.Developer {
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
