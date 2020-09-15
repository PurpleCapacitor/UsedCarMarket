package ucm.models;

import ucm.inputs.SafetyInput;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Safety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ABS;
    private boolean ESP;
    private boolean airbags;
    private boolean centralLocking;
    private boolean childLock;
    @OneToMany(mappedBy = "safety")
    private Set<Ad> ads = new HashSet<>();

    public Safety() { }

    public Safety(SafetyInput input) {
        this.ABS = input.isABS();
        this.ESP = input.isESP();
        this.airbags = input.isCentralLocking();
        this.centralLocking = input.isCentralLocking();
        this.childLock = input.isChildLock();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isABS() {
        return ABS;
    }

    public void setABS(boolean ABS) {
        this.ABS = ABS;
    }

    public boolean isESP() {
        return ESP;
    }

    public void setESP(boolean ESP) {
        this.ESP = ESP;
    }

    public boolean isAirbags() {
        return airbags;
    }

    public void setAirbags(boolean airbags) {
        this.airbags = airbags;
    }

    public boolean isCentralLocking() {
        return centralLocking;
    }

    public void setCentralLocking(boolean centralLocking) {
        this.centralLocking = centralLocking;
    }

    public boolean isChildLock() {
        return childLock;
    }

    public void setChildLock(boolean childLock) {
        this.childLock = childLock;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}
