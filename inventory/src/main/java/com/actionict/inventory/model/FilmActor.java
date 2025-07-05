//package com.actionict.customer.model;
package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@RequiredArgsConstructor

@Data
@Entity
@Table(name = "film_actor")     //Tabella con chiave composta
@IdClass(FilmActorChiaveComposta.class)
public class FilmActor {

    // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @Id  //chiave composta
    @ManyToOne
    @JoinColumn(name="actor_id", nullable=false)
    private Actor actor;

    @Id   //chiave composta
    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;
}
