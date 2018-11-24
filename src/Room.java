import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Room {
    private final String roomName;
    private final String roomColorHex;
    private final Float powierzchnia;
    private final Float height;
    private final List<Element> elements = new LinkedList<>();

    public Room(String roomName, String roomColorHex, Float powierzchnia, Float height) {
        this.roomName = roomName;
        this.roomColorHex = roomColorHex;
        this.powierzchnia = powierzchnia;
        this.height = height;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomColorHex() {
        return roomColorHex;
    }

    public Float getPowierzchnia() {
        return powierzchnia;
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
                Objects.equals(powierzchnia, room.powierzchnia) &&
                Objects.equals(height, room.height) &&
                Objects.equals(elements, room.elements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomName, roomColorHex, powierzchnia, height, elements);
    }
}
