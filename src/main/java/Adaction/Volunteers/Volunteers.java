package Adaction.Volunteers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "volunteers")
public class Volunteers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer total_points;

    @Column(nullable = false)
    private Integer donation_points;

    @Column(nullable = false)
    private Date created_at;

    @Column(nullable = true)
    private Date updated_at;
}
