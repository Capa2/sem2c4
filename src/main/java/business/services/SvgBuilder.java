package business.services;

import business.entities.Carport;
import business.entities.SVG;

public class SvgBuilder {
    SVG svg;

    public SvgBuilder() {
        svg = new SVG(0, 0, "0 0 855 696", 855, 696);
    }

    public String draw(Carport carport) {
        svg.addRect(0, 0, 600, 780);
        svg.addRect(0, 0, 600, 10);
        svg.addRect(770, 0, 600, 10);
        svg.addRect(10, 20, 10, 760);
        svg.addRect(100, 17, 16, 16);
        svg.addRect(410, 17, 16, 16);
        svg.addRect(710, 17, 16, 16);
        svg.addRect(10, 570, 10, 760);
        svg.addRect(100, 567, 16, 16);
        svg.addRect(410, 567, 16, 16);
        svg.addRect(710, 567, 16, 16);
        return toString();
    }

    @Override
    public String toString() {
        return svg.toString();
    }
}

