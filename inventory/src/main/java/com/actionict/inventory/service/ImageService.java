package com.actionict.inventory.service;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Image;
import com.actionict.inventory.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ImageService {

    private final ImageRepository imageRepository;

    //Inserisci/carica immagine
    public void inserisci(String description, Integer viewerOrder, String pathImage, Integer filmId) {
        Image image = new Image();
        image.setDescription(description);
        image.setViewingOrder(viewerOrder);
        image.setPathImage(pathImage);
        Film film = new Film();  //Imp
        film.setId(filmId);//Imp
        image.setFilm(film);//Imp
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

    //Aggiorna/Modifica ordine immagini
    public void update(Integer id, Integer newViewingOrder) {
        Optional<Image> image = imageRepository.findById(id);
        image.get().setViewingOrder(newViewingOrder);
        imageRepository.save(image.get());
    }
}