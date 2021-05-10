package business.entities;

public class Town {
    private int id, townId;
    private String name;

    public Town(String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getTownId() { return townId; }

    public void setTownId(int townId) { this.townId = townId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
