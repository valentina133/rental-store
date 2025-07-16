package com.actionict.inventory.controller;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<Actor> getAllActors() {return actorService.findAll();}

    //trova uno
    @GetMapping("/{id}")
    public Actor getActor(@PathVariable Integer id){
        return actorService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addActor(@RequestBody Actor actor) {
        String firstName=actor.getFirstName();
        String lastName=actor.getLastName();
        actorService.inserisci(firstName, lastName);
    }

    //aggiorna
    @PutMapping
    public void updateActor(@RequestBody Actor actor){
        Integer id=actor.getId();
        String firstName=actor.getFirstName();
        String lastName=actor.getLastName();
        actorService.update(id, firstName, lastName);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Integer id){
        actorService.deleteById(id);
    }



}