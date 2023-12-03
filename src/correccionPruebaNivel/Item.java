package correccionPruebaNivel;

import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private double price;
    private double wear;

    public Item(String name, double price, double wear) {
        this.name = name;
        this.price = price;
        this.wear = wear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWear() {
        return wear;
    }

    public void setWear(double wear) {
        this.wear = wear;
    }

    public static Item foundItem(ArrayList<Item> items){
        Item foundedItem = null;
        Item typeItem = Menu.chooseTypeItem(items);
        System.out.println("Indica el nombre de item:");
        for (Item item:items) {
            if(item.getClass().equals(typeItem.getClass())){
                System.out.println("-"+item);
            }
        }
        while (foundedItem == null){
            System.out.println("Indica el nombre de item:");
            String nameItem = sc.nextLine();
            int i=0;
            while (i < items.size() && foundedItem == null){
                if(items.get(i).getName().equalsIgnoreCase(nameItem)){
                    foundedItem=items.get(i);
                }
                i++;
            }
            if (foundedItem == null){
                System.out.println("Item no encontrado.");
            }
        }
        return foundedItem;
    }

    public static Item foundItemFromSeller(ArrayList<Item> sellerList){
        Item foundedItem = null;

        while (foundedItem == null){
            System.out.println("Indica el nombre de item:");
            sellerList.forEach(item -> System.out.println("-"+item));
            String nameItem = sc.nextLine();
            int i=0;
            while (i < sellerList.size() && foundedItem == null){
                if(sellerList.get(i).getName().equalsIgnoreCase(nameItem)){
                    foundedItem=sellerList.get(i);
                }
                i++;
            }
            if (foundedItem == null){
                System.out.println("Item no encontrado.");
            }
        }
        return foundedItem;
    }

    @Override
    public String toString() {
        return "Item --> Name: " + name + ", price: " + price + ", wear: " + wear + ".";
    }

}
