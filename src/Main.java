import models.Home;

public class Main {
    public static void main(String[] args) {
        HomeLoader homeLoader = HomeLoaderImpl.getInstance();

        Home home = homeLoader.loadHome("home", "#");

        System.out.println("Home: " + home);
    }
}
