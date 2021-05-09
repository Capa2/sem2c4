package business.entities;

public class Address {
    private int postalCode, id;
    String address, town, municipality;

    public Address(int postalCode, String address, String town, String municipality) {
        this.postalCode = postalCode;
        this.address = address;
        this.town = town;
        this.municipality = municipality;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}
