package at.bbrz.buechereidb.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Magazin.class, name = "Magazin"),
        @JsonSubTypes.Type(value = Buch.class, name = "Buch"),
        @JsonSubTypes.Type(value = DVD.class, name = "DVD"),
        @JsonSubTypes.Type(value = Schallplatte.class, name = "Schallplatte")
})
@MappedSuperclass
@ToString
@Getter
@Setter
public abstract class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inventarNr;
    private String title;
    private String genre;
    private boolean ausgeliehen;
    private String zustand;


    @Transient // don’t persist JSON’s "type"
    private String type;

    @PrePersist
    @PreUpdate
    public void setTypeAutomatically() {
        this.type = this.getClass().getSimpleName(); // e.g. "Buch", "Magazin"
    }
}
