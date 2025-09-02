package at.bbrz.buechereidb.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class SpeicherMedium extends Medium {
    private int spielDauer;
    private int teile;
}
