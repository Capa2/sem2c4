package business.services;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;

import java.util.ArrayList;
import java.util.List;

public class BomGenerator {
List<Material> bom;
CarportFacade carportFacade;
MaterialFacade materialFacade;
Carport carport;

    public BomGenerator(Database database) {
        carportFacade = new CarportFacade(database);
        materialFacade = new MaterialFacade(database);

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
        Material post   = getDbMaterial("trykimp. stolpe");
        Material rafter = getDbMaterial("spærtræ ubh.");
        Material rim    = getDbMaterial("Plastmo Ecolite blåtonet");
        Material roof   = getDbMaterial("trykimp. brædt");

        // calc amount & add to bom
        addPosts(post);
        addRafters(rafter);
        addRim(rim);
        addRoof(roof);

        // add misc items
        add(getDbMaterial("plastmo bundskruer 200 stk."));
        add(getDbMaterial("skruer 4,5x7mm 400 stk."));
        add(getDbMaterial("skruer 4,5x7mm 300 stk."));
        add(getDbMaterial("firkantsskiver 40x40mm"));

        return new Bom(bom);
        // TODO: add new materials and assign them according to carport data
    }

    private Material getDbMaterial(String m) {
        try {
            return materialFacade.getMaterial(m);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return null;
    }

    private  void add(Material m) {bom.add(m);}

    private void addPosts(Material post) { // stolper
        int amount = 2;
        int lengthToSupport = carport.getLength() - carport.getShedLength() - 100; // first posts always @ 1m
        while (lengthToSupport > 0) {
            amount += 2;
            lengthToSupport -= 310; // max supported length
        }
        post.setAmount(amount);
        bom.add(post);
    }

    private void addRafters(Material rafter) { // spæretræ
        addRafters(rafter, 55); // default span
    }

    private void addRafters(Material rafter, int gap) { // spæretræ
        rafter.setAmount((int) Math.ceil(carport.getWidth() / gap));
        bom.add(rafter);
    }

    private void addRim(Material rem) { // remme
        rem.setAmount(2 * (int) Math.ceil(carport.getLength()/rem.getLength()));
        bom.add(rem);
    }

    private void addRoof(Material roof) { // tag
        roof.setAmount((int) Math.ceil(carport.getLength() * carport.getWidth()) / (roof.getWidth() + roof.getLength()));
        bom.add(roof);
    }

}
