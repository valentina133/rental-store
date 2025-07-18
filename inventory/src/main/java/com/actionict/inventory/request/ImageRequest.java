package com.actionict.inventory.request;

import com.actionict.inventory.model.Film;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
public class ImageRequest {

    private Integer id;
    private String description;
    private Integer viewingOrder;
    private String pathImage;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    private Film film;
}
