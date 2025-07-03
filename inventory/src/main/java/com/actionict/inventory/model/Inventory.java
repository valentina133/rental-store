package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer id;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;

    /* Serve per lo step 3, per il collegamento al DB Business ma per adesso non lo metto
    @ManyToOne
    @JoinColumn(name="store_id", nullable=false)   //store_id è di tipo TINYINT sul DB
    private Store store;
     */
}
