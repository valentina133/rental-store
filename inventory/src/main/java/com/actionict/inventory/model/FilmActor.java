//package com.actionict.customer.model;
package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Data
@Entity
@Table(name = "film_actor")
public class FilmActor {

    // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="actor_id", nullable=false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;
}
