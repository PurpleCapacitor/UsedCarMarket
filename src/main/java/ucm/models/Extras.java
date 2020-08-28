package ucm.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Extras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean cruiseControl;
    private boolean electricalMirrors;
    private boolean electricalSeats;
    private boolean electricalWindows;
    private boolean multifunctionalSteeringWheel;
    private boolean bluetooth;
    private boolean ledHeadlights;
    private boolean heatedSeats;
    @OneToMany(mappedBy = "extras")
    private Set<Ad> ads = new HashSet<>();

    public Extras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public boolean isElectricalMirrors() {
        return electricalMirrors;
    }

    public void setElectricalMirrors(boolean electricalMirrors) {
        this.electricalMirrors = electricalMirrors;
    }

    public boolean isElectricalSeats() {
        return electricalSeats;
    }

    public void setElectricalSeats(boolean electricalSeats) {
        this.electricalSeats = electricalSeats;
    }

    public boolean isElectricalWindows() {
        return electricalWindows;
    }

    public void setElectricalWindows(boolean electricalWindows) {
        this.electricalWindows = electricalWindows;
    }

    public boolean isMultifunctionalSteeringWheel() {
        return multifunctionalSteeringWheel;
    }

    public void setMultifunctionalSteeringWheel(boolean multifunctionalSteeringWheel) {
        this.multifunctionalSteeringWheel = multifunctionalSteeringWheel;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isLedHeadlights() {
        return ledHeadlights;
    }

    public void setLedHeadlights(boolean ledHeadlights) {
        this.ledHeadlights = ledHeadlights;
    }

    public boolean isHeatedSeats() {
        return heatedSeats;
    }

    public void setHeatedSeats(boolean heatedSeats) {
        this.heatedSeats = heatedSeats;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}
