package com.actionict.inventory.controller;

import com.actionict.inventory.model.Image;
import com.actionict.inventory.request.ImageRequest;
import com.actionict.inventory.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    //carica immagine
    //Inserisci
    @PostMapping
    public void addImage(@RequestBody ImageRequest imageRequest) {
               imageService.inserisci(imageRequest);
    }

    //Recupera tutte le immagini sul db
    @GetMapping
    public List<Image> getAllImages() {return imageService.findAll();}

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Integer id){
        imageService.deleteById(id);
    }

    //Trova tutte le immagini ordinate tramite Descrizione secondo l'ordine ascendente o discendente
    //Endpoint   /images?direction=desc
    @GetMapping("/{direction}")
    public List<Image> getAllImagesSorted(@PathVariable  String direction)
    {
        return imageService.getAllImagesSortedByDescription(direction);
    }
}