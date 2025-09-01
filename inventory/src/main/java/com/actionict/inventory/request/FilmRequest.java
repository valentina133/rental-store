package com.actionict.inventory.request;

import com.actionict.inventory.model.EnumRating;
import com.actionict.inventory.model.Language;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class FilmRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    //campo di tipo TEXT sul DB
    private String description;

    //campo di tipo YEAR sul DB
    private Integer releaseYear;

    //campo di tipo TINYINT sul DB
    private Integer originalLanguageId;

    //campo di tipo TINYINT sul DB
    private Integer rentalDuration;

    //campo di tipo DECIMAL sul DB    import java.math.BigDecimal;
    private BigDecimal rentalRate;

    private Integer length;

    //campo di tipo DECIMAL sul DB
    private BigDecimal replacementCost;

    //campo di tipo ENUM sul DB
    public EnumRating.Rating rating;

    //campo di tipo SET sul DB
    private Set<String> specialFeatures = new HashSet();

    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    private Language language;
}
