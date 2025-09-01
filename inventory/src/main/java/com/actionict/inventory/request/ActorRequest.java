package com.actionict.inventory.request;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
public class ActorRequest {

    private Integer id;
    private String firstName;
    private String lastName;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
