package com.actionict.inventory.service;

import com.actionict.inventory.model.Film;
import com.actionict.inventory.model.Language;
import com.actionict.inventory.repository.FilmRepository;
import com.actionict.inventory.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class FilmService {

    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    //Trova Uno
    public Object findById(Integer id) {

        return filmRepository.findById(id);
    }

    //Inserisci
    public void inserisci(String title, String description, Integer ReleaseYear, Integer languageId, Integer originalLanguageId, Integer rentalDuration, BigDecimal rentalRate, Integer length, BigDecimal replacementCost, Film.Rating rating, Set specialFeatures) {
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setReleaseYear(ReleaseYear);
        //Language language = new Language();// ToDo   conferma
        Language language = film.getLanguage();// ToDo   conferma
        language.setId(languageId);  // ToDo   conferma
        film.setLanguage(language);   // ToDo conferma
        film.setOriginalLanguageId(originalLanguageId);
        film.setRentalDuration(rentalDuration);
        film.setRentalRate(rentalRate);
        film.setLength(length);
        film.setReplacementCost(replacementCost);
        film.setRating(rating);   //ENUM     ToDo SISTEMARE
        film.setSpecialFeatures(specialFeatures);   //SET    ToDo SISTEMARE
        filmRepository.save(film);
    }

    //Aggiorna
    public void update(Integer id, String newTitle, String newDescription, Integer newReleaseYear, Integer newLanguageId, Integer newOriginalLanguageId, Integer newRentalDuration, BigDecimal newRentalRate, Integer newLength, BigDecimal newReplacementCost, Film.Rating newRating, Set newSpecialFeatures) {
        Optional<Film> film = filmRepository.findById(id);
        film.get().setTitle(newTitle);
        film.get().setDescription(newDescription);
        film.get().setReleaseYear(newReleaseYear);
        //Language language = new Language();// ToDo   conferma
        Language languageOggetto = film.get().getLanguage();// ToDo   conferma
        languageOggetto.setId(newLanguageId);  // ToDo   conferma
        film.get().setLanguage(languageOggetto);   // ToDo conferma
        film.get().setOriginalLanguageId(newOriginalLanguageId);
        film.get().setRentalDuration(newRentalDuration);
        film.get().setRentalRate(newRentalRate);
        film.get().setLength(newLength);
        film.get().setReplacementCost(newReplacementCost);
        film.get().setRating(newRating);  //Enum TODO SISTEMARE
        film.get().setSpecialFeatures(newSpecialFeatures);   //SET TODO SISTEMARE
        filmRepository.save(film.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        filmRepository.deleteById(id);
    }
}