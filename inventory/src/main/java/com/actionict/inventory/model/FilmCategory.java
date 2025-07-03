package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Data
@Entity
@Table(name = "film_category")
public class FilmCategory {

    // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
}
