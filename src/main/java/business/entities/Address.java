package business.entities;

public class Address {
    private int id, townId;
    String name;

    public Address(int id, String name, int townId) {
        this.id = id;
        this.name = name;
        this.townId = townId;
    }

    public Address(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}