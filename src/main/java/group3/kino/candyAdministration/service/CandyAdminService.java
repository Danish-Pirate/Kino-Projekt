package group3.kino.candyAdministration.service;

import group3.kino.candyAdministration.model.Candy;
import group3.kino.candyAdministration.repository.CandyAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CandyAdminService implements ICandyAdminService{

    private CandyAdminRepo candyAdminRepo;
    @Autowired
    public CandyAdminService(CandyAdminRepo candyAdminRepo) {
        this.candyAdminRepo = candyAdminRepo;
    }


    @Override
    public Set<Candy> findAll() {
        Set<Candy> set = new HashSet<>(candyAdminRepo.findAll());
        return set;
    }

    @Override
    public Candy save(Candy object) {
        return candyAdminRepo.save(object);
    }

    @Override
    public void delete(Optional<Candy> object) {

    }

    @Override
    public void deleteById(Long Id) {
        candyAdminRepo.deleteById(Id);

    }

    @Override
    public Optional<Candy> findById(Long Id) {
        return Optional.empty();
    }
}
