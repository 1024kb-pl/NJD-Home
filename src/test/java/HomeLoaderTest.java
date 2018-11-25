import factories.HomeFactoryImpl;
import models.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HomeLoaderTest {

    HomeLoader homeLoader = HomeLoaderImpl.getInstance();
    String kowalskiHomeFileName = "src/test/resources/kowalski.home";
    String pabloHomeFileName = "src/test/resources/pablo.home";

    private Home createKowalskiHome() {
        Element szafka = new Element("Szafka", new Position(1.0f, 1.0f, 1.0f), 10.5f, new Size(2.0f, 1.5f, 1.5f));
        Element stol = new Element("Stół", new Position(2.4f, 2.3f, 2.1f), 15.5f, new Size(2.5f, 2.5f, 1.0f));
        Element kanapa = new Element("Kanapa", new Position(10.5f, 12.5f, 13.4f), 25.3f, new Size(3.0f, 3.0f, 3.0f));
        Element szafa = new Element("Szafa", new Position(10.5f, 12.5f, 13.4f), 25.3f, new Size(3.0f, 3.0f, 3.0f));
        Element krzeslo = new Element("Krzesło", new Position(13.4f, 10.3f, 12.4f), 5.0f, new Size(1.0f, 1.0f, 1.0f));
        Element lozko = new Element("Łóżko", new Position(12.3f, 12.3f, 10.2f), 3.4f, new Size(2.0f, 2.0f, 1.0f));

        Room dzienny = new Room("Dzienny", "#ff0012", 12.5f, 2.3f, Arrays.asList(
                szafka, stol, kanapa, krzeslo
        ));

        Room sypialnia = new Room("Sypialnia", "#ff50ee", 18.3f, 2.0f, Arrays.asList(
                lozko, szafa
        ));

        Room jadalnia = new Room("Jadalnia", "#ffe323", 24.4f, 2.0f, Arrays.asList(
                stol
        ));

        return new Home("Dynia", "papierowa 2A", 6, Arrays.asList(
                dzienny, sypialnia, jadalnia
        ));
    }

    private Home createPabloHome() {
        Element lodowka = new Element("Lodówka", new Position(1.0f, 1.0f, 1.0f), 10.5f, new Size(2.0f, 1.5f, 1.5f));
        Element szafka = new Element("Szafka", new Position(2.4f, 2.3f, 2.1f), 15.5f, new Size(2.5f, 2.5f, 1.0f));
        Element stol = new Element("Stół", new Position(10.5f, 12.5f, 13.4f), 25.3f, new Size(3.0f, 3.0f, 3.0f));
        Element doniczka = new Element("Doniczka", new Position(13.4f, 10.3f, 12.4f), 5.0f, new Size(1.0f, 1.0f, 1.0f));

        Room salon = new Room("Salon", "#ff1112", 12.5f, 2.3f, Arrays.asList(
                szafka, stol, doniczka
        ));

        Room kuchnia = new Room("Kuchnia", "#ff11ee", 18.3f, 2.0f, Arrays.asList(
                stol, lodowka
        ));

        return new Home("Pablasko", "Nozyczki 4B", 3, Arrays.asList(
                salon, kuchnia
        ));
    }

    @Test
    public void testKowalskiHome() {
        //given
        Home expected = createKowalskiHome();

        //is
        Home home = homeLoader.loadHome(kowalskiHomeFileName, "%");

        //when
        Assert.assertEquals(expected, home);
    }

    @Test
    public void testPabloHome() {
        //given
        Home expected = createPabloHome();

        //is
        Home home = homeLoader.loadHome(pabloHomeFileName, "%");

        //when
        Assert.assertEquals(expected, home);
    }

}
