package factories;

import models.Element;
import models.Position;
import models.Size;
import org.junit.Assert;
import org.junit.Test;

public class ElementFactoryTest {

    private final ElementFactory elementFactory = ElementFactoryImpl.getInstance();

    @Test
    public void testCreateElement() {
        //given
        final String elementStr = "Biurko%10%3.5%0.0%2%1.5%0.7%30.3";
        final String separator = "%";
        final Element expected = new Element("Biurko", new Position(10.0f, 3.5f, 0.0f), 30.3f, new Size(2.0f, 1.5f, 0.7f));

        //is
        Element result = elementFactory.createElement(elementStr, separator);


        //expected
        Assert.assertEquals(expected, result);
    }
}
