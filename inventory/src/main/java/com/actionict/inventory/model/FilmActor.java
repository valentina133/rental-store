package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "film_actor")     //Tabella con chiave composta
@IdClass(FilmActorChiaveComposta.class)
public class FilmActor {

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
