package racingcar.controller;

import racingcar.model.*;
import racingcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public void run() {
        try {
            String[] carNames = InputView.getCarNames();
            int tryCount = InputView.getTryCount();

            List<Car> carList = new ArrayList<>();
            for (String name : carNames) {
                carList.add(new Car(name.trim()));
            }
            Cars cars = new Cars(carList);

            System.out.println("\n실행 결과");
            for (int i = 0; i < tryCount; i++) {
                cars.playRound();
                ResultView.printRoundResult(cars);
            }

            ResultView.printWinners(cars.findWinners());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}