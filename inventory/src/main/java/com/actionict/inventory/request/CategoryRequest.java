package com.actionict.inventory.request;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data

public class CategoryRequest {

    private Integer id;
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
