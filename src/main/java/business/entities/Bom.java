package business.entities;
import java.text.NumberFormat;
import java.util.List;

public class Bom {
    final private List<Material> bom;
    private float price;

    public Bom(List<Material> bom) {
        this.bom = bom;
    }

    public List<Material> getList() {
        return bom;
    }

    public float getCost() {
        float price = 0;
        float cost = 0;
        for (Material m : bom) {
            cost += m.cost;
        }
        return cost;
    }

    public float getPrice() {
        return (price == 0) ? getCost() * 1.5f : price;
    }

    public void setPrice(float price) {
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
