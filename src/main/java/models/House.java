package models;

import java.util.List;

public interface House {
    String getName();
    String getAddress();
    int getHouseholdCount();
    List<Room> getRooms();
}
