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
        svg = new SVG(0, 0, "0 0 " + carport.getWidth() +" "+ carport.getLength(), 100, 100);
        int length = carport.getLength(); // 600
        int width = carport.getWidth();// 780
        int shedLength = carport.getShedLength();
        int shedWidth = carport.getShedWidth();
        int sm = 10; // small
        int md = 15; // medium
        int lg = 20; // large
        int posts = typeCount(bom, "post");
        int rafters = typeCount(bom, "rafter");
        // frame & sides:
        svg.addRect(0, 0, length, width);
        svg.addRect(0, 0, length, sm);
        svg.addRect(width - sm, 0, length, sm);
        // plank with posts
        svg.addRect(sm, lg, sm, width - lg); // top plank
        svg.addRect(sm, length - lg - sm, sm, width - lg); // bottom plank
        if (shedLength != 0) {
            int shedY = (shedWidth < width / 2) ? lg : (width / 2 - shedWidth / 2) / 4; // center shed if more than half carport width
            svg.addFilledRect(sm, shedY, shedWidth, shedLength); // shed
        }
        // draw 4 fixed posts
        int firstPostX = (shedLength == 0) ? sm * 10 : shedLength + lg * 5 - sm / 2;
        int lastPostX = width - sm * 10;
        svg.addRect(firstPostX, md, md, md); // fixed post top
        svg.addRect(firstPostX, length - lg - sm, md, md); // fixed post top
        svg.addRect(lastPostX, md, md, md); // fixed post top
        svg.addRect(lastPostX, length - lg - sm, md, md); // fixed post top
        // draw remaining posts
        if (posts < 4) {
            int remainingPosts = posts - 4;
            int postGap = (length - firstPostX - (length - lastPostX)) / ((remainingPosts) / 2); // post spacing
            for (int i = remainingPosts; i > 0; i -= 2) {
                svg.addRect(firstPostX + postGap * (remainingPosts - i), md + sm / 10, md, md); // top
                svg.addRect(firstPostX + postGap * (remainingPosts - i), length - lg - sm, md, md); // bottom
            }
        }
        return toString();
    }

    @Override
    public String toString() {
        return svg.toString();
    }
}

