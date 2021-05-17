package business.entities;

public class Material {
    int id, width, length, amount, materialCategoryId;
    double cost;
    String name, color, hexcode;

    public Material(int id, int width, int length, double cost, String name, int materialCategoryId) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.amount = 1;
        this.cost = cost;
        this.name = name;
        this.materialCategoryId = materialCategoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaterialCategoryId() {
        return materialCategoryId;
    }

    public void setMaterialCategoryId(int materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    public String getColor() {
        return color;
    }

    public String getHexcode() {
        return hexcode;
    }

    public void setColor(String color, String hexcode) {
        this.color = color;
        this.hexcode = hexcode;
    }
}
