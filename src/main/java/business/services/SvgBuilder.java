package business.services;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Material;
import business.entities.SVG;

import java.util.Map;

public class SvgBuilder {
    SVG svg;
    Map<Integer, String> cats;

    public SvgBuilder(Map<Integer, String> cats) {
        this.cats = cats;
    }

    private int typeCount(Bom bom, String categoryName) {
        int count = 0;
        for (Material m : bom.getList()) {
            if (categoryName.equals(cats.get(m.getMaterialCategoryId()))) {
                count += m.getAmount();
            }
        }
        return count;
    }

    public String draw(Carport carport, Bom bom) {
        svg = new SVG(0, 0, "0 0 855 696", 855, 696);
        int length = carport.getLength(); // 600
        int width = carport.getWidth();// 780
        int shedLength = carport.getShedLength();
        int shedWidth = carport.getShedWidth();
        int s = 10;
        int m = 15;
        int l = 20;
        int posts = typeCount(bom, "post");
        int rafters = typeCount(bom, "rafter");
        // frame & sides:
        svg.addRect(0, 0, length, width);
        svg.addRect(0, 0, length, s);
        svg.addRect(width - s, 0, length, s);
        // plank with posts
        svg.addRect(s, l, s, width - l); // top plank
        svg.addRect(s, length - l - s, s, width - l); // bottom plank
        if (shedLength != 0) {
            int y = (width - shedWidth > width / 2) ? 0 : width / 2 - shedWidth / 2; // center shed if more than half carport width
            svg.addRect(0, y, shedWidth, shedLength); // shed
            svg.addRect(shedLength, m + 1, m, m); // fixed post top
            svg.addRect(shedLength, length - l - s, m, m); // fixed post top
        }
        int postGap = (length - shedLength) / (posts / (2 - (int) Math.signum(shedLength))); // post spacing
        for (int i = posts; i > 0; i--) {
            svg.addRect(shedLength + postGap * i, m + 1, m, m); // top
            svg.addRect(shedLength + postGap * i, length - l - s, m, m); // bottom
        }
        return toString();
    }

    @Override
    public String toString() {
        return svg.toString();
    }
}

