package com.greentstudio.sailingloggerapi.boat;

import com.greentstudio.sailingloggerapi.exceptions.BoatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BoatResource {
    @Autowired
    private BoatDaoService service;

    /**
     * Retrieves a list of all boats from the DAO
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
     * @throws BoatNotFoundException No boat with this ID exists.
     * @return Returns the boat matching the ID.
     */
    @GetMapping("/boats/{id}")
    public Boat retrieveBoat(@PathVariable int id) throws BoatNotFoundException {
        Boat boat = service.findSpecificBoat(id);
        if(boat==null) //runtime exception
            throw new BoatNotFoundException("id:"+id);
        return boat;
    }

    /**
     * Adds a new boat to the list and returns HTTP Status aswell as the resource location (ID).
     *
     * @param boat The boat to be added to the list.
     */
    @PostMapping("/boats")
    public ResponseEntity<Object> createBoat(@RequestBody Boat boat) {
        Boat addedBoat = service.addNewBoat(boat);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(addedBoat.getIntBoatID())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
