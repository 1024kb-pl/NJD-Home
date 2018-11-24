package factories;

import models.Home;
import models.Room;
import models.properties.HomeProperty;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HomeFactoryImpl implements HomeFactory {
    private static final HomeFactory instance = new HomeFactoryImpl();
    private final RoomFactory roomFactory = RoomFactoryImpl.getInstance();

    private HomeFactoryImpl() {

    }

    public static HomeFactory getInstance() {
        return instance;
    }

    public Home createHome(List<String> homeStr, String separator) {
        int indexLine = 0;
        final Map<HomeProperty, String> homeDetails = getHomeDetails(homeStr.get(indexLine), separator);
        indexLine++;

        final String homeName = homeDetails.get(HomeProperty.HOME_NAME);
        final String homeAddress = homeDetails.get(HomeProperty.ADDRESS);
        final int homeMadeCount = Integer.valueOf(homeDetails.get(HomeProperty.HOMEMADE_COUNT));
        final int roomCount = Integer.valueOf(homeDetails.get(HomeProperty.ROOMS_COUNT));
        final List<Room> rooms = new LinkedList<>();

        for (int i = 0; i < roomCount; i++) {
            List<String> roomDetailsList = new LinkedList<>(homeStr.subList(indexLine, indexLine+roomCount + 1));
            final Room room = roomFactory.createRoom(roomDetailsList, separator);
            rooms.add(room);
        }

        return new Home(homeName, homeAddress, homeMadeCount, rooms);
    }

    private Map<HomeProperty, String> getHomeDetails(String homeDetailsStr, String separator) {
        final String [] homeDetailsValues = homeDetailsStr.split(separator);
        final Map<HomeProperty, String> homeDetails = new EnumMap<>(HomeProperty.class);

        homeDetails.put(HomeProperty.HOME_NAME, homeDetailsValues[0]);
        homeDetails.put(HomeProperty.ADDRESS, homeDetailsValues[1]);
        homeDetails.put(HomeProperty.HOMEMADE_COUNT, homeDetailsValues[2]);
        homeDetails.put(HomeProperty.ROOMS_COUNT, homeDetailsValues[3]);


        return homeDetails;

    }
}
