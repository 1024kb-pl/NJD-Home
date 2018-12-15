package factories;

import models.Element;
import models.Position;
import models.Size;
import models.properties.ElementProperty;

import java.util.EnumMap;
import java.util.Map;

class ElementFactoryImpl implements ElementFactory {
    private static final ElementFactory instance = new ElementFactoryImpl();

    private ElementFactoryImpl() {

    }

    static ElementFactory getInstance() {
        return instance;
    }

    public Element createElement(String elementDetailsStr, String separator) {
        final Map<ElementProperty, String> elementDetails = getElementProperty(elementDetailsStr, separator);

        final String elementName = elementDetails.get(ElementProperty.ELEMENT_NAME);
        final float weight = Float.valueOf(elementDetails.get(ElementProperty.WEIGHT));
        final Position position = getPosition(elementDetails);
        final Size size = getSize(elementDetails);

        return new Element(elementName, position, weight, size);
    }

    private Map<ElementProperty,String> getElementProperty(String elementDetailsStr, String separator) {
        final String [] elementDetailsValues = elementDetailsStr.split(separator);
        final Map<ElementProperty, String> elementDetails = new EnumMap<>(ElementProperty.class);

        elementDetails.put(ElementProperty.ELEMENT_NAME, elementDetailsValues[0]);
        elementDetails.put(ElementProperty.POSITION_X, elementDetailsValues[1]);
        elementDetails.put(ElementProperty.POSITION_Y, elementDetailsValues[2]);
        elementDetails.put(ElementProperty.POSITION_Z, elementDetailsValues[3]);
        elementDetails.put(ElementProperty.LENGTH, elementDetailsValues[4]);
        elementDetails.put(ElementProperty.WIDTH, elementDetailsValues[5]);
        elementDetails.put(ElementProperty.HEIGHT, elementDetailsValues[6]);
        elementDetails.put(ElementProperty.WEIGHT, elementDetailsValues[7]);


        return elementDetails;
    }

    private Size getSize(Map<ElementProperty,String> elementDetails) {
        final float length = Float.valueOf(elementDetails.get(ElementProperty.LENGTH));
        final float width = Float.valueOf(elementDetails.get(ElementProperty.WIDTH));
        final float height = Float.valueOf(elementDetails.get(ElementProperty.HEIGHT));

        return new Size(length, width, height);

    }

    private Position getPosition(Map<ElementProperty,String> elementDetails) {
        final float positionX = Float.valueOf(elementDetails.get(ElementProperty.POSITION_X));
        final float positionY = Float.valueOf(elementDetails.get(ElementProperty.POSITION_Y));
        final float positionZ = Float.valueOf(elementDetails.get(ElementProperty.POSITION_Z));
        return new Position(positionX, positionY, positionZ);
    }




}
