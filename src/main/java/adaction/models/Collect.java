package adaction.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.sql.Date;

@Entity
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String city;

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

    @Column(nullable = false)
    private Integer volunteer_id;

}