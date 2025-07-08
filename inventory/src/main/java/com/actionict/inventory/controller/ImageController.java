package com.actionict.inventory.controller;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Image;
import com.actionict.inventory.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    //Inserisci/carica immagine
    //inserisci
    @PostMapping
    public void addImage(@RequestBody Image image) {
        String description=image.getDescription();
        Integer viewingOrder=image.getViewingOrder();
        String pathImage=image.getPathImage();
        Film film = image.getFilm();  //todo confermare
        Integer filmId=film.getId();  //todo confermare
        imageService.inserisci(description, viewingOrder, pathImage, filmId);
    }

    //Recupera tutte le immagini sul db
    @GetMapping
    public List<Image> getAllImages() {return imageService.findAll();}

    //Recupera tutte le immagini associate af uno specifico film
    //trova uno
    @GetMapping("/{id}")
    public Object getImages(@PathVariable Integer id){
        return imageService.findById(id);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Integer id){
        imageService.deleteById(id);
    }

    //Modifica ordine immagini
    //aggiorna
    @PutMapping
    public void updateImage(@RequestBody Image image){
        Integer id=image.getId();
        Integer viewingOrder=image.getViewingOrder();
        imageService.update(id, viewingOrder);
    }





}