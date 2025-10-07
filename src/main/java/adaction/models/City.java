package adaction.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long cityid;

    @Column(nullable = false)
    private String name;

    public List<Collect> getCollects() {
        return collects;
    }

    public void setCollects(List<Collect> collects) {
        this.collects = collects;
    }

    @OneToMany(mappedBy = "city")
    private List<Collect> collects;


    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("id ASC")
    private List<Coordinate> coordinates_id;

    public Long getId() {
        return cityid;
    }

    public void setId(Long id) {
        this.cityid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Coordinate> getCoordinates_id() {
        return coordinates_id;
    }

    public void setCoordinates_id(List<Coordinate> coordinates_id) {
        this.coordinates_id = coordinates_id;
    }


}
