package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
}
