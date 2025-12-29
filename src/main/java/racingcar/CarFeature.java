package racingcar;

import java.util.Random;

public class CarFeature {

    Car car;
    int distance;

    public CarFeature(Car car) {
        this.car = car;
    }

    public void move() {
        car.count -= 1;

        Random rand = new Random();
        int randNum = rand.nextInt(10);

        if(randNum >= 4) {
            distance += 1;
        }
    }
}
