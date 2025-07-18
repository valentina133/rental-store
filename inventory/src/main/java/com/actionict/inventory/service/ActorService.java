package com.actionict.inventory.service;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.repository.ActorRepository;
import com.actionict.inventory.request.ActorRequest;
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
    public Actor findById(Integer id) {
        Optional<Actor> byId = actorRepository.findById(id);
        Actor actor = byId.get();
        return actor;
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
        Optional<Actor> actorOpt = actorRepository.findById(id);
        String newFirstName=actorRequest.getFirstName();
        String newLastName=actorRequest.getLastName();
        actorOpt.get().setFirstName(newFirstName);
        actorOpt.get().setLastName(newLastName);
        actorRepository.save(actorOpt.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        actorRepository.deleteById(id);
    }
}