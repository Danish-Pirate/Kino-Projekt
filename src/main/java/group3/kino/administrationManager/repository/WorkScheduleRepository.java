package group3.kino.administrationManager.repository;

import group3.kino.administrationManager.model.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
}
