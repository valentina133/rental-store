package com.actionict.inventory.repository;

import com.actionict.inventory.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}