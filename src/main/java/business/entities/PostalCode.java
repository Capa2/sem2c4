package business.entities;

public class PostalCode {
    private int id, postalCode;
    private String name;

    public PostalCode(String name) { this.name = name; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPostalCode() { return postalCode; }

    public void setPostalCode(int postalCode) { this.postalCode = postalCode; }
}