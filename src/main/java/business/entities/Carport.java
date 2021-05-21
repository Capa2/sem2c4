package business.entities;


public class Carport {
    int id, roofAngle, width, length, shedWidth, shedLength;
    String name;

    public Carport(int roofAngle, int width, int length, int shedWidth, int shedLength) {
        this.roofAngle = roofAngle;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    public Carport(int id, int roofAngle, int width, int length, int shedWidth, int shedLength) {
        this.id = id;
        this.roofAngle = roofAngle;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    public Carport(int id, String name, int roofAngle, int width, int length, int shedWidth, int shedLength) {
        this.id = id;
        this.name = name;
        this.roofAngle = roofAngle;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoofAngle() {
        return roofAngle;
    }

    public void setRoofAngle(int roofAngle) {
        this.roofAngle = roofAngle;
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

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
