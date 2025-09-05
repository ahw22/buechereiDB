package at.bbrz.buechereidb.repository;

import at.bbrz.buechereidb.model.Magazin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazinRepository extends JpaRepository<Magazin, Long> {
    Magazin findByInventarNr(String inventarNr);
}
