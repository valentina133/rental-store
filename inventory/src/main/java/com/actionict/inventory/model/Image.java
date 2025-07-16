package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable=false)
    private Integer id;

    @Column(name = "description", length=255, nullable=false)
    private String description;

    @Column(name = "viewing_order", nullable=false)
    private Integer viewingOrder;

    @Column(name = "pathImage", length=255, nullable=false)
    private String pathImage;

    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;
}
