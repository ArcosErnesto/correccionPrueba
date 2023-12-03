package correccionPruebaNivel;

public class Weapon extends Item {

    public Weapon(String name, double price, double wear) {
        super(name, price, wear);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Weapon --> Name: " + super.getName() + ", price: " + super.getPrice() + ", wear: " + super.getWear()
                + ".";
    }

}
