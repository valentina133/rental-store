package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "name", lenght=50)
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName = "id", nullable=false)
    private Country country;

    @OneToMany(mappedBy="city", cascade=CascadeType.All, orphanRemoval=true)
    private List<Address> address;
}
