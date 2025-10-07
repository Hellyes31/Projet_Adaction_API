package adaction.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "coordinates")
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;

}