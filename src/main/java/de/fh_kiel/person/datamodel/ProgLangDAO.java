package de.fh_kiel.person.repositories;

import de.fh_kiel.person.stubclass.ProgLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amit on 16.12.16.
 */
public interface ProgLangRepository extends JpaRepository<ProgLanguage, String>{
}
