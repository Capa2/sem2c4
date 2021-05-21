package business.services;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Material;
import business.entities.SVG;
import business.exceptions.UserException;
import business.persistence.Database;

import java.util.Map;

public class SvgBuilder {
    SVG svg;
    Map<Integer, String> materialCategories;

    public SvgBuilder(Database database) {
        MaterialFacade materialFacade = new MaterialFacade(database);
        try {
            materialCategories = materialFacade.getCategories();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    private Material getType(Bom bom, String categoryName) {
        for (Material m : bom.getList()) {
            if (categoryName.equals(materialCategories.get(m.getMaterialCategoryId()))) {
                return m;
            }
        }
        return null;
    }

    private int typeCount(Bom bom, String categoryName) {
        int count = 0;
        for (Material m : bom.getList()) {
            if (categoryName.equals(materialCategories.get(m.getMaterialCategoryId()))) {
                count += m.getAmount();
            }
        }
        return count;
    }

    public String draw(Carport carport, Bom bom) {
        svg = new SVG(0, 0, "0 0 " + carport.getWidth() + " " + carport.getLength(), 100, 100);
        double width = carport.getWidth();
        double length = carport.getLength();
        double shedWidth = carport.getShedWidth();
        double shedLength = carport.getShedLength();
        // size units
        int ti = 4; // tiny
        int sm = ti * 2; // small
        int md = sm * 2; // medium
        int lg = md * 2; // large

        int posts = typeCount(bom, "post");
        int rafters = typeCount(bom, "rafter");

        // frame
        svg.addFilledRect(0, 0, width, length);
        svg.addRect(ti, ti, width - sm, length - sm);

        // Draw 2 posts top, 2 in the bottom, or past large sheds
        double lastPostY = length - lg;
        if (carport.hasShed()) lastPostY -= (carport.hasLargeShed()) ? shedLength + lg * 4 : shedLength - md;

        svg.addRect(md, md, md, md); // fixed post top
        svg.addRect(width - lg, md, md, md); // fixed post top
        svg.addRect(md, lastPostY, md, md); // fixed post bottom
        svg.addRect(width - lg, lastPostY, md, md); // fixed post bottom

        // draw shed with posts
        if (carport.hasShed()) {
            double shedX = (carport.hasLargeShed()) ? (carport.getNoShedWidth()) / 2d : md; // center big sheds
            double shedY = length - shedLength;
            shedY -= (carport.hasLargeShed()) ? carport.getNoShedWidth() / 2d : md; // center big sheds
            svg.addFilledRect(shedX, shedY, shedWidth, shedLength); // shed
            svg.addRect(shedX, shedY, md, md); // shedpost top left
            svg.addRect(shedX + shedWidth - md, shedY, md, md); // shedpost top right
            svg.addRect(shedX, shedY + shedLength - md, md, md); // shedpost bottom left
            svg.addRect(shedX + shedWidth - md, shedY + shedLength - md, md, md); // shedpost bottom right
            if (!carport.hasLargeShed()) svg.addRect(width - lg, length - lg, md, md); // post opposite small shed
        }

        // add center post if length between corner posts require additional support
        if ((lastPostY - md) / 2 > 310) {
            double centerPostY = (lastPostY - md) / 2;
            svg.addRect(md, centerPostY, md, md);
            svg.addRect(width - lg, centerPostY, md, md);
        }
        // rim / rem
        svg.addRect(sm, ti, sm, length - sm);
        svg.addRect(width - md, ti, sm, length - sm);

        // rafter / spæretræ
        Material rafter = getType(bom, "rafter");
        try {
            for (int i = 0; i <= rafter.getAmount(); i++) {
                double gab = (length - lg) / rafter.getAmount();
                svg.addEmptyRect(0, md + gab * i, width, ti);
            }
        } catch (NullPointerException ex) {
            for (int i = 0; i <= (int) Math.ceil(carport.getLength() / 55d); i++) {
                double gab = (length - lg) / rafter.getAmount();
                svg.addEmptyRect(0, md + gab * i, width, ti);
            }
            ex.printStackTrace();
        }

        // roof
        double roofY2 = length - md;
        if (carport.hasLargeShed()) roofY2 -= shedLength;
        svg.addDottedLine(md, md, width - md, roofY2);
        svg.addDottedLine(width - md, md, md, roofY2);
        return toString();
    }

    @Override
    public String toString() {
        return svg.toString();
    }
}

