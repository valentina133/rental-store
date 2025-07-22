package com.actionict.inventory.controller;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Language;
import com.actionict.inventory.request.FilmRequest;
import com.actionict.inventory.responce.FilmResponce;
import com.actionict.inventory.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public List<Film> getAllFilms() {return filmService.findAll();}

    //trova uno
    @GetMapping("/{id}")
    public FilmResponce getFilm(@PathVariable Integer id){
        return filmService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addFilm(@RequestBody FilmRequest filmRequest) {
        /*
        String title=film.getTitle();
        String description=film.getDescription();
        Integer releaseYear=film.getReleaseYear();
        Language language=film.getLanguage();  //IMP.
        Integer languageId=language.getId();   //IMP.
        Integer originalLanguageId=film.getOriginalLanguageId();
        Integer rentalDuration=film.getRentalDuration();
        BigDecimal rentalRate=film.getRentalRate();
        Integer length=film.getLength();
        BigDecimal replacementCost=film.getReplacementCost();
        Film.Rating rating=film.getRating();   //todo sistemare
        Set specialFeatures=film.getSpecialFeatures(); //todo sistemare  */
        filmService.inserisci(filmRequest);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateFilm(@PathVariable Integer id, @RequestBody FilmRequest filmRequest){
        //Film.Rating rating=film.getRating();   //todo sistemare
        //Set specialFeatures=film.getSpecialFeatures();   //todo sistemare
        filmService.update(id, filmRequest);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Integer id){
        filmService.deleteById(id);
    }



}