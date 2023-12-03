package correccionPruebaNivel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Seller {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private City city;
    private List<Item> inventory= new ArrayList<Item>();

    public Seller(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public abstract void loadDataItem(Item item);

    public abstract void addItem(Item item);

    public abstract void sellItem();

    public static Seller fonudSeller(City foundedCity){
        System.out.println("Indica el nombre del vendedor:");
        foundedCity.getSellers().forEach(seller -> System.out.println("-"+seller.getName()));
        Seller foundedSeller = null;
        boolean sellerFound = false;
        while (!sellerFound) {
            String inputSeller = sc.nextLine();
            inputSeller = inputSeller.toLowerCase();

            for (Seller seller : foundedCity.getSellers()) {
                if (seller.getName().toLowerCase().contains(inputSeller)) {
                    foundedSeller = seller;
                    sellerFound = true;
                }
            }
            if (!sellerFound) {
                System.out.println("Comprador no encontrado. Inténtalo de nuevo:");
            }
        }
        return foundedSeller;
    }

    @Override
    public String toString() {
        return "Seller --> Name: " + name + ", city: " + city.getName() + ", inventory: " + inventory + ".";
    }

}
