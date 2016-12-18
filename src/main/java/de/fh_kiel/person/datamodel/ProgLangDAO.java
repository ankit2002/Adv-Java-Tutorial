package de.fh_kiel.person.datamodel;

import de.fh_kiel.person.stubclass.ProgLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amit on 16.12.16.
 */
public interface ProgLangDAO extends JpaRepository<ProgLanguage, String>{
}
