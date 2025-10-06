package adaction.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "collects")
public class Collect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonProperty("city_id")
    private City city;

    @Column(nullable = false)
    @JsonProperty("glass_nb")
    private Integer glassNb;

    @Column(nullable = false)
    @JsonProperty("butt_nb")
    private Integer buttNb;

    @Column(nullable = false)
    @JsonProperty("plastic_nb")
    private Integer plasticNb;

    @Column(nullable = false)
    @JsonProperty("electronics_nb")
    private Integer electronicsNb;

    @Column(nullable = false)
    @JsonProperty("others_nb")
    private Integer othersNb;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;


    @Transient
    @JsonProperty("volunteer")
    private String volunteerName;

    public Collect() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getGlassNb() {
        return glassNb;
    }

    public void setGlassNb(Integer glassNb) {
        this.glassNb = glassNb;
    }

    public Integer getButtNb() {
        return buttNb;
    }

    public void setButtNb(Integer buttNb) {
        this.buttNb = buttNb;
    }

    public Integer getPlasticNb() {
        return plasticNb;
    }

    public void setPlasticNb(Integer plasticNb) {
        this.plasticNb = plasticNb;
    }

    public Integer getElectronicsNb() {
        return electronicsNb;
    }

    public void setElectronicsNb(Integer electronicsNb) {
        this.electronicsNb = electronicsNb;
    }

    public Integer getOthersNb() {
        return othersNb;
    }

    public void setOthersNb(Integer othersNb) {
        this.othersNb = othersNb;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    @Transient
    @JsonProperty("volunteer")
    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    @Transient
    @JsonProperty("city_id")
    private Long cityId;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}