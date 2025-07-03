package com.actionict.inventory.repository;

import com.actionict.inventory.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}