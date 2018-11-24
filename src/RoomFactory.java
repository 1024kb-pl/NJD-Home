import models.Element;
import models.Room;
import models.properties.RoomProperty;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomFactory {
    private final static RoomFactory instance = new RoomFactory();
    private final ElementFactory elementFactory = ElementFactory.getInstance();
    private static final String SEPARATOR = "#";


    private RoomFactory() {

    }

    public static RoomFactory getInstance() {
        return instance;
    }

    public Room createRoom(List<String> roomDetailsList) {
        int indexLine = 0;
        final Map<RoomProperty, String> roomDetails = getRoomDetails(roomDetailsList.get(indexLine));
        indexLine++;

        final String roomName = roomDetails.get(RoomProperty.ROOM_NAME);
        final String roomColor = roomDetails.get(RoomProperty.ROOM_COLOR_HEX);
        final float powierzchnia = Float.valueOf(roomDetails.get(RoomProperty.POWIERZCHNIA));
        final float height = Float.valueOf(roomDetails.get(RoomProperty.HEIGHT));
        final int elementsCount = Integer.valueOf(roomDetails.get(RoomProperty.COUNT_ELEMENTS));

        final List<Element> roomElements = new LinkedList<>();

        for (int j = 0; j < elementsCount; j++) {
            Element element = elementFactory.createElement(roomDetailsList.get(indexLine));
            roomElements.add(element);
            indexLine++;
        }

        return new Room(roomName, roomColor, powierzchnia, height, roomElements);
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

}
