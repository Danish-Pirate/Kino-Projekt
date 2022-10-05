package group3.kino.candyAdministration.controller;


import group3.kino.candyAdministration.model.Candy;
import group3.kino.candyAdministration.service.CandyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class CandyAdminController {

    private CandyAdminService candyAdminService;

    @Autowired
    public CandyAdminController(CandyAdminService candyAdminService){
        this.candyAdminService = candyAdminService;
    }

    @PostMapping("/addCandy")
    public ResponseEntity<Candy> addCandy(Candy candy){
        candyAdminService.save(candy);
        return new ResponseEntity<>(candy, HttpStatus.OK);
    }

    @GetMapping("/getAllCandy")
    public ResponseEntity<Set<Candy>> getAllCandy(){
        return new ResponseEntity<>(candyAdminService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/editCandy")
    public ResponseEntity<Candy> editCandy(@RequestBody Candy newCandy){
        Optional<Candy> oldCandy = candyAdminService.findById(newCandy.getCandyId());
        if (oldCandy.isPresent()){
            candyAdminService.save(newCandy);

            return new ResponseEntity<>(newCandy, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(newCandy, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteCandy")
    public ResponseEntity<Candy> deleteCandy(Long id){
        Optional<Candy> candy = candyAdminService.findById(id);
        if (candy.isPresent()){
            Candy candy_ = candy.get();
            candyAdminService.delete(candy);
            return new ResponseEntity<>(candy_,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCandy/{candyId}")
    public void deleteCandyByID(@PathVariable("candyId") Long candyId){
        candyAdminService.deleteById(candyId);
    }


}
