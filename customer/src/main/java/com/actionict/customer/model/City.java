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
    @JoinColumn(name="country_id", nullable=false) //dà errore: il valore nullo nella colonna "country_id" della relazione "city" viola il vincolo non nullo
    //@JoinColumn(name="country_id") //dà lo stesso errore sopra
    private Country country;

    /* Lo tolgo perché il risultato della get è composto da una serie di oggetti annidati, oltre la strutture definita nel model
    @OneToMany(mappedBy="city", orphanRemoval=true)
    private List<Address> address;
     */
}
