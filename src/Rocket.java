public class Rocket implements SpaceShip {
    int currentWeight;
    int maxWeight;
    int cost;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return ((this.currentWeight + item.getWeight()) <= this.maxWeight);
    }

    public void carry(Item item) {
        this.currentWeight += item.getWeight();
    }

    public int getCost() {
        return this.cost;
    }
}
