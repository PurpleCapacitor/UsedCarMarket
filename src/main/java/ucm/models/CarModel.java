package ucm.models;

import org.apache.tomcat.jni.Local;
import ucm.inputs.CarModelInput;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String year;
    private int kilometers;
    private int displacement;
    private int hp;
    @OneToMany(mappedBy = "carModel")
    private Set<Ad> ads = new HashSet<>();

    public CarModel() {
    }

    public CarModel(CarModelInput input) {
        this.make = input.getMake();
        this.model = input.getModel();
        this.year = input.getYear();
        this.kilometers = input.getKilometers();
        this.displacement = input.getDisplacement();
        this.hp = input.getHp();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}
