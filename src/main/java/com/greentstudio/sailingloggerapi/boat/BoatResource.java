package com.greentstudio.sailingloggerapi.boat;

import com.greentstudio.sailingloggerapi.exceptions.BoatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class BoatResource {
    @Autowired
    private BoatDaoService service;

    /**
     * Retrieves a list of all boats from the DAO
     *
     * @return Returns all boats.
     */
    @GetMapping("/boats")
    public List<Boat> retrieveAllBoats() {
        return service.getAllBoats();
    }



    /**
     * Retrieves a certain boat matching the ID from the DAO.
     *
     * @param id The ID of the boat.
     * @return Returns the model of the boat matching the ID.
     * @throws BoatNotFoundException Thrown when no boat with given ID exists.
     */
    @GetMapping("/boats/{id}")
    public EntityModel<Boat> retrieveBoat(@PathVariable int id) throws BoatNotFoundException {
        Boat boat = service.findSpecificBoat(id);

        if (boat == null) //runtime exception
            throw new BoatNotFoundException("id:" + id);

        EntityModel<Boat> model = EntityModel.of(boat);
        Link link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllBoats()).withRel("all-boats");

        model.add(link);
        return model;
    }

    /**
     * Adds a new boat to the list and returns HTTP Status aswell as the resource location (ID).
     *
     * @param boat The boat to be added to the list.
     */
    @PostMapping("/boats")
    public ResponseEntity<Object> createBoat(@Valid @RequestBody Boat boat) {
        Boat addedBoat = service.addNewBoat(boat);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(addedBoat.getIntBoatID())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/boats/{id}")
    public void deleteBoat(@PathVariable int id) {
        Boat boat = service.deleteBoatByID(id);
        if (boat == null) {
            //runtime exception
            throw new BoatNotFoundException("id: " + id);
        }
    }
}
