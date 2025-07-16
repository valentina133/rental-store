package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "film_category")
@IdClass(FilmCategoryChiaveComposta.class)
public class FilmCategory {

    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @Id   //chiave composta
    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;

    @Id    //chiave composta
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
}
