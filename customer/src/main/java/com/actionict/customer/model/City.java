package com.actionict.customer.model;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
//@AllArgsConstructor

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    //@Column(name = "id")
    private Integer id;

    @Column(name = "name", length=50)
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    //@JoinColumn(name="country_id", referencedColumnName = "id", nullable=false)
    @JoinColumn(name="country_id", nullable=false)
    private Country country;

    @OneToMany(mappedBy="city", orphanRemoval=true)
    private List<Address> address;
}
