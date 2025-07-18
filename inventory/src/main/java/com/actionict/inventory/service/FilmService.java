package com.actionict.inventory.service;

import com.actionict.inventory.model.EnumRating;
import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Language;
import com.actionict.inventory.repository.FilmRepository;
import com.actionict.inventory.repository.LanguageRepository;
import com.actionict.inventory.request.FilmRequest;
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
    public Film findById(Integer id) {
        Optional<Film> byId = filmRepository.findById(id);
        Film film = byId.get();
        return film;
    }

    //Inserisci
    public void inserisci(FilmRequest filmRequest) {
        String title=filmRequest.getTitle();
        String description=filmRequest.getDescription();
        Integer releaseYear=filmRequest.getReleaseYear();
        Language languageByFilmRequest=filmRequest.getLanguage();   //IMP
        Integer languageId=languageByFilmRequest.getId();    //IMP
        Integer originalLanguageId=filmRequest.getOriginalLanguageId();
        Integer rentalDuration=filmRequest.getRentalDuration();
        BigDecimal rentalRate=filmRequest.getRentalRate();
        Integer length=filmRequest.getLength();
        BigDecimal replacementCost=filmRequest.getReplacementCost();
        EnumRating.Rating rating=filmRequest.getRating();   //IMP todo ENUM
        //Set specialFeatures=filmRequest.getSpecialFeatures();   //TODO SISTEMARE  SET


        String specialFeaturesString = "";   //TODO SISTEMARE  SET
        String[] specialFeaturesArray = specialFeaturesString.split(",");
        //List<String> specialFeatures = new ArrayList<>(Arrays.asList(specialFeaturesArray));
        Set<String> specialFeatures = new HashSet<>(Arrays.asList(specialFeaturesArray));

        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setReleaseYear(releaseYear);
        Language language=new Language();  //IMP
        language.setId(languageId);    //IMP
        film.setLanguage(language);    //IMP
        film.setOriginalLanguageId(originalLanguageId);
        film.setRentalDuration(rentalDuration);
        film.setRentalRate(rentalRate);
        film.setLength(length);
        film.setReplacementCost(replacementCost);
        film.setRating(rating);   //ENUM     ToDo SISTEMARE
        film.setSpecialFeatures(specialFeatures);   //SET    TODO SISTEMARE






        filmRepository.save(film);
    }

    //Aggiorna
    public void update(Integer id, FilmRequest filmRequest) {
        Optional<Film> filmOpt = filmRepository.findById(id);
        String newTitle=filmRequest.getTitle();
        String newDescription=filmRequest.getDescription();
        Integer newReleaseYear=filmRequest.getReleaseYear();
        Integer newRentalDuration=filmRequest.getRentalDuration();
        BigDecimal newRentalRate=filmRequest.getRentalRate();
        Integer newLength=filmRequest.getLength();
        BigDecimal newReplacementCost=filmRequest.getReplacementCost();
        EnumRating.Rating newRating=filmRequest.getRating();   //Enum TODO SISTEMARE
        Set newSpecialFeatures=filmRequest.getSpecialFeatures();  ///SET TODO SISTEMARE

        filmOpt.get().setTitle(newTitle);
        filmOpt.get().setDescription(newDescription);
        filmOpt.get().setReleaseYear(newReleaseYear);
        filmOpt.get().setRentalDuration(newRentalDuration);
        filmOpt.get().setRentalRate(newRentalRate);
        filmOpt.get().setLength(newLength);
        filmOpt.get().setReplacementCost(newReplacementCost);
        filmOpt.get().setRating(newRating);  //IMP TODO ENUM
        filmOpt.get().setSpecialFeatures(newSpecialFeatures);   //SET TODO SISTEMARE
        filmRepository.save(filmOpt.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        filmRepository.deleteById(id);
    }
}