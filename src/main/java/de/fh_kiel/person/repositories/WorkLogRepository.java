package de.fh_kiel.person.repositories;

import de.fh_kiel.person.worklog.WorklogDayEntry;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amit on 15.12.16.
 */

public interface WorkLogRepository extends JpaRepository<WorklogDayEntry, Long> {

}
