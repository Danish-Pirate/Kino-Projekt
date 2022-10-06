package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.WorkSchedule;
import group3.kino.bookingManager.repository.WorkScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WorkScheduleService implements IWorkScheduleService {

    private WorkScheduleRepository  workScheduleRepository;

    public WorkScheduleService(WorkScheduleRepository workScheduleRepository) {
        this.workScheduleRepository = workScheduleRepository;
    }

    @Override
    public Set<WorkSchedule> findAll() {
        Set<WorkSchedule> set = new HashSet<>();
        workScheduleRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public WorkSchedule save(WorkSchedule schedule) {
        return workScheduleRepository.save(schedule);
    }

    @Override
    public void delete(WorkSchedule schedule) {
        workScheduleRepository.delete(schedule);
    }

    @Override
    public void deleteById(Long id) {
        workScheduleRepository.deleteById(id);
    }

    @Override
    public Optional<WorkSchedule> findById(Long id) {
        return workScheduleRepository.findById(id);
    }
}
