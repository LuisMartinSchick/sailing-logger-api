package com.greentstudio.sailingloggerapi.boat;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO replace with proper Database
@Component
public class BoatDaoService {
    //create an instance of ArrayList
    private static final List<Boat> boats = new ArrayList<>();
    public static int boatCount = 5;

    //static block
    static {
        //Add boats to the List
        boats.add(new Boat(1, "Alpha Boat", new Date()));
        boats.add(new Boat(2, "Bravo Boat", new Date()));
        boats.add(new Boat(3, "Gamma Boat", new Date()));
        boats.add(new Boat(4, "Delta Boat", new Date()));
        boats.add(new Boat(5, "Epsilon Boat", new Date()));
    }

    /**
     * Method to get all boats from the list.
     *
     * @return Returns all the boats from the list.
     */
    public List<Boat> getAllBoats() {
        return boats;
    }

    /**
     * Method to add a new boat to the list.
     * Increments the boatCount by 1.
     *
     * @param boat The boat to be added to the list.
     * @return Returns the added boat.
     */
    public Boat addNewBoat(Boat boat) {
        if (boat.getIntBoatID() == null) {
            boat.setIntBoatID(++boatCount);
        }
        boats.add(boat);
        return boat;
    }

    /**
     * This method returns a specific boat, matching the given id.
     *
     * @param id The ID of the boat thaat will be returned
     * @return If a boat matching the ID is found, it will return that boat - else it will return null.
     */
    public Boat findSpecificBoat(int id) {
        for (Boat boat : boats) {
            if (boat.getIntBoatID() == id)
                return boat;
        }
        return null;
    }
}
