package correccionPruebaNivel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buyer {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private City city;
    private List<Item> inventory;
    private double balance;

    public Buyer(String name, City city, double balance) {
        this.name = name;
        this.city = city;
        this.inventory = new ArrayList<Item>();
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean buyItem(Item item, Seller foundedSeller)  {
        boolean purchasedItem = false;
        try{
            purchasedItem = payItem(item, foundedSeller);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        return purchasedItem;
    }

    public boolean payItem(Item item, Seller foundedSeller)throws InsufficientFundsException{
        boolean purchasedItem = false;
        if(balance< item.getPrice()){
            throw new InsufficientFundsException("Saldo insuficiente para la compra.");
        } else {
            inventory.add(item);
            setBalance(balance- item.getPrice());
            System.out.println(name+" ha comprado "+item.getName()+" a "+foundedSeller.getName()+".");
            purchasedItem = true;
        }
        return purchasedItem;
    }

    public static Buyer fonudBuyer(City foundedCity){
        System.out.println("Indica el nombre del comprador:");
        foundedCity.getBuyers().forEach(buyer -> System.out.println("-"+buyer.getName()+", balance: "+buyer.getBalance()+"."));
        Buyer foundedBuyer = null;
        boolean buyerFound = false;
        while (!buyerFound) {
            String inputBuyer = sc.nextLine();
            inputBuyer = inputBuyer.toLowerCase();

            for (Buyer buyer : foundedCity.getBuyers()) {
                if (buyer.getName().toLowerCase().contains(inputBuyer)) {
                    foundedBuyer = buyer;
                    buyerFound = true;
                }
            }
            if (!buyerFound) {
                System.out.println("Comprador no encontrado. Inténtalo de nuevo:");
            }
        }
        return foundedBuyer;
    }

    @Override
    public String toString() {
        return "Buyer --> Name: " + name + ", city: " + city.getName() + ", inventory: " + inventory + ", balance: "
                + balance + ".";
    }

}
