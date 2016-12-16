package de.fh_kiel.person.stubclass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by amit on 16.12.16.
 */
@Entity
public class ProgLanguage {
    @Id
    @Column(name = "PROG_LANG_NAME")
    private String name;

    @ManyToMany
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
