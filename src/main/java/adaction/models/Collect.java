package adaction.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "collect")
    private List<City>  city_id;

    @Column(nullable = false)
    private Integer glass_nb;

    @Column(nullable = false)
    private Integer butt_nb;

    @Column(nullable = false)
    private Integer plastic_nb;

    @Column(nullable = false)
    private Integer electronics_nb;

    @Column(nullable = false)
    private Integer others_nb;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;
}