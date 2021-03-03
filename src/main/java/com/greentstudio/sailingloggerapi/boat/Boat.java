package com.greentstudio.sailingloggerapi.boat;

import com.greentstudio.sailingloggerapi.port.Port;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Optional;

/**
 * Entity class for the Boats.
 *
 * @author Luis Martin Schick
 */
@Data
@Entity
@NoArgsConstructor
public
class Boat {

    @Id
    @GeneratedValue
    private Long id;
    private String strName;
    private String strColor;
    private Date dateBoatConstruction;

    @JsonIgnore //Stops serialization to avoid a recursive, bi-directional relationship
    @ManyToOne
    private Port port;


    public Boat(String strName, String strColor, Date dateBoatConstruction) {
        this.strName = strName;
        this.strColor = strColor;
        this.dateBoatConstruction = dateBoatConstruction;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }
}
