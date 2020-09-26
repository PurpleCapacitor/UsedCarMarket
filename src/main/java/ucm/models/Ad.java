package ucm.models;

import ucm.inputs.AdsInput;

import javax.persistence.*;

@Entity
@Table(name = "siteAds")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String address;
    private String phone;
    private int price;
    private boolean approved;

    @ManyToOne
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;
    @ManyToOne
    @JoinColumn(name = "extras_id")
    private Extras extras;
    @ManyToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;
    @ManyToOne
    @JoinColumn(name = "characteristics_id")
    private Characteristics characteristics;
    @ManyToOne
    @JoinColumn(name = "safety_id")
    private Safety safety;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Ad() {

    }

    public Ad(AdsInput adsInput) {
        this.description = adsInput.getDescription();
        this.address = adsInput.getAddress();
        this.phone = adsInput.getPhone();
        this.price = adsInput.getPrice();
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Extras getExtras() {
        return extras;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public Safety getSafety() {
        return safety;
    }

    public void setSafety(Safety safety) {
        this.safety = safety;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
