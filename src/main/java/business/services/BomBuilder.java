package business.services;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;

import java.util.ArrayList;
import java.util.List;

public class BomBuilder {
    List<Material> bom;
    CarportFacade carportFacade;
    MaterialFacade materialFacade;
    Carport carport;

    public BomBuilder(Database database) {
        carportFacade = new CarportFacade(database);
        materialFacade = new MaterialFacade(database);

    }

    public String getPriceString(int carportId) {
        return getBom(carportId).getPriceString();
    }

    public String getCostString(int carportId) {
        return getBom(carportId).getCostString();
    }

    public Bom getBom(int carportId) {
        try {
            this.carport = carportFacade.getCarport(carportId);
            return getBom(carport);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bom getBom(Carport carport) {
        bom = new ArrayList<>();

        // assign materials
        Material post = getDbMaterial("trykimp. stolpe");
        Material rafter = getDbMaterial("spærtræ ubh.");
        Material roof = (carport.getRoofAngle() == 0) ? getDbMaterial("Plastmo Ecolite blåtonet") : getDbMaterial("Betontagsten");
        Material rim = getDbMaterial("trykimp. brædt");

        // calc amount & add to bom
        addPosts(post);
        addRafters(rafter);
        addRim(rim);
        addRoof(roof);

        // add (a currently arbitrary amount of) misc items
        addMisc();
        if (carport.getWidth() + carport.getLength() > 750) addMisc();
        if (carport.getWidth() + carport.getLength() > 1150) addMisc();
        if (carport.getWidth() + carport.getLength() > 1350) addMisc();

        return new Bom(bom);
        // TODO: add new materials and assign them according to carport data for price variation
    }

    private void addMisc() {
        add(getDbMaterial("plastmo bundskruer 200 stk."));
        add(getDbMaterial("skruer 4,5x7mm 400 stk."));
        add(getDbMaterial("skruer 4,5x7mm 300 stk."));
        add(getDbMaterial("firkantsskiver 40x40mm"));
    }

    private Material getDbMaterial(String m) {
        try {
            return materialFacade.getMaterial(m);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void add(Material m) {
        bom.add(m);
    }

    private void addPosts(Material post) { // stolper
        double shedRatio = (carport.getShedWidth() == 0 || carport.getShedLength() == 0) ? 0 : (carport.getWidth() * 1d) / (carport.getShedWidth() * 1d);
        int amount = (shedRatio == 0) ? 0 : 4; // shed needs 4
        int lengthToSupport = (shedRatio > 0.8) ? carport.getLength() - carport.getShedLength() : carport.getLength();
        while (lengthToSupport > 0) {
            amount += 2;
            lengthToSupport -= 310; // max supported length
        }
        post.setAmount(Math.max(amount, 4));
        bom.add(post);
    }

    private void addRafters(Material rafter) { // spæretræ
        addRafters(rafter, 55); // default span
    }

    private void addRafters(Material rafter, int gap) { // spæretræ
        rafter.setAmount(carport.getLength() / gap);
        bom.add(rafter);
    }

    private void addRim(Material rem) { // remme
        rem.setAmount((int) (2 * (Math.ceil(1d * carport.getLength() / rem.getLength()))));
        bom.add(rem);
    }

    private void addRoof(Material roof) { // tag
        roof.setAmount((int) Math.ceil(carport.getLength() * carport.getWidth()) / (roof.getLength() * roof.getWidth()));
        bom.add(roof);
    }

}
