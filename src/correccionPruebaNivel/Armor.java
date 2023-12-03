package correccionPruebaNivel;

public class Armor extends Item {

    public Armor(String name, double price, double wear) {
        super(name, price, wear);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Armor --> Name: " + super.getName() + ", price: " + super.getPrice() + ", wear: " + super.getWear()
                + ".";
    }

}