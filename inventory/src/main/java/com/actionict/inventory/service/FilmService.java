package com.actionict.inventory.service;

import com.actionict.inventory.model.EnumRating;
import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Language;
import com.actionict.inventory.repository.FilmRepository;
import com.actionict.inventory.repository.LanguageRepository;
import com.actionict.inventory.request.FilmRequest;
import com.actionict.inventory.responce.FilmResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor

public class FilmService {

    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    //Trova Uno
    public FilmResponce findById(Integer id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film non trovato:"+id));

        String title= film.getTitle();
        String description= film.getDescription();
        Integer releaseYear= film.getReleaseYear();
        Language languageByFilm=film.getLanguage();   //chiave esterna
        Integer originalLanguageId= film.getOriginalLanguageId();
        Integer rentalDuration= film.getRentalDuration();
        BigDecimal rentalRate=film.getRentalRate();
        Integer lenght=film.getLength();
        BigDecimal replacementCost=film.getReplacementCost();
        EnumRating.Rating rating=film.getRating();   //IMP ENUM
        String specialFeaturesString = film.getSpecialFeatures();   //IMP SET
        String[] specialFeaturesArray = specialFeaturesString.split(",");    //IMP SET
        Set<String> specialFeatures = new HashSet<>(Arrays.asList(specialFeaturesArray));   //IMP SET

        FilmResponce filmResponce = new FilmResponce();
        filmResponce.setId(id);
        filmResponce.setTitle(title);
        filmResponce.setDescription(description);
        filmResponce.setReleaseYear(releaseYear);
        filmResponce.setLanguage(languageByFilm);    //chiave esterna
        filmResponce.setOriginalLanguageId(originalLanguageId);
        filmResponce.setRentalDuration(rentalDuration);
        filmResponce.setRentalRate(rentalRate);
        filmResponce.setLength(lenght);
        filmResponce.setReplacementCost(replacementCost);
        filmResponce.setRating(rating);     //IMP ENUM
        filmResponce.setSpecialFeatures(specialFeatures);  //IMP SET

        return filmResponce;
    }

    //Inserisci
    public void inserisci(FilmRequest filmRequest) {
        String title=filmRequest.getTitle();
        String description=filmRequest.getDescription();
        Integer releaseYear=filmRequest.getReleaseYear();
        Language languageByFilmRequest=filmRequest.getLanguage();   //chiave esterna
        Integer originalLanguageId=filmRequest.getOriginalLanguageId();
        Integer rentalDuration=filmRequest.getRentalDuration();
        BigDecimal rentalRate=filmRequest.getRentalRate();
        Integer length=filmRequest.getLength();
        BigDecimal replacementCost=filmRequest.getReplacementCost();
        EnumRating.Rating rating=filmRequest.getRating();   //IMP ENUM
        //Set<String> mySet = filmRequest.getSpecialFeatures();  //IMP SET  todo
        Set mySet = filmRequest.getSpecialFeatures();  //IMP SET    todo
        String setStringSpecialFeatures = mySet.toString();   //IMP SET

        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setReleaseYear(releaseYear);
        film.setLanguage(languageByFilmRequest);    //chiave esterna
        film.setOriginalLanguageId(originalLanguageId);
        film.setRentalDuration(rentalDuration);
        film.setRentalRate(rentalRate);
        film.setLength(length);
        film.setReplacementCost(replacementCost);
        film.setRating(rating);   //IMP ENUM
        film.setSpecialFeatures(setStringSpecialFeatures);   //IMP SET

        filmRepository.save(film);
    }

    //Aggiorna
    public void update(Integer id, FilmRequest filmRequest) {
        Film filmByDB = filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film non trovato:"+id));
        String newTitle=filmRequest.getTitle();
        String newDescription=filmRequest.getDescription();
        Integer newReleaseYear=filmRequest.getReleaseYear();
        Language languageByFilmRequest=filmRequest.getLanguage();   //chiave esterna
        Integer languageId=languageByFilmRequest.getId();    //chiave esterna
        Integer newRentalDuration=filmRequest.getRentalDuration();
        BigDecimal newRentalRate=filmRequest.getRentalRate();
        Integer newLength=filmRequest.getLength();
        BigDecimal newReplacementCost=filmRequest.getReplacementCost();
        EnumRating.Rating newRating=filmRequest.getRating();   //IMP Enum
        Set newSet=filmRequest.getSpecialFeatures();  //IMP SET  todo
        //Set<String> newMySet = filmRequest.getSpecialFeatures();  //IMP SET  todo
        String newStringSpecialFeatures = newSet.toString();   //IMP SET

        filmByDB.setTitle(newTitle);
        filmByDB.setDescription(newDescription);
        filmByDB.setReleaseYear(newReleaseYear);
        Language language=new Language();  //chiave esterna
        language.setId(languageId);    //chiave esterna
        filmByDB.setLanguage(language);    //chiave esterna
        filmByDB.setRentalDuration(newRentalDuration);
        filmByDB.setRentalRate(newRentalRate);
        filmByDB.setLength(newLength);
        filmByDB.setReplacementCost(newReplacementCost);
        filmByDB.setRating(newRating);  //IMP ENUM
        filmByDB.setSpecialFeatures(newStringSpecialFeatures);   //IMP SET

        filmRepository.save(filmByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        filmRepository.deleteById(id);
    }
}