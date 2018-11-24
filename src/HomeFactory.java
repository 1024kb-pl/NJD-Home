import models.*;
import models.properties.ElementProperty;
import models.properties.HomeProperty;
import models.properties.RoomProperty;

import java.util.*;

public class HomeFactory {
    private static final HomeFactory instance = new HomeFactory();
    private static final String SEPARATOR = "#";

    private HomeFactory() {

    }

    public static HomeFactory getInstance() {
        return instance;
    }

    public Home createHome(List<String> homeStr) {
        int indexLine = 0;
        final Map<HomeProperty, String> homeDetails = getHomeDetails(homeStr.get(indexLine));
        indexLine++;

        final List<Room> rooms = new LinkedList<>();

        final int roomCount = Integer.valueOf(homeDetails.get(HomeProperty.ROOMS_COUNT));

        for (int i = 0; i < roomCount; i++) {
            final Map<RoomProperty, String> roomDetails = getRoomDetails(homeStr.get(indexLine));
            indexLine++;
            final int elementsCount = Integer.valueOf(roomDetails.get(RoomProperty.COUNT_ELEMENTS));
            final List<Element> roomElements = new LinkedList<>();


            for (int j = 0; j < elementsCount; j++) {
                final Map<ElementProperty, String> elementDetails = getElementProperty(homeStr.get(indexLine));
                indexLine++;

                final String elementName = elementDetails.get(ElementProperty.ELEMENT_NAME);
                final float weight = Float.valueOf(elementDetails.get(ElementProperty.WEIGHT));
                final Position position = getPosition(elementDetails);
                final Size size = getSize(elementDetails);
                final Element element = new Element(elementName, position, weight, size);
                roomElements.add(element);
            }

            final String roomName = roomDetails.get(RoomProperty.ROOM_NAME);
            final String roomColor = roomDetails.get(RoomProperty.ROOM_COLOR_HEX);
            final float powierzchnia = Float.valueOf(roomDetails.get(RoomProperty.POWIERZCHNIA));
            final float height = Float.valueOf(roomDetails.get(RoomProperty.HEIGHT));

            final Room room = new Room(roomName, roomColor, powierzchnia, height, roomElements);
            rooms.add(room);
        }

        final String homeName = homeDetails.get(HomeProperty.NAME);
        final String homeAddress = homeDetails.get(HomeProperty.ADDRESS);
        final int homeMadeCount = Integer.valueOf(homeDetails.get(HomeProperty.HOMEMADE_COUNT));

        return new Home(homeName, homeAddress, homeMadeCount, rooms);
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

    private Map<ElementProperty,String> getElementProperty(String elementDetailsStr) {
        final String [] elementDetailsValues = elementDetailsStr.split(SEPARATOR);
        final Map<ElementProperty, String> elementDetails = new EnumMap<>(ElementProperty.class);

        elementDetails.put(ElementProperty.ELEMENT_NAME, elementDetailsValues[0]);
        elementDetails.put(ElementProperty.POSITION_X, elementDetailsValues[1]);
        elementDetails.put(ElementProperty.POSITION_Y, elementDetailsValues[2]);
        elementDetails.put(ElementProperty.POSITION_Z, elementDetailsValues[3]);
        elementDetails.put(ElementProperty.LENGTH, elementDetailsValues[4]);
        elementDetails.put(ElementProperty.WIDTH, elementDetailsValues[5]);
        elementDetails.put(ElementProperty.HEIGHT, elementDetailsValues[6]);


        return elementDetails;
    }

    private Map<RoomProperty,String> getRoomDetails(String roomDetailsStr) {
        final String [] roomDetailsValues = roomDetailsStr.split(SEPARATOR);
        final Map<RoomProperty, String> roomDetails = new EnumMap<>(RoomProperty.class);

        roomDetails.put(RoomProperty.ROOM_NAME, roomDetailsValues[0]);
        roomDetails.put(RoomProperty.ROOM_COLOR_HEX, roomDetailsValues[1]);
        roomDetails.put(RoomProperty.HEIGHT, roomDetailsValues[2]);
        roomDetails.put(RoomProperty.POWIERZCHNIA, roomDetailsValues[3]);
        roomDetails.put(RoomProperty.COUNT_ELEMENTS, roomDetailsValues[4]);


        return roomDetails;
    }

    private Map<HomeProperty, String> getHomeDetails(String homeDetailsStr) {
        final String [] homeDetailsValues = homeDetailsStr.split(SEPARATOR);
        final Map<HomeProperty, String> homeDetails = new EnumMap<>(HomeProperty.class);

        homeDetails.put(HomeProperty.NAME, homeDetailsValues[0]);
        homeDetails.put(HomeProperty.ADDRESS, homeDetailsValues[1]);
        homeDetails.put(HomeProperty.HOMEMADE_COUNT, homeDetailsValues[2]);
        homeDetails.put(HomeProperty.ROOMS_COUNT, homeDetailsValues[3]);


        return homeDetails;

    }
}
