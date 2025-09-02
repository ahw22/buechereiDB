package at.bbrz.buechereidb.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class PrintMedium extends Medium{
    private String isbn;
    private int seiten;
}
