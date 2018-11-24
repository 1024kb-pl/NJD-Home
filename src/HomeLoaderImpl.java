import factories.HomeFactory;
import factories.HomeFactoryImpl;
import models.Home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HomeLoaderImpl implements HomeLoader {
    private static final HomeLoader instance = new HomeLoaderImpl();
    private final HomeFactory homeFactory = HomeFactoryImpl.getInstance();

    private HomeLoaderImpl() {

    }

    public static HomeLoader getInstance() {
        return instance;
    }


    @Override
    public Home loadHome(String fileName, String separator) {
        List<String> lines = readFile(fileName);
        return homeFactory.createHome(lines, separator);
    }

    private List<String> readFile(String fileName) {
        List<String> lines = new LinkedList<>();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
