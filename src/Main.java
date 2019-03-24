import java.util.List;

public class Main {
    public static void main(String [] args) {
        System.out.println("Simulation started...");
        Simulation simulation = new Simulation();

        List<Item> items1 = simulation.loadItems("phase-1.txt");
        System.out.println("Phase 1 loaded...");
        List<Item> items2 = simulation.loadItems("phase-2.txt");
        System.out.println("Phase 2 loaded...");

        List<Rocket> loadedRocket1 = simulation.loadU1(items1);
        System.out.println("Phase 1 U1 loaded...");
        List<Rocket> loadedRocket2 = simulation.loadU1(items2);
        System.out.println("Phase 2 U1 loaded...");

        int u1Phase1Cost = simulation.runSimulation(loadedRocket1);
        int u1Phase2Cost = simulation.runSimulation(loadedRocket2);

        System.out.println("U1 phase complete.");
        System.out.print("Total cost: ");
        System.out.println(u1Phase1Cost + u1Phase2Cost);
        System.out.print("Total Rockets: ");
        System.out.println((u1Phase1Cost + u1Phase2Cost)/loadedRocket1.get(0).cost);

        List<Rocket> loadedRocket3 = simulation.loadU2(items1);
        System.out.println("Phase 1 U1 loaded...");
        List<Rocket> loadedRocket4 = simulation.loadU2(items2);
        System.out.println("Phase 2 U1 loaded...");

        int u2Phase1Cost = simulation.runSimulation(loadedRocket3);
        int u2Phase2Cost = simulation.runSimulation(loadedRocket4);

        System.out.println("U2 phase complete.");
        System.out.print("Total cost: ");
        System.out.println(u2Phase1Cost + u2Phase2Cost);
        System.out.print("Total Rockets: ");
        System.out.println((u2Phase1Cost + u2Phase2Cost)/loadedRocket3.get(0).cost);    }
}
