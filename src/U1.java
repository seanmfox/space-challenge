import java.util.Random;

public class U1 extends Rocket {
    U1() {
        currentWeight = 10000;
        maxWeight = 18000;
        cost = 100;
    }

    public boolean launch() {
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        double prob = ((double) this.currentWeight/this.maxWeight) * .05;
        return (randomNumber > prob);
    }

    public boolean land() {
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        double prob = ((double) this.currentWeight/this.maxWeight) * .01;
        return (randomNumber > prob);
    }
}
