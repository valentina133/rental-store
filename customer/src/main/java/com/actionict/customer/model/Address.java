package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "address", lenght=50)
    private String address;

    @Column(name = "address2", lenght=50)
    private String address2;

    @Column(name = "district", lenght=20)
    private String district;

    @Column(name = "postal_code", lenght=10)
    private String postalCode;

    @Column(name = "phone", lenght=20)
    private String phone;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="city_id", referencedColumnName = "id", nullable=false)
    private City city;

    @OneToMany(mappedBy="address", cascade=CascadeType.All, orphanRemoval=true)
    private List<Customer> customer;
}
