package business.services;

import business.entities.Carport;
import business.entities.Material;

import java.util.ArrayList;
import java.util.List;

public class BomGenerator {
List<Material> inventory;

    public BomGenerator(List<Material> inventory) {
        this.inventory = inventory;
    }
    public List<Material> Bom(Carport carport) {
        List<Material> bom = new ArrayList<Material>();
        int posts = getPostCount(carport.getWidth(), carport.getShedLength());
        int rafts = getRafterCount(carport.getWidth(), 55); // 55 is derived from supplied information (pdf/video)
        return bom;
    }

    private int getPostCount(int length, int shedLength) { // stolper
        int posts = 2;
        int lengthToSupport = length - shedLength - 100; // first posts always @ 1m
        while (lengthToSupport > 0) {
            posts += 2;
            lengthToSupport -= 310; // max supported length
        }
        return posts;
    }

    private int getRafterCount(int width, int gap) { // spærtræ
        return (int) Math.ceil(width / gap);
    }
}
