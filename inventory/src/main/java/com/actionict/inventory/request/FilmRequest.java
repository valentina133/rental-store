package com.actionict.inventory.request;

import com.actionict.inventory.model.Language;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class FilmRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    //campo di tipo TEXT sul DB
    private String description;

    //campo di tipo YEAR sul DB
    private Integer releaseYear;

    //campo di tipo TINYINT sul DB
    private Integer originalLanguageId;

    //campo di tipo TINYINT sul DB
    private Integer rentalDuration;

    //campo di tipo DECIMAL sul DB    import java.math.BigDecimal;
    private BigDecimal rentalRate;

    private Integer length;

    //campo di tipo DECIMAL sul DB
    private BigDecimal replacementCost;

    //campo di tipo ENUM sul DB
    //@Enumerated(EnumType.ORDINAL) //value will be saved to the base as a number
    @Enumerated(EnumType.STRING)    //value will be saved to the base as a string
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
    private LocalDateTime lastUpdate;

    private Language language;
}
