package de.fh_kiel.person.repositories;

import de.fh_kiel.person.worklog.WorklogDayEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 15.12.16.
 */
@Repository
public interface WorkLogRepository extends JpaRepository<WorklogDayEntry, Long> {

}
