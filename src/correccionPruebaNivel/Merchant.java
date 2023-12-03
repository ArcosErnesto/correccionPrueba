package correccionPruebaNivel;

import java.util.List;

public class Merchant extends Seller{
    public static final double TAX = 1.4;
    public static final int SIZE_INVENTORY = 7;

    public Merchant(String name, City city) {
        super(name, city);
    }

    public static double getTax() {
        return TAX;
    }

    public static int getSizeInventory() {
        return SIZE_INVENTORY;
    }
    public void loadDataItem(Item item) {
        double taxedPrice = item.getPrice() * TAX;
        taxedPrice = Math.round(taxedPrice*100.0)/100.0;
        Item adjustedItem = new Item(item.getName(), taxedPrice, item.getWear());

        try {
            addToInventory(adjustedItem);
        } catch (InventoryFullException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void addItem(Item item) {
        double taxedPrice = item.getPrice() * TAX;
        taxedPrice = Math.round(taxedPrice*100.0)/100.0;
        Item adjustedItem = new Item(item.getName(), taxedPrice, item.getWear());

        try {
            addToInventory(adjustedItem);
            System.out.println("Añadido "+adjustedItem.getName()+" a "+super.getName()+".");
        } catch (InventoryFullException e) {
            System.out.println(e.getMessage());
        }
    }
    private void addToInventory(Item adjustedItem) throws InventoryFullException {
        if (getInventory().size() < SIZE_INVENTORY) {
            getInventory().add(adjustedItem);
        } else {
            throw new InventoryFullException("Inventario lleno! - El vendedor no puede comprar el ítem");
        }
    }

    @Override
    public void sellItem() {

    }

    @Override
    public String toString() {
        return "Merchant --> Name: " + super.getName() + ", city: " + super.getCity().getName() + ", inventory: " + super.getInventory() + ".";
    }
}
