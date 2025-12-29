package racingcar;

public class CarView {

    Car car;

    public void view(Car car) {
        System.out.print(car.name + " : ");
        for (int i = 0; i < car.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
