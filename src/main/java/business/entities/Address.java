package business.entities;

public class Address {
    private int id, townId;
    String street;

    public Address(String street) {
        this.street = street;
    }

    public int getTownId() { return townId; }

    public void setTownId(int townId) { this.townId = townId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}