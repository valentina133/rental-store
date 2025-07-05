//package com.actionict.customer.model;
package com.actionict.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@RequiredArgsConstructor

@Data
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable=false)
    private Integer id;

    @Column(name = "first_name", length=45, nullable=false)
    private String first_name;

    @Column(name = "last_name", length=45, nullable=false)
    private String last_name;

    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;
}
