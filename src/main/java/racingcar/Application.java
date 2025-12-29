package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = sc.nextLine();
            String[] carName = carNames.split(",");

            Car[] cars = new Car[carName.length];
            CarFeature[] carFeatures = new CarFeature[carName.length];

            for (int i = 0; i < carName.length; i++) {
                String name = carName[i].trim();
                if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
                if (name.isEmpty()) throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
                cars[i] = new Car(name);
                carFeatures[i] = new CarFeature(cars[i]);
            }

            System.out.println("시도할 회수는 몇회인가요?");
            if (!sc.hasNextInt()) throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
            int tryCount = sc.nextInt();

            for (int i = 0; i < cars.length; i++) {
                cars[i].addCount(tryCount);
            }

            CarView carView = new CarView();

            for(int i = 0; i < tryCount; i++) {
                for(int j = 0; j < cars.length; j++) {
                    carFeatures[j].move();
                    carView.view(cars[j]);
                }
                System.out.println();
            }

            int max = 0;
            List<String> winerList = new ArrayList<>();

            for(int i = 0; i < cars.length; i++) {
                if(cars[i].distance > max) {
                    max = cars[i].distance;
                    winerList.clear();
                    winerList.add(cars[i].name);
                } else if(cars[i].distance == max) {
                    winerList.add(cars[i].name);
                }
            }

            System.out.print("최종 우승자 : ");
            System.out.println(String.join(", ", winerList));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
