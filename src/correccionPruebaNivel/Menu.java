package correccionPruebaNivel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public Menu() {
    }

    public void getMainMenu(ArrayList<City> cities, ArrayList<Item> items) {
        boolean exit = false;

        do {
            switch (mainMenu()) {
                case 1:
                    createSeller(cities);
                    break;
                case 2:
                    addItemToSeller(cities, items);
                    break;
                case 3:
                    cheapestItemInCity(cities);
                    break;
                case 4:
                    querySellerItems(cities);
                    break;
                case 5:
                    createBuyer(cities);
                    break;
                case 6:
                    buyItemFromSeller(cities);
                    break;
                case 7:
                    queryBuyerItems(cities);
                    break;
                case 8:
                    querySellersCity(cities);
                    break;
                case 9:
                    queryBuyersCity(cities);
                    break;
                case 10:
                    MethodNotImplemented();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    exit = true;
                    break;
            }
        } while (!exit);
    }


    public static byte mainMenu() {
        byte option;
        final byte MIN = 0;
        final byte MAX = 10;

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1.  Crear un vendedor.");
            System.out.println("2.  Añadir un item al inventario de un vendedor.");
            System.out.println("3.  Mostrar el ítem más barato de todos los vendedores de una ciudad.");
            System.out.println("4.  Consultar los ítems de un vendedor.");
            System.out.println("5.  Crear un comprador.");
            System.out.println("6.  Realizar la compra de un ítem.");
            System.out.println("7.  Consultar los ítems de un Comprador.");
            System.out.println("8.  Consultar todos los vendedores que hay en una ciudad.");
            System.out.println("9.  Consultar todos los compradores que hay en una ciudad.");
            System.out.println("10. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc).");
            System.out.println("0.  Salir de la aplicación.\n");
            option = sc.nextByte();
            sc.nextLine();
            if (option < MIN || option > MAX) {
                System.out.println("Opción no válida");
            }
        } while (option < MIN || option > MAX);
        return option;
    }

    public static void createSeller(ArrayList<City> cities) {
        System.out.println("Indica la ciudad del vendedor:");
        City foundedCity = City.foundCity(cities);
        System.out.println("Indica el nombre del vendedor:");
        String inputName = sc.nextLine();
        Seller seller = chooseTypeSeller(inputName, foundedCity);
        foundedCity.addSeller(seller);
        System.out.println("Creado nuevo vendedor:");
        System.out.println(seller);
    }

    public static void addItemToSeller(ArrayList<City> cities, ArrayList<Item> items){
        System.out.println("Indica la ciudad del vendedor:");
        City foundedCity = City.foundCity(cities);
        Seller foundedSeller = Seller.fonudSeller(foundedCity);
        Item item = Item.foundItem(items);
        foundedSeller.addItem(item);

    }

    public static void cheapestItemInCity (ArrayList<City> cities){
        ArrayList<Item> itemsInCity = new ArrayList<Item>();
        System.out.println("Indica la ciudad:");
        City foundedCity = City.foundCity(cities);
        itemsInCity = foundedCity.allItemsInCity();
        itemsInCity.stream()
                .min(Comparator.comparingDouble(Item::getPrice))
                .ifPresent(cheapestItem -> System.out.println("El ítem más barato es: " + cheapestItem));

    }

    public static void querySellerItems(ArrayList<City> cities){
        System.out.println("Indica la ciudad del vendedor:");
        City foundedCity = City.foundCity(cities);
        Seller foundedSeller = Seller.fonudSeller(foundedCity);
        System.out.println("Los items de "+foundedSeller.getName()+" son:");
        foundedSeller.getInventory().forEach(item -> System.out.println("-"+item));
    }

    public static void createBuyer(ArrayList<City> cities) {
        System.out.println("Indica la ciudad del comprador:");
        City foundedCity = City.foundCity(cities);
        System.out.println("Indica el nombre del comprador:");
        String inputName = sc.nextLine();
        System.out.println("Indica el saldo inicial:");
        double balance = sc.nextDouble();
        sc.nextLine();
        Buyer buyer = new Buyer(inputName,foundedCity, balance);
        foundedCity.addBuyer(buyer);
        System.out.println("Creado nuevo comprador:");
        System.out.println(buyer);
    }

    public static void buyItemFromSeller(ArrayList<City> cities){
        System.out.println("Indica la ciudad del comprador:");
        City buyerCity = City.foundCity(cities);
        Buyer foundedBuyer = Buyer.fonudBuyer(buyerCity);
        System.out.println("Indica la ciudad del vendedor:");
        City sellerCity = City.foundCity(cities);
        Seller foundedSeller = Seller.fonudSeller(sellerCity);
        ArrayList<Item> sellerList = (ArrayList<Item>) foundedSeller.getInventory();
        Item choosedItem = Item.foundItemFromSeller(sellerList);
        boolean purchasedItem = foundedBuyer.buyItem(choosedItem, foundedSeller);
        if(purchasedItem){
            foundedSeller.getInventory().remove(choosedItem);
        }
    }

    public static void queryBuyerItems(ArrayList<City> cities){
        System.out.println("Indica la ciudad del comprador:");
        City foundedCity = City.foundCity(cities);
        Buyer foundedBuyer = Buyer.fonudBuyer(foundedCity);
        foundedBuyer.getInventory().forEach(item -> System.out.println("-"+item));
    }

    public void querySellersCity(ArrayList<City> cities) {
        System.out.println("Indica la ciudad del vendedor:");
        City foundedCity = City.foundCity(cities);
        System.out.println("Vendedores de la ciudad "+ foundedCity.getName()+":");
        foundedCity.getSellers().forEach(seller -> System.out.println("-"+seller.getName()));
    }

    public void queryBuyersCity(ArrayList<City> cities) {
        System.out.println("Indica la ciudad del comprador:");
        City foundedCity = City.foundCity(cities);
        System.out.println("Compradores de la ciudad "+ foundedCity.getName()+":");
        foundedCity.getBuyers().forEach(buyer -> System.out.println("-"+buyer.getName()));
    }


    private static Seller chooseTypeSeller(String inputName, City foundedCity) {
        boolean exit = false;
        Seller seller = null;

        do {
            switch (menuSeller()) {
                case 1:
                    seller = new Farmer(inputName, foundedCity);
                    exit = true;
                    break;
                case 2:
                    seller = new Thief(inputName, foundedCity);
                    exit = true;
                    break;
                case 3:
                    seller = new Merchant(inputName, foundedCity);
                    exit = true;
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
        return seller;
    }

    public static byte menuSeller() {
        byte option;
        final byte MIN = 0;
        final byte MAX = 3;

        do {
            System.out.println("\nEscoge el tipo de vendedor:");
            System.out.println("1. Campesino.");
            System.out.println("2. Ladrón.");
            System.out.println("3. Mercader.");
            System.out.println("0. Volver al menú principal.");
            option = sc.nextByte();
            sc.nextLine();
            if (option < MIN || option > MAX) {
                System.out.println("Opción no válida");
            }
        } while (option < MIN || option > MAX);
        return option;
    }

    public static Item chooseTypeItem(ArrayList<Item> items) {
        boolean exit = false;
        Item choosedTypeItem = null;
        int i = 0;

        do {
            switch (menuItem()) {
                case 1:
                    while (i < items.size() && choosedTypeItem == null){
                        if(items.get(i) instanceof Weapon) {
                            choosedTypeItem = items.get(i);
                        }
                        i++;
                    }
                    exit = true;
                    break;
                case 2:
                    for (Item item: items) {
                        if(item instanceof Armor){
                            choosedTypeItem=item;
                            break;
                        }
                    }
                    exit = true;
                    break;
                case 3:
                    for (Item item: items) {
                        if(item instanceof Potion){
                            choosedTypeItem=item;
                            break;
                        }
                    }
                    exit = true;
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
        return choosedTypeItem;
    }

    public static byte menuItem() {
        byte option;
        final byte MIN = 0;
        final byte MAX = 3;

        do {
            System.out.println("\nEscoge el tipo de item:");
            System.out.println("1. Arma.");
            System.out.println("2. Armadura.");
            System.out.println("3. Poción.");
            System.out.println("0. Volver al menú principal.");
            option = sc.nextByte();
            sc.nextLine();
            if (option < MIN || option > MAX) {
                System.out.println("Opción no válida");
            }
        } while (option < MIN || option > MAX);
        return option;
    }
    public static void MethodNotImplemented() {

        System.out.println("Método no implementado.");
    }
}
