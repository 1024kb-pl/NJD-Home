package factories;

import models.Element;
import models.Position;
import models.Room;
import models.Size;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoomFactoryTest {
    private final RoomFactory roomFactory = RoomFactoryImpl.getInstance();

    @Test
    public void testCreateRoom() {
        //given
        final List<String> roomStr = Arrays.asList(
                "Pokoj mamy%#00ff00%10.5%25%2",
                "Biurko%10%3.5%0.0%2%1.5%0.7%30.3",
                "Lampka%10%35%0.7%0.1%0.1%0.1%0.5"
                );
        final String separator = "%";
        final Element biurko = new Element("Biurko", new Position(10.0f, 3.5f, 0.0f), 30.3f, new Size(2.0f, 1.5f, 0.7f));
        final Element lampka = new Element("Lampka", new Position(10.0f, 35f, 0.7f), 0.5f, new Size(0.1f, 0.1f, 0.1f));
        final Room room = new Room("Pokoj mamy", "#00ff00", 25.0f, 10.5f, Arrays.asList(biurko, lampka));

        //is
        Room result = roomFactory.createRoom(roomStr, separator);


        //expected
        Assert.assertEquals(room, result);
    }

    @Test
    public void testCreateRoomWithoutElements() {
        //given
        final List<String> roomStr = Arrays.asList(
                "Pokoj mamy%#00ff00%10.5%25%0"
        );
        final String separator = "%";
        final Room room = new Room("Pokoj mamy", "#00ff00", 25.0f, 10.5f, Collections.<Element>emptyList());

        //is
        Room result = roomFactory.createRoom(roomStr, separator);


        //expected
        Assert.assertEquals(room, result);
    }
}
