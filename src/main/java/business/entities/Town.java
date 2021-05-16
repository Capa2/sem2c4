package business.entities;

public class Town {
    private int id, postalCodeId;
    private String townName;

    public Town(String townName) {
        this.townName = townName;
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

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
