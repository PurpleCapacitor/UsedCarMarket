package ucm.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean firstOwner;
    private boolean serviceHistory;
    private boolean spareKey;
    private boolean taxi;
    @OneToMany(mappedBy = "condition")
    private Set<Ad> ads = new HashSet<>();

    public Condition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFirstOwner() {
        return firstOwner;
    }

    public void setFirstOwner(boolean firstOwner) {
        this.firstOwner = firstOwner;
    }

    public boolean isServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(boolean serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public boolean isSpareKey() {
        return spareKey;
    }

    public void setSpareKey(boolean spareKey) {
        this.spareKey = spareKey;
    }

    public boolean isTaxi() {
        return taxi;
    }

    public void setTaxi(boolean taxi) {
        this.taxi = taxi;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}
