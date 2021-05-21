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
        this.carport = carport;
        bom = new ArrayList<>();

        // assign materials
        Material post = getDbMaterial("trykimp. stolpe");
        Material rafter = getDbMaterial("spærtræ ubh.");
        Material roof = carport.hasFlatRoof() ? getDbMaterial("Plastmo Ecolite blåtonet") : getDbMaterial("Betontagsten");
        Material rim = getDbMaterial("trykimp. brædt");

        // calc amount & add to bom
        addPosts(post);
        addRafters(rafter, 55);
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
        int amount = 2;
        if (carport.hasShed()) amount += (carport.hasLargeShed() ? 4 : 3);
        int lengthToSupport = carport.hasLargeShed() ? carport.getNoShedlength() : carport.getLength();
        while (lengthToSupport > 0) {
            amount += 2;
            lengthToSupport -= 300; // max supported length
        }
        post.setAmount(Math.max(amount, 4));
        bom.add(post);
    }

    private void addRafters(Material rafter, double gap) { // spæretræ
        rafter.setAmount((int) Math.ceil((1d * carport.getLength()) / gap));
        bom.add(rafter);
    }

    private void addRim(Material rem) { // remme
        rem.setAmount((int) (2 * (Math.ceil((1d * carport.getLength()) / (1d * rem.getLength())))));
        bom.add(rem);
    }

    private void addRoof(Material roof) { // tag
        roof.setAmount((int) Math.ceil(((1d * carport.getLength()) * (1d * carport.getWidth())) / ((1d * roof.getLength()) * (1d * roof.getWidth()))));
        bom.add(roof);
    }

}
