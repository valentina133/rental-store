package com.actionict.inventory.repository;

import com.actionict.inventory.model.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepository extends JpaRepository<FilmActor, Integer> {
}