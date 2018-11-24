import models.Home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HomeFactory homeFactory = HomeFactory.getInstance();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("home"));
            List<String> lines = new LinkedList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

            Home home = homeFactory.createHome(lines);
            System.out.println("Home: " + home);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
