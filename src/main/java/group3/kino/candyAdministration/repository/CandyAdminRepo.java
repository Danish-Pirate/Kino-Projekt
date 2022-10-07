package group3.kino.candyAdministration.repository;

import group3.kino.candyAdministration.model.Candy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandyAdminRepo extends JpaRepository<Candy,Long> {
}
