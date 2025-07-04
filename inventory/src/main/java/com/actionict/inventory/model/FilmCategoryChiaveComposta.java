package com.actionict.inventory.model;

//bisagna fare i seguenti due import
import java.io.Serializable;
import java.util.Objects;

public class FilmCategoryChiaveComposta implements Serializable {

    private Long film;
    private Long category;

    // Override di equals() e hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryChiaveComposta that = (FilmCategoryChiaveComposta) o;
        return Objects.equals(film, that.film) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, category);
    }

}
