package de.fh_kiel.person.repositories;

import de.fh_kiel.person.stubclass.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 16.12.16.
 */

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{
}
