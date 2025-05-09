package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
//import javax.persistence.CascadeType;
//import org.hibernate.annotations.Cascade;
//import jakarta.persistence.CascadeType.All;

import lombok.RequiredArgsConstructor;
@AllArgsConstructor

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    @Column(name = "name", length=50)
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy="country", cascade=CascadeType.All, orphanRemoval=true)
    private List<City> cities;
}
