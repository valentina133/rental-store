package com.actionict.inventory.controller;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.request.FilmRequest;
import com.actionict.inventory.responce.FilmResponce;
import com.actionict.inventory.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
        filmService.inserisci(filmRequest);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateFilm(@PathVariable Integer id, @RequestBody FilmRequest filmRequest){
        filmService.update(id, filmRequest);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Integer id){
        filmService.deleteById(id);
    }



}