package business.entities;

public class Town {
    private int id, postalCodeId;
    private String name;

    public Town(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostalCodeId() {
        return postalCodeId;
    }

    public void setPostalCodeId(int postalCodeId) {
        this.postalCodeId = postalCodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
