package com.actionict.inventory.controller;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.request.ActorRequest;
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
    public void addActor(@RequestBody ActorRequest actorRequest) {
        actorService.inserisci(actorRequest);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateActor(@PathVariable Integer id, @RequestBody ActorRequest actorRequest){

        actorService.update(id, actorRequest);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Integer id){
        actorService.deleteById(id);
    }



}