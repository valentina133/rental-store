package com.actionict.inventory.service;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.repository.ActorRepository;
import com.actionict.inventory.request.ActorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ActorService {

    private final ActorRepository actorRepository;

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    //Trova Uno
    public Actor findById(Integer id) {
        return actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Attore non trovato:"+id));
    }

    //Inserisci
    public void inserisci(ActorRequest actorRequest) {
        String firstName=actorRequest.getFirstName();
        String lastName=actorRequest.getLastName();
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actorRepository.save(actor);
    }

    //Aggiorna
    public void update(Integer id, ActorRequest actorRequest) {
        Actor actorByDB = actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Attore non trovato:"+id));
        String newFirstName=actorRequest.getFirstName();
        String newLastName=actorRequest.getLastName();
        actorByDB.setFirstName(newFirstName);
        actorByDB.setLastName(newLastName);
        actorRepository.save(actorByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        actorRepository.deleteById(id);
    }
}