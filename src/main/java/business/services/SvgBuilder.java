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
        System.out.println(posts);
        // frame & sides:
        svg.addRect(0, 0, length, width);
        svg.addRect(0, 0, length, s);
        svg.addRect(width - s, 0, length, s);
        // plank with posts
        svg.addRect(s, l, s, width - l); // top plank
        svg.addRect(s, length - l - s, s, width - l); // bottom plank
        if (shedLength != 0) {
            int shedY = (shedWidth < width / 2) ? 0 : width / 2 - shedWidth / 2; // center shed if more than half carport width
            svg.addRect(0, shedY, shedWidth, shedLength); // shed
        }
            int firstPostX = (shedLength == 0) ? s*10 : shedLength;
            int lastPostX = length - s*10;
            svg.addRect(firstPostX, m + 1, m, m); // fixed post top
            svg.addRect(firstPostX, length - l - s, m, m); // fixed post top
            svg.addRect(lastPostX, m + 1, m, m); // fixed post top
            svg.addRect(lastPostX, length - l - s, m, m); // fixed post top
        int postGap = (length - firstPostX) / (posts / 2); // post spacing
        for (int i = posts; i > 0; i -= 2) {
            svg.addRect(firstPostX + postGap * (posts-i), m + 1, m, m); // top
            svg.addRect(firstPostX + postGap * (posts-i), length - l - s, m, m); // bottom
        }
        return toString();
    }

    @Override
    public String toString() {
        return svg.toString();
    }
}

