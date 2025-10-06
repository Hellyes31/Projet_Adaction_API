package adaction.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Collect collect;

    @OneToMany(mappedBy = "city")
    private List<Coordinate>  coordinates_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }

    public List<Coordinate> getCoordinates_id() {
        return coordinates_id;
    }

    public void setCoordinates_id(List<Coordinate> coordinates_id) {
        this.coordinates_id = coordinates_id;
    }


}
