package com.actionict.inventory.service;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Image;
import com.actionict.inventory.repository.ImageRepository;
import com.actionict.inventory.request.ImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ImageService {

    private final ImageRepository imageRepository;

    //Inserisci/carica immagine
    public void inserisci(ImageRequest imageRequest) {
        String description=imageRequest.getDescription();
        Integer viewerOrder=imageRequest.getViewingOrder();
        String pathImage=imageRequest.getPathImage();
        Film filmByImageRequest=imageRequest.getFilm();   //IMP
        Integer filmId=filmByImageRequest.getId();   //IMP

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
    public void update(Integer id, ImageRequest imageRequest) {
        Optional<Image> imageOpt = imageRepository.findById(id);
        Integer newViewingOrder=imageRequest.getViewingOrder();
        imageOpt.get().setViewingOrder(newViewingOrder);
        imageRepository.save(imageOpt.get());
    }
}