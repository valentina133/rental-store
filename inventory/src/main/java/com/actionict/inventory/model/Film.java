package com.actionict.inventory.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    //campo di tipo TINYINT sul DB
    @Column(name = "rental_duration")
    private Integer rentalDuration;

    //campo di tipo DECIMAL sul DB    import java.math.BigDecimal;
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length", nullable=false)
    private Integer length;

    //campo di tipo DECIMAL sul DB
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    //campo di tipo ENUM sul DB
    //@Enumerated(EnumType.ORDINAL) //value will be saved to the base as a number
    @Enumerated(EnumType.STRING)    //value will be saved to the base as a string
    @Column(name="rating")
    public EnumRating.Rating rating;

    //campo di tipo SET lo si dichiara come stringa su db e poi si converte in HashSet nel codice
    String specialFeatures="Trailers, Commentaries, Deleted Scenes, Behind the Scenes";


    //javax.persistence.ElementCollection
    /*@ElementCollection
    private Set<String> specialFeatures = new HashSet();
    */

    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="language_id", nullable=false)
    private Language language;

    //Per settere i valori di default
    @PrePersist
    public void prePersist() {
        if (rentalDuration == null) {
            rentalDuration = 3;
        }
        if (rentalRate == null) {
            rentalRate = BigDecimal.valueOf(4.99);
        }
        if (replacementCost == null) {
            replacementCost = BigDecimal.valueOf(19.99);
        }
        if (rating == null) {
            rating = rating.G;
        }
    }
}
