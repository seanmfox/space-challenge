import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Simulation {
    List<Item> loadItems(String phase) {
        List<Item> newItems = new ArrayList<>();
        File file = new File(phase);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String object = scanner.nextLine();
                String[] parsed = object.split("=");
                Item currentItem = new Item(Integer.valueOf(parsed[1]));
                newItems.add(currentItem);
            }
        } catch (
                FileNotFoundException exception) {
            System.out.println("File not found");
        }

        return newItems;
    }

    List<Rocket> loadU1(List<Item> items) {
        List<Rocket> rocketLoad = new ArrayList<>();
        U1 ship = new U1();
        for(Item i: items){
            if(ship.canCarry(i)){
                ship.carry(i);
            } else {
                rocketLoad.add(ship);
                ship = new U1();
                ship.carry(i);
            }
        }
        rocketLoad.add(ship);
        return rocketLoad;
    }

    List<Rocket> loadU2(List<Item> items) {
        List<Rocket> rocketLoad = new ArrayList<>();
        U2 ship = new U2();
        for(Item i: items){
            if(ship.canCarry(i)){
                ship.carry(i);
            } else {
                rocketLoad.add(ship);
                ship = new U2();
                ship.carry(i);
            }
        }
        rocketLoad.add(ship);
        return rocketLoad;
    }

    int runSimulation(List<Rocket> rockets){
        int totalCost = 0;
        int perUnitCost = rockets.get(0).cost;
        for(Rocket r: rockets){
                totalCost += perUnitCost;
            while(!r.land() || !r.launch()) {
                totalCost += perUnitCost;
                System.out.println("Failed....");
            }
            System.out.println("Rocket successful!");
        }
        return totalCost;
    }
}
