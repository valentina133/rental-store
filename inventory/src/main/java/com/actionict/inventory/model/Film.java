//package com.actionict.customer.model;
package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Data
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer id;

    @Column(name = "title", length=255)
    private String title;

    //campo di tipo TEXT sul DB
    @Column(name = "description")
    private String description;

    //campo di tipo YEAR sul DB
    @Column(name = "release_year")
    private Integer release_year;

    //campo di tipo TINYINT sul DB
    @Column(name = "original_language_id")
    private Integer original_language_id;

    //campo di tipo TINYINT sul DB
    @Column(name = "rental_duration")
    private Integer rental_duration;

    //campo di tipo DECIMAL sul DB    import java.math.BigDecimal;
    @Column(name = "rental_rate")
    private BigDecimal rental_rate;

    @Column(name = "length")
    private Integer length;

    //campo di tipo DECIMAL sul DB    import java.math.BigDecimal;
    @Column(name = "replacement_cost")
    private BigDecimal replacement_cost;

    //campo di tipo ENUM sul DB
    //@Enumerated(EnumType.ORDINAL) //value will be saved to the base as a number
    @Enumerated(EnumType.STRING)    //value will be saved to the base as a string
    @Column(name="rating")
    public Rating rating;

    public enum Rating {
        G,
        PG,
        PG-13,
        R,
        NC-17
    }

    /*
    for( Giorno d : Giorno.values() ) {
System.err.println(d);
}
     */

    //campo di tipo SET sul DB
    //javax.persistence.ElementCollection
    @ElementCollection
    private Set<String> special_features = new HashSet();


/*
    //campo di tipo SET sul DB    import java.util.HashSet;   import java.util.Set;
    @Column(name = "special_features")
    private Set<String> special_features; // Campo SET nel database, rappresentato come Set<String> in Java
    //private Set<String> special_features= new HashSet<>();
*/

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="language_id", nullable=false)
    private Language language;

}
