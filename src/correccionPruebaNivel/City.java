package correccionPruebaNivel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class City {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private ArrayList<Seller> sellers;
    private ArrayList<Buyer> buyers;

    public City(String name) {
        this.name = name;
        this.sellers = new ArrayList<Seller>();
        this.buyers = new ArrayList<Buyer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Seller> getSellers() {

        return sellers;
    }

    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public void addBuyer(Buyer buyer) {

        this.buyers.add(buyer);
    }

    public void addSeller(Seller seller) {

        this.sellers.add(seller);
    }

    public static City foundCity(ArrayList<City> cities) {
        cities.forEach(city -> System.out.println("-" + city.getName()));
        City foundedCity = null;
        boolean cityFound = false;
        while (!cityFound) {
            String inputCity = sc.nextLine();

            for (City city : cities) {
                if (city.getName().equalsIgnoreCase(inputCity)) {
                    foundedCity = city;
                    cityFound = true;
                }
            }
            if (!cityFound) {
                System.out.println("Ciudad no encontrada. Inténtalo de nuevo:");
            }
        }
        return foundedCity;
    }

    public ArrayList<Item> allItemsInCity() {
        return (ArrayList<Item>) sellers.stream()
                .flatMap(seller -> seller.getInventory().stream())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "City --> Name: " + name + ", sellers: " + sellers + ", buyers: " + buyers + ".";
    }


}