package at.bbrz.buechereidb.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buch extends PrintMedium {
    private String klappenText;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;
}
