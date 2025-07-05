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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable=false)
    private Integer id;

    @Column(name = "name", length=25, nullable=false)
    private String name;

    @UpdateTimestamp
    @Column(name = "last_update", nullable=false)
    private LocalDateTime lastUpdate;
}
