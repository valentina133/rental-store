package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "address", length=50)
    private String address;

    @Column(name = "address2", length=50)
    private String address2;

    @Column(name = "district", length=20)
    private String district;

    @Column(name = "postal_code", length=10)
    private String postalCode;

    @Column(name = "phone", length=20)
    private String phone;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="city_id", referencedColumnName = "id", nullable=false)
    private City city;

    @OneToMany(mappedBy="address", cascade=CascadeType.All, orphanRemoval=true)
    private List<Customer> customer;
}
