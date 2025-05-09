package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    //store_id è chiave esterna verso la tabella store che non riguarda il db Customer Data
    //lo metto come campo ma non definisco la relazione con l'altra tabella
    @Column(name = "store_id")
    private byte storeId; // TINYINT

    @Column(name = "first_name", length=45)
    private String firstName;

    @Column(name = "last_name", length=45)
    private String lastName;

    @Column(name = "email", length=50)
    private String email;

    @Column(name = "active")
    private Boolean active;

    //colonna DATETIME ?
    @Column(name = "create_date")
    private LocalDateTime createDate;   //DATETIME
    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "create_date")
    //private Timestamp createDate;  //DATETIME

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="address_id", referencedColumnName = "id", nullable=false)
    private Address address;
}
