package de.fh_kiel.person.datamodel;

import de.fh_kiel.person.stubclass.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 16.12.16.
 */
@Repository
public interface CompanyDAO extends JpaRepository<Company, Long>{
}
