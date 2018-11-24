package models;

import java.util.List;
import java.util.Objects;

public class Room {
    private final String roomName;
    private final String roomColorHex;
    private final Float area;
    private final Float height;
    private final List<Element> elements;

    public Room(String roomName, String roomColorHex, Float area, Float height, List<Element> elements) {
        this.roomName = roomName;
        this.roomColorHex = roomColorHex;
        this.area = area;
        this.height = height;
        this.elements = elements;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomColorHex() {
        return roomColorHex;
    }

    public Float getArea() {
        return area;
    }

    public Float getHeight() {
        return height;
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomName, room.roomName) &&
                Objects.equals(roomColorHex, room.roomColorHex) &&
                Objects.equals(area, room.area) &&
                Objects.equals(height, room.height) &&
                Objects.equals(elements, room.elements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomName, roomColorHex, area, height, elements);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomColorHex='" + roomColorHex + '\'' +
                ", area=" + area +
                ", height=" + height +
                ", elements=" + elements +
                '}';
    }
}
