package com.actionict.inventory.service;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Image;
import com.actionict.inventory.repository.ImageRepository;
import com.actionict.inventory.request.ImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ImageService {

    private final ImageRepository imageRepository;

    //Inserisci/carica immagine
    public void inserisci(ImageRequest imageRequest) {
        String description=imageRequest.getDescription();
        Integer viewerOrder=imageRequest.getViewingOrder();
        String pathImage=imageRequest.getPathImage();
        Film filmByImageRequest=imageRequest.getFilm();   //chiave esterna
        Integer filmId=filmByImageRequest.getId();   //chiave esterna

        Image image = new Image();
        image.setDescription(description);
        image.setViewingOrder(viewerOrder);
        image.setPathImage(pathImage);
        Film film = new Film();  //chiave esterna
        film.setId(filmId);     //chiave esterna
        image.setFilm(film);     //chiave esterna

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

    //Modifica ordine immagini
    //Aggiorna
    public void update(Integer id, ImageRequest imageRequest) {
        Image imageByDB = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Immagine non trovata:"+id));
        Integer newViewingOrder=imageRequest.getViewingOrder();
        imageByDB.setViewingOrder(newViewingOrder);

        imageRepository.save(imageByDB);
    }
}