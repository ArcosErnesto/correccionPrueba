package correccionPruebaNivel;

public class Potion extends Item {

    public Potion(String name, double price, double wear) {
        super(name, price, wear);
    }

    @Override
    public String toString() {
        return "Potion --> Name: " + super.getName() + ", price: " + super.getPrice() + ", wear: " + super.getWear()
                + ".";
    }
}
