package business.entities;

public class User
{
    private int id, phone, zipCode;
    private String email, password, role, name, street, town;

    public User(int phone, String email, String password, String role, String name, String street, String town, int zipCode) {

        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.street = street;
        this.town = town;
        this.zipCode = zipCode;
    }

    public User(int phone, int zipCode, String email, String name, String street, String town) {
        this.phone = phone;
        this.zipCode = zipCode;
        this.email = email;
        this.name = name;
        this.street = street;
        this.town = town;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
