package com.actionict.inventory.model;

//bisagna fare i seguenti due import
import java.io.Serializable;
import java.util.Objects;

public class FilmActorChiaveComposta implements Serializable {

    private Long film;
    private Long actor;

    // Override di equals() e hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorChiaveComposta that = (FilmActorChiaveComposta) o;
        return Objects.equals(film, that.film) &&
                Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, actor);
    }

}
