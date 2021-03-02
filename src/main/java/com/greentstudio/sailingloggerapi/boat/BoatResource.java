package com.greentstudio.sailingloggerapi.boat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
     * @param id The ID of the boat.
     * @return Returns the boat matching the ID or null.
     */
    @GetMapping("/boats/{id}")
    public Boat retrieveBoat(@PathVariable int id){
        return service.findSpecificBoat(id);
    }
}
