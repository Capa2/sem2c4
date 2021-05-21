package business.entities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Bom {
    final private List<Material> bom;
    private double price;

    public Bom(List<Material> bom) {
        this.bom = new ArrayList<>(bom);
    }

    public List<Material> getList() {
        return bom;
    }


    public double getCost() {
        double cost;
        try {
            cost = bom.parallelStream().mapToDouble(Material::getCost).sum();
        } catch (NullPointerException ex) {
            cost = 12500d;
        }
        return cost;
    }

    public double getPrice() {
        return (price == 0) ? getCost() * 1.5d : price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceString() {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(getPrice());
    }

    public String getCostString() {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(getCost());
    }


    public int size() {
        return bom.size();
    }

}
