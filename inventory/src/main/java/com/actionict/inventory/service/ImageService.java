package com.actionict.inventory.service;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Image;
import com.actionict.inventory.repository.ImageRepository;
import com.actionict.inventory.request.ImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ImageService {

    private final ImageRepository imageRepository;

    //Inserisci/carica immagine
    public void inserisci(ImageRequest imageRequest) {
        String description=imageRequest.getDescription();
        String pathImage=imageRequest.getPathImage();
        Film filmByImageRequest=imageRequest.getFilm();   //chiave esterna

        Image image = new Image();
        image.setDescription(description);
        image.setPathImage(pathImage);
        image.setFilm(filmByImageRequest);     //chiave esterna

        imageRepository.save(image);
    }

    //Recupera tutte le immagini sul db
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    //Elimina una immagine
    public void deleteById(Integer id) {
        imageRepository.deleteById(id);
    }

    //Trova tutte le immagini ordinate tramite Descrizione
    public List<Image> getAllImagesSortedByDescription(String direction) {
        Sort sort=direction.equalsIgnoreCase("desc") ?
        Sort.by("description").descending() :
        Sort.by("description").ascending();

        return imageRepository.findAll(sort);
    }
}