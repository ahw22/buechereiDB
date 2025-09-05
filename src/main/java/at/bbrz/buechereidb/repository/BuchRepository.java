package at.bbrz.buechereidb.repository;

import at.bbrz.buechereidb.model.Buch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuchRepository extends JpaRepository<Buch, Long> {
    Buch findByInventarNr(String inventarNr);
}
