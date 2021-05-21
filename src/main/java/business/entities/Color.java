package business.entities;

public class Color {
    private int id;
    private String name, hexcode;

    public Color(int id, String name, String hexcode) {
        this.id = id;
        this.name = name;
        this.hexcode = hexcode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHexcode() {
        return hexcode;
    }
}
