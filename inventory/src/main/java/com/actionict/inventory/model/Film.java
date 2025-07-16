package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable=false)
    private Integer id;

    @Column(name = "title", length=255, nullable=false)
    private String title;

    //campo di tipo TEXT sul DB
    @Column(name = "description")
    private String description;

    //campo di tipo YEAR sul DB
    @Column(name = "release_year")
    private Integer releaseYear;

    //campo di tipo TINYINT sul DB
    @ColumnDefault("NULL")
    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    //campo di tipo TINYINT sul DB
    @ColumnDefault("3")
    @Column(name = "rental_duration", nullable=false)
    private Integer rentalDuration;

    //campo di tipo DECIMAL sul DB    import java.math.BigDecimal;
    @ColumnDefault("4.99")
    @Column(name = "rental_rate", nullable=false)
    private BigDecimal rentalRate;

    @Column(name = "length", nullable=false)
    private Integer length;

    //campo di tipo DECIMAL sul DB
    @ColumnDefault("19.99")
    @Column(name = "replacement_cost", nullable=false)
    private BigDecimal replacementCost;

    //campo di tipo ENUM sul DB
    //@Enumerated(EnumType.ORDINAL) //value will be saved to the base as a number
    @ColumnDefault("G")
    @Enumerated(EnumType.STRING)    //value will be saved to the base as a string
    @Column(name="rating")
    public Rating rating;

    public enum Rating {
        G,
        PG,
        PG13,   // sul db è PG-13 ma qui dà errore allora metto PG13
        R,
        NC17       //sul db è NC-17 ma qui dà errore allora metto NC17
    }

    /*
    for( Giorno d : Giorno.values() ) {
System.err.println(d);
}
     */

    //campo di tipo SET sul DB
    //javax.persistence.ElementCollection
    @ElementCollection
    private Set<String> specialFeatures = new HashSet();


/*
    //campo di tipo SET sul DB    import java.util.HashSet;   import java.util.Set;
    @Column(name = "special_features")
    private Set<String> special_features; // Campo SET nel database, rappresentato come Set<String> in Java
    //private Set<String> special_features= new HashSet<>();
*/
    //@CreatedDate   //usato in Spring Data
    //@CreationTimestamp //this adds the default timestamp on save   //è presente solo in Hibernate e non Spring Data
    //@UpdateTimestamp   //Updates the last modified date when an entity is updated.
    //@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="language_id", nullable=false)
    private Language language;

}
