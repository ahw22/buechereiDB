package at.bbrz.buechereidb.repository;

import at.bbrz.buechereidb.model.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DVD, Long> {
}
