package com.actionict.inventory.service;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ActorService {

    private final ActorRepository actorRepository;

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    //Trova Uno
    public Object findById(Integer id) {

        return actorRepository.findById(id);
    }

    //Inserisci
    public void inserisci(String firstName, String lastName) {
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actorRepository.save(actor);
    }

    //Aggiorna
    public void update(Integer id, String newFirstName, String newLastName) {
        Optional<Actor> actor = actorRepository.findById(id);
        actor.get().setFirstName(newFirstName);
        actor.get().setLastName(newLastName);
        actorRepository.save(actor.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        actorRepository.deleteById(id);
    }
}