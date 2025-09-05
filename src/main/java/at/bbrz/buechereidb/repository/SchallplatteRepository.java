package at.bbrz.buechereidb.repository;

import at.bbrz.buechereidb.model.Schallplatte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchallplatteRepository extends JpaRepository<Schallplatte, Long> {
    Schallplatte findByInventarNr(String inventarNr);
}
