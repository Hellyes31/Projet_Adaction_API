package adaction.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.sql.Date;



@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(nullable = false)
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    @Column(nullable = false)
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    @Column(nullable = false, unique = true)
    private String email;

    public String getEmail() {
        return email;
    }

    @Column(nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    @Column(nullable = false)
    private String location;

    public String getLocation() {
        return location;
    }

    @Column(nullable = false)
    private Integer total_points;

    public Integer getTotal_points(){
        return total_points;
    }

    @Column(nullable = false)
    private Integer donation_points;

    public Integer getDonation_points(){
        return donation_points;
    }

    @Column(nullable = false)
    private Date created_at;

    public Date getCreated_at(){
        return created_at;
    }

    @Column(nullable = true)
    private Date updated_at;

    public Date getUpdated_at(){
        return updated_at;
    }

}


