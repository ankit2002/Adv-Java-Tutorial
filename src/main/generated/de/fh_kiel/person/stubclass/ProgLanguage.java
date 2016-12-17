package de.fh_kiel.person.stubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by amit on 16.12.16.
 */
@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")*/
public class ProgLanguage implements Serializable {
    @Id
    @Column(name = "PROG_LANG_NAME")
    private String name;

    @ManyToMany
    //@JsonManagedReference
    private Collection<Developer> developerlist = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Developer> getDeveloperlist() {
        return developerlist;
    }

    public void setDeveloperlist(Collection<Developer> developerlist) {
        this.developerlist = developerlist;
    }
}
