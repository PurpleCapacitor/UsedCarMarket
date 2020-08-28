package ucm.models;

import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Characteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emissionClass;
    private boolean ac;
    private Drivetrain drivetrain;
    private String color;
    private LocalDate registeredUntil;
    @OneToMany(mappedBy = "characteristics")
    private Set<Ad> ads = new HashSet<>();

    public Characteristics() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public void setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public Drivetrain getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getRegisteredUntil() {
        return registeredUntil;
    }

    public void setRegisteredUntil(LocalDate registeredUntil) {
        this.registeredUntil = registeredUntil;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}
