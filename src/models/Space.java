package models;

import java.util.List;

public interface Space {
    String getName();
    String getColorHex();
    Float getArea();
    Float getHeight();
    List<Element> getElements();
}
