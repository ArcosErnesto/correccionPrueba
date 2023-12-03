package correccionPruebaNivel;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Data data = new Data();
        ArrayList<City> cities = new ArrayList<City>();
        ArrayList<Item> items = new ArrayList<Item>();

        data.loadData(cities, items);

        menu.getMainMenu(cities, items);
    }
}