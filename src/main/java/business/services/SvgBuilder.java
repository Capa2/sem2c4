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
        double shedRatio = (shedLength == 0 || shedWidth == 0) ? 0 : (shedWidth / width);
        // size units
        int ti = 4; // tiny
        int sm = ti * 2; // small
        int md = sm * 2; // medium
        int lg = md * 2; // large

        int posts = typeCount(bom, "post");
        int rafters = typeCount(bom, "raf");

        // frame
        svg.addFilledRect(0, 0, width, length);
        svg.addRect(ti, ti, width - sm, length - sm);

        // Draw 2 posts top, 2 in the bottom, or past large sheds
        double firstPostY = md;
        double lastPostY = length - lg;
        if (shedRatio != 0) lastPostY -= (shedRatio > 0.8) ? shedLength + lg * 4 : shedLength - md;

        svg.addRect(md, firstPostY, md, md); // fixed post top
        svg.addRect(width - lg, firstPostY, md, md); // fixed post top
        svg.addRect(md, lastPostY, md, md); // fixed post bottom
        svg.addRect(width - lg, lastPostY, md, md); // fixed post bottom

        // draw shed with posts
        if (shedRatio != 0) {
            double shedX = (shedRatio > 0.8) ? (width - shedWidth) / 2 : md; // center big sheds
            double shedY = length - shedLength;
            shedY -= (shedRatio > 0.8) ? (width - shedWidth) / 2 : md; // center big sheds
            svg.addFilledRect(shedX, shedY, shedWidth, shedLength); // shed
            svg.addRect(shedX, shedY, md, md); // shedpost top left
            svg.addRect(shedX + shedWidth - md, shedY, md, md); // shedpost top right
            svg.addRect(shedX, shedY + shedLength - md, md, md); // shedpost bottom left
            svg.addRect(shedX + shedWidth - md, shedY + shedLength - md, md, md); // shedpost bottom right
            if (shedRatio < 0.8) svg.addRect(width - lg, length - lg, md, md); // post opposite small shed
        }

        if ((lastPostY - firstPostY) / 2 > 310) {
            double centerPostY = (lastPostY - firstPostY) / 2;
            svg.addRect(md, centerPostY, md, md);
            svg.addRect(width - lg, centerPostY, md, md);
        }
        // rem
        svg.addRect(sm, ti, sm, length - sm);
        svg.addRect(width - md, ti, sm, length - sm);

        // spæretræ
        Material raf = getType(bom, "rafter");
        for (int i = 0; i <= raf.getAmount(); i++) {
            double gab = (length - lg) / raf.getAmount();
            svg.addEmptyRect(0, md + gab * i, width, ti);
        }
        // roof
        double roofY2 = length - md;
        if (shedRatio > 0.8) roofY2 -= shedLength;
        svg.addDottedLine(md, md, width - md, roofY2);
        svg.addDottedLine(width - md, md, md, roofY2);
        return toString();
    }


    @Override
    public String toString() {
        return svg.toString();
    }
}

