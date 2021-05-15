package business.entities;

import java.util.List;

public class Carport {
    int id, roofAngle, width, length, shedWidth, shedLength;
    String name;
    List<Material> materialList;

    public Carport(int roofAngle, int width, int length, int shedWidth, int shedLength) {
        this.roofAngle = roofAngle;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    public Carport(int id, int roofAngle, int width, int length, int shedWidth, int shedLength) {
        this.id = id;
        this.name = name;
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

    private void setPosts(Material post) { // stolper
        int amount = 2;
        int lengthToSupport = length - shedLength - 100; // first posts always @ 1m
        while (lengthToSupport > 0) {
            amount += 2;
            lengthToSupport -= 310; // max supported length
        }
        post.setAmount(amount);
        materialList.add(post);
    }

    private void setRafters(Material rafter) {
        setRafters(rafter, 55); // default span
    }

    private void setRafters(Material rafter, int gap) { // spæretræ
        rafter.setAmount((int) Math.ceil(width / gap));
        materialList.add(rafter);
    }

    private void setRem(Material rem) { // remme
        rem.setAmount(2 * (int) Math.ceil(length/rem.length));
        materialList.add(rem);
    }

    private void setRoof(Material roof) { // tag
        roof.setAmount((int) Math.ceil(length * width) / (roof.width + roof.length));
        materialList.add(roof);
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

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
