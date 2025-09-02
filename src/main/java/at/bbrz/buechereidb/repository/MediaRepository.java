package at.bbrz.buechereidb.repository;

import at.bbrz.buechereidb.model.Medium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Medium, Long> {
}
