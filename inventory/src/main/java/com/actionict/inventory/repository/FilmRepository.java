package com.actionict.inventory.repository;

import com.actionict.inventory.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}