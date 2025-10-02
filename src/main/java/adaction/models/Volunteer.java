package adaction.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "volunteer")
    private List<Collect> collects;

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

    public Long getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public Integer getTotal_points(){
        return total_points;
    }

    public Integer getDonation_points(){
        return donation_points;
    }

    public Date getCreated_at(){
        return created_at;
    }

    public Date getUpdated_at(){
        return updated_at;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTotal_points(Integer total_points) {
        this.total_points = total_points;
    }

    public void setDonation_points(Integer donation_points) {
        this.donation_points = donation_points;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }


}


