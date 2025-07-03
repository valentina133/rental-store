//package com.actionict.customer.model;
package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Data
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer id;

    @Column(name = "first_name", length=45)
    private String name;

    @Column(name = "last_name", length=45)
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
