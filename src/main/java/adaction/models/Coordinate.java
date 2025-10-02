package adaction.models;

import jakarta.persistence.*;

@Entity
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    private City city;

}