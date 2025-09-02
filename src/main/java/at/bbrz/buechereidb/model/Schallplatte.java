package at.bbrz.buechereidb.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schallplatte extends SpeicherMedium{
    private int anzahlLieder;
}
