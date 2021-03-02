package com.greentstudio.sailingloggerapi.boat;

import java.util.Date;

public class Boat {


    private Integer intBoatID;
    private String strBoatName;
    final private Date dateBoatConstruction;

    /**
     * The constructor for the data type Boat.
     * @param intBoatID Integer. The ID of the boat.
     * @param strBoatName String. The name of the boat.
     * @param dateBoatConstruction Date. The date the boat was constructed.
     */
    public Boat(Integer intBoatID, String strBoatName, Date dateBoatConstruction) {
        super();
        this.intBoatID = intBoatID;
        this.strBoatName = strBoatName;
        this.dateBoatConstruction = dateBoatConstruction;

    }

    public Integer getIntBoatID() {
        return intBoatID;
    }

    public void setIntBoatID(Integer intBoatID) {
        this.intBoatID = intBoatID;
    }

    public String getStrBoatName() {
        return strBoatName;
    }

    public void setStrBoatName(String strBoatName) {
        this.strBoatName = strBoatName;
    }

    public Date getDateBoatConstruction() {
        return dateBoatConstruction;
    }

    @Override
    public String toString(){
        return String.format("Boat[intBoatID=%s, strBoatName=%s, dateBoatConstruction=%s]", intBoatID, strBoatName, dateBoatConstruction);
    }
}
