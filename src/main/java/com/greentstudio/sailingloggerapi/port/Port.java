package com.greentstudio.sailingloggerapi.port;

import com.greentstudio.sailingloggerapi.boat.Boat;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Entity class for the Ports.
 *
 * @author Luis Martin Schick
 */
@Data
@Entity
@NoArgsConstructor
public class Port {
    @Id @GeneratedValue private Long id;
    private String strName;

    @JsonIgnore //Stops serialization to avoid a recursive, bi-directional relationship
    @OneToMany(mappedBy = "port", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boat> boats = new ArrayList<>();

    public Port(String strName){
        this.strName=strName;
    }

    public Optional<Long> getId(){
        return Optional.ofNullable(this.id);
    }
}
