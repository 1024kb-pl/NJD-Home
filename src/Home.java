import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Home {
    private final String homeName;
    private final String address;
    private final int homemadeCount;
    private final List<Room> rooms = new LinkedList<>();

    public Home(String homeName, String address, int homemadeCount) {
        this.homeName = homeName;
        this.address = address;
        this.homemadeCount = homemadeCount;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getAddress() {
        return address;
    }

    public int getHomemadeCount() {
        return homemadeCount;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return homemadeCount == home.homemadeCount &&
                Objects.equals(homeName, home.homeName) &&
                Objects.equals(address, home.address) &&
                Objects.equals(rooms, home.rooms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(homeName, address, homemadeCount, rooms);
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeName='" + homeName + '\'' +
                ", address='" + address + '\'' +
                ", homemadeCount=" + homemadeCount +
                ", rooms=" + rooms +
                '}';
    }
}
