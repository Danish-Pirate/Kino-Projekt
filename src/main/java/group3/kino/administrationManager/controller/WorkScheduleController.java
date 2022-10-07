package group3.kino.administrationManager.controller;

import group3.kino.administrationManager.model.WorkSchedule;
import group3.kino.administrationManager.service.WorkScheduleService;
import group3.kino.util.TokenAuthenticator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class WorkScheduleController {

    private WorkScheduleService workScheduleServices;

    public WorkScheduleController(WorkScheduleService workScheduleService){
        this.workScheduleServices = workScheduleService;
    }

    @GetMapping("/showSchedule")
    public ResponseEntity<Set<WorkSchedule>> getShowSchedule(@RequestHeader("token") int key){
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(workScheduleServices.findAll(), HttpStatus.OK);
    }


    @PostMapping("/createSchedule")
    public ResponseEntity<String> createSchedule(@RequestBody WorkSchedule workSchedule, @RequestHeader("token") int key){
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        workScheduleServices.save(workSchedule);

        if (workScheduleServices.save(workSchedule)!= null){
            return new ResponseEntity<>("Ny vagt oprettet", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Kunne ikke oprette ny vagt", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editSchedule")
    public ResponseEntity<WorkSchedule> editSchedule(
            @RequestBody  WorkSchedule newSchedule,
            @RequestParam Long id,
            @RequestHeader("token") int key){
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

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
    public ResponseEntity<WorkSchedule> deleteSchedule(@RequestParam Long id, @RequestHeader("token") int key){
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

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
