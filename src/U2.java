import java.util.Random;

public class U2 extends Rocket {
    U2() {
        currentWeight = 18000;
        maxWeight = 29000;
        cost = 120;
    }
    public boolean launch() {
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        double prob = ((double) this.currentWeight/this.maxWeight) * .04;
        return (randomNumber > prob);
    }

    public boolean land() {
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        double prob = ((double) this.currentWeight/this.maxWeight) * .08;
        return (randomNumber > prob);
    }
}
