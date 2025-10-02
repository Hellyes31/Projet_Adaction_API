package adaction.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

}
