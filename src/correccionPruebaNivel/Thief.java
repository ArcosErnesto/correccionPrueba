package correccionPruebaNivel;

import java.util.List;

public class Thief extends Seller {
    public static final double WEAR = 1.25;
    public static final int SIZE_INVENTORY = 3;

    public Thief(String name, City city) {
        super(name, city);
    }

    public static double getWear() {
        return WEAR;
    }

    public static int getSizeInventory() {
        return SIZE_INVENTORY;
    }
    @Override
    public void loadDataItem(Item item) {
        double wornWear = item.getWear() * WEAR;
        wornWear = Math.round(wornWear*100.0)/100.0;
        Item adjustedItem = new Item(item.getName(), item.getPrice(), wornWear);

        try {
            addToInventory(adjustedItem);
        } catch (InventoryFullException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void addItem(Item item) {
        double wornWear = item.getWear() * WEAR;
        wornWear = Math.round(wornWear*100.0)/100.0;
        Item adjustedItem = new Item(item.getName(), item.getPrice(), wornWear);

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
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "Thief --> Name: " + super.getName() + ", city: " + super.getCity().getName() + ", inventory: " + super.getInventory() + ".";
    }

}
