package business.entities;
import java.util.List;

public class Bom {
    final private List<Material> bom;

    public Bom(List<Material> bom) {
        this.bom = bom;
    }

    public List<Material> getList() {
        return bom;
    }

    public float getCost() {
        float cost = 0;
        for (Material m : bom) {
            cost += m.cost;
        }
        return cost;
    }

    public float getDefaultPrice() {
        return getCost() * 1.5f;
    }

    public int size() {
        return bom.size();
    }

}
