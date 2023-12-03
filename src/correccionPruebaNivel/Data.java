package correccionPruebaNivel;

import java.util.ArrayList;

public class Data {
    public static void loadData(ArrayList<City> cities, ArrayList<Item> items){
        //Crear ciudades
        City eterion = new City("Eterion");
        City luminara = new City("Luminara");
        City sombriael = new City("Sombriael");
        //Carga de cuidades
        cities.add(eterion);
        cities.add(luminara);
        cities.add(sombriael);
        //Crear items
        Weapon sword = new Weapon("Excalibur", 100.0, 0.2);
        Weapon dagger = new Weapon("Steel Dagger", 20.0, 0.5);
        Weapon bow = new Weapon("Elven Bow", 150.0, 0.1);
        Weapon staff = new Weapon("Mage Staff", 80.0, 0.3);
        Weapon axe = new Weapon("Battle Axe", 120.0, 0.4);
        Armor plateArmor = new Armor("Plate Mail", 150.0, 0.2);
        Armor leatherArmor = new Armor("Leather Jacket", 50.0, 0.5);
        Armor chainmail = new Armor("Chainmail Vest", 80.0, 0.3);
        Armor cloak = new Armor("Invisibility Cloak", 200.0, 0.1);
        Armor helmet = new Armor("Steel Helmet", 30.0, 0.4);
        Potion healingPotion = new Potion("Healing Elixir", 20.0, 0.1);
        Potion manaPotion = new Potion("Mana Potion", 15.0, 0.05);
        Potion strengthPotion = new Potion("Strength Boost", 30.0, 0.2);
        Potion invisibilityPotion = new Potion("Invisibility Brew", 50.0, 0.15);
        Potion speedPotion = new Potion("Speed Elixir", 25.0, 0.08);
        //Carga de items
        items.add(sword);
        items.add(dagger);
        items.add(bow);
        items.add(staff);
        items.add(axe);
        items.add(plateArmor);
        items.add(leatherArmor);
        items.add(chainmail);
        items.add(cloak);
        items.add(helmet);
        items.add(healingPotion);
        items.add(manaPotion);
        items.add(strengthPotion);
        items.add(invisibilityPotion);
        items.add(speedPotion);
        //Carga de vendedores
        Farmer farmerEterion = new Farmer("John the Farmer", eterion);
        eterion.addSeller(farmerEterion);
        Farmer farmerLuminara = new Farmer("Anna the Farmer", luminara);
        luminara.addSeller(farmerLuminara);
        Farmer farmerSombriael = new Farmer("Mike the Farmer", sombriael);
        sombriael.addSeller(farmerSombriael);
        Thief thiefEterion = new Thief("Shadow the Thief", eterion);
        eterion.addSeller(thiefEterion);
        Thief thiefLuminara = new Thief("Rogue the Thief", luminara);
        luminara.addSeller(thiefLuminara);
        Thief thiefSombriael = new Thief("Stealth the Thief", sombriael);
        sombriael.addSeller(thiefSombriael);
        Merchant merchantEterion = new Merchant("Marco the Merchant", eterion);
        eterion.addSeller(merchantEterion);
        Merchant merchantLuminara = new Merchant("Sophia the Merchant", luminara);
        luminara.addSeller(merchantLuminara);
        Merchant merchantSombriael = new Merchant("Antonio the Merchant", sombriael);
        sombriael.addSeller(merchantSombriael);
        //Carga de items en vendedores
        farmerEterion.loadDataItem(sword);
        farmerEterion.loadDataItem(speedPotion);
        farmerEterion.loadDataItem(cloak);
        farmerEterion.loadDataItem(axe);
        farmerEterion.loadDataItem(helmet);
        farmerLuminara.loadDataItem(bow);
        farmerLuminara.loadDataItem(leatherArmor);
        farmerLuminara.loadDataItem(manaPotion);
        farmerSombriael.loadDataItem(staff);
        farmerSombriael.loadDataItem(strengthPotion);
        farmerSombriael.loadDataItem(plateArmor);
        farmerSombriael.loadDataItem(sword);
        thiefEterion.loadDataItem(bow);
        thiefLuminara.loadDataItem(healingPotion);
        thiefLuminara.loadDataItem(dagger);
        thiefLuminara.loadDataItem(chainmail);
        thiefSombriael.loadDataItem(staff);
        thiefSombriael.loadDataItem(manaPotion);
        merchantEterion.loadDataItem(helmet);
        merchantEterion.loadDataItem(bow);
        merchantEterion.loadDataItem(leatherArmor);
        merchantEterion.loadDataItem(manaPotion);
        merchantEterion.loadDataItem(staff);
        merchantLuminara.loadDataItem(sword);
        merchantLuminara.loadDataItem(bow);
        merchantLuminara.loadDataItem(healingPotion);
        merchantSombriael.loadDataItem(strengthPotion);
        merchantSombriael.loadDataItem(plateArmor);
        merchantSombriael.loadDataItem(sword);
        merchantSombriael.loadDataItem(bow);
        merchantSombriael.loadDataItem(healingPotion);
        merchantSombriael.loadDataItem(dagger);
        merchantSombriael.loadDataItem(chainmail);
        //Carga de compradores
        Buyer buyerEterion = new Buyer("Alice", eterion, 0.0);
        eterion.addBuyer(buyerEterion);
        Buyer buyerLuminara = new Buyer("Bob", luminara, 1500.0);
        luminara.addBuyer(buyerLuminara);
        Buyer buyerSombriael = new Buyer("Charlie", sombriael, 1200.0);
        sombriael.addBuyer(buyerSombriael);
        //Carga de items en compradores
        buyerEterion.getInventory().add(sword);
        buyerEterion.getInventory().add(plateArmor);
        buyerEterion.getInventory().add(healingPotion);
        buyerLuminara.getInventory().add(dagger);
        buyerLuminara.getInventory().add(leatherArmor);
        buyerLuminara.getInventory().add(manaPotion);
        buyerSombriael.getInventory().add(bow);
        buyerSombriael.getInventory().add(chainmail);
        buyerSombriael.getInventory().add(strengthPotion);

        System.out.println("Datos cargados");
    }
}
