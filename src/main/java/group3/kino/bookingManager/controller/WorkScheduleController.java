package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.WorkSchedule;
import group3.kino.bookingManager.service.IWorkScheduleService;
import group3.kino.bookingManager.service.WorkScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class WorkScheduleController {

    private WorkScheduleService workScheduleServices;

    public WorkScheduleController(WorkScheduleService workScheduleService){
        this.workScheduleServices = workScheduleService;
    }

    @GetMapping("/showSchedule")
    public ResponseEntity<Set<WorkSchedule>> getShowSchedule(){
        return new ResponseEntity<>(workScheduleServices.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createSchedule")
    public ResponseEntity<String> createSchedule(@RequestBody WorkSchedule workSchedule){
        workScheduleServices.save(workSchedule);

        if (workScheduleServices.save(workSchedule)!= null){
            return new ResponseEntity<>("Ny vagtplan oprettet", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Kunne ikke oprette ny vagtplan", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editSchedule")
    public ResponseEntity<WorkSchedule> editSchedule(@RequestBody  WorkSchedule newSchedule, @RequestParam Long id){
        Optional<WorkSchedule> workSchedule_ = workScheduleServices.findById(id);
        if (workSchedule_.isPresent()){
            newSchedule.setId(id);
            workScheduleServices.save(newSchedule);
            return new ResponseEntity<>(newSchedule, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(newSchedule, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteSchedule")
    public ResponseEntity<WorkSchedule> deleteSchedule(Long id){
        Optional<WorkSchedule> workSchedule_ = workScheduleServices.findById(id);
        if (workSchedule_.isPresent()){
            WorkSchedule workSchedule = workSchedule_.get();
            workScheduleServices.deleteById(id);
            return new ResponseEntity<>(workSchedule, HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
